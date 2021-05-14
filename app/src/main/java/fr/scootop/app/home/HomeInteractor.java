package fr.scootop.app.home;

import android.content.Context;

import androidx.annotation.Nullable;

import fr.scootop.data.api.ApiManager;
import fr.scootop.data.model.DeviceToken;
import fr.scootop.data.model.User;
import fr.scootop.data.storage.TokenStorage;
import fr.scootop.data.storage.UserStorage;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class HomeInteractor
{
    public HomeInteractor()
    {
    }

    public void initialize(final Context context)
    {
        String waitingDeviceToken = TokenStorage.get(context).getDeviceToken();
        if (waitingDeviceToken != null) {

            ApiManager.Companion.get().getDeviceTokenService()
                                .postDeviceToken(new DeviceToken(waitingDeviceToken))
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Action1<DeviceToken>()
                {
                    @Override
                    public void call(DeviceToken newDeviceToken)
                    {
                        /* remove the device token from cache */
                        TokenStorage.get(context).setDeviceToken(null);
                    }
                }, new Action1<Throwable>()
                {
                    @Override
                    public void call(Throwable throwable)
                    {
                        throwable.printStackTrace();
                    }
                });
        }
    }

    @Nullable
    public Integer getUser(final Context context)
    {
        User user = UserStorage.get(context).getUser();
        if (user != null) {
            return user.getId();
        }
        return null;
    }
}
