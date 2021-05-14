package fr.scootop.app.push;

import android.content.Context;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import fr.scootop.data.api.ApiManager;
import fr.scootop.data.model.DeviceToken;
import fr.scootop.data.storage.TokenStorage;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ScootopInstanceIdService extends FirebaseInstanceIdService
{
    private static final String TAG = "Scootop-Push";

    @Override
    public void onTokenRefresh()
    {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        if (refreshedToken == null) {
            return;
        }

        final Context ctx = getApplicationContext();

        if (TokenStorage.get(ctx).getJWT() == null) {
            /* save for later use */
            boolean success = TokenStorage.get(getApplicationContext()).setDeviceToken(refreshedToken);
            Log.d(TAG, "Successful saved in local storage: " + success);
        } else {
            /* send to server */
            registerToken(refreshedToken);
        }
    }

    private void registerToken(String token)
    {
        ApiManager.Companion.get().getDeviceTokenService().postDeviceToken(new DeviceToken(token))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<DeviceToken>()
                {
                    @Override
                    public void call(DeviceToken newDeviceToken)
                    {
                        Log.d(TAG, "" + newDeviceToken);
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
