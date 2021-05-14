package fr.scootop.app;

import android.app.Application;
import android.content.Context;

//import com.crashlytics.android.Crashlytics; 06/05/21
import com.google.firebase.analytics.FirebaseAnalytics;

import fr.scootop.BuildConfig;
//import io.fabric.sdk.android.Fabric;  06/05/21

public class ScootopApplication extends Application
{
    private static Context sContext;

    @Override
    public void onCreate()
    {
        super.onCreate();
        if (!BuildConfig.DEBUG) {
            //Fabric.with(this, new FirebaseAnalytics());
        }
        sContext = this;
    }

    public static Context getContext()
    {
        return sContext;
    }
}
