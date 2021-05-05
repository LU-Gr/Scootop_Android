package fr.scootop.app;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import fr.scootop.BuildConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by ludovicriviere on 13/02/2018.
 */
public class ScootopApplication extends Application
{
    private static Context sContext;

    @Override
    public void onCreate()
    {
        super.onCreate();
        if (!BuildConfig.DEBUG) {
            Fabric.with(this, new Crashlytics());
        }
        sContext = this;
    }

    public static Context getContext()
    {
        return sContext;
    }
}
