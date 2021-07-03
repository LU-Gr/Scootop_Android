package fr.scootop.app.login

//import com.crashlytics.android.Crashlytics
import android.content.Context
import android.text.TextUtils
import fr.scootop.BuildConfig
import fr.scootop.data.api.ApiManager
import fr.scootop.data.storage.TokenStorage
import fr.scootop.data.storage.UserStorage
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.lang.ref.WeakReference

class LoginInteractor(private val mPresenter: LoginPresenter, context: Context) {

    private val mContext: WeakReference<Context> = WeakReference(context)

    fun login(email: String, password: String) {
        // temp code
        mPresenter.presentHome()
        // temp code

        mPresenter.presentLoading()

        ApiManager.get().userService.login(email, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ loginResult ->
                mPresenter.dismissLoading()

                if (loginResult.code == null && !TextUtils.isEmpty(loginResult.jwt)) {

                    val context = mContext.get()
                    if (null != context) {
                        /* Store JWT and refresh token */
                        TokenStorage.get(context).jwt = loginResult.jwt
                        //TokenStorage.get(context).refreshToken = loginResult.refreshToken

                        /* Store user */
                        UserStorage.get(context).user = loginResult.user

                        if (!BuildConfig.DEBUG) {
                        }
                    }

                    mPresenter.presentHome()
                } else if (loginResult.code != null) {

                    var errorMessage: String
                    if (loginResult.code == 401) {
                        errorMessage = "Email ou mot de passe incorrect"
                    } else {
                        errorMessage = loginResult.message
                    }
                    if (TextUtils.isEmpty(errorMessage)) {
                        errorMessage = "Une erreur s'est produite"
                    }

                    mPresenter.presentError(errorMessage)
                }
            }) { throwable ->
                mPresenter.dismissLoading()

                val errorMessage: String
                if (throwable.localizedMessage.contains("401")) {
                    errorMessage = "Email ou mot de passe incorrect"
                } else {
                    errorMessage = throwable.localizedMessage
                }
                mPresenter.presentError(errorMessage)
            }
    }
}
