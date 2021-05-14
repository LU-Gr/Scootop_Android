package fr.scootop.app.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import 	androidx.core.content.ContextCompat;

import androidx.annotation.Nullable;

import java.util.Map;

import fr.scootop.R;
import fr.scootop.app.launch.LaunchActivity;

public final class NotificationFactory
{
    public static final int REQUEST_CODE = 100;

    private NotificationCompat.Builder getBuilder(Context context, String title, String body, @Nullable String deeplink)
    {
        Intent intent = new Intent(context, LaunchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, REQUEST_CODE, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        return new NotificationCompat.Builder(context, context.getString(R.string.default_notification_channel_id))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setContentTitle(title)
                .setContentText(body)
                .setSound(defaultSound)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                ;
    }

    public Notification getDefaultNotification(Context context, String title, String body, Map<String, String> data)
    {
        return getBuilder(context, title, body, null)
            .setVibrate(new long[]{1000, 0, 1000, 0, 1000})
            .setLights(ContextCompat.getColor(context, R.color.colorPrimary), 3000, 3000)
            .build();
    }

    public Notification getShortlistNotification(Context context, String title, String body, Map<String, String> data)
    {
        String deeplink = null; //new DeeplinkFactory().getLink(DeeplinkFactory.Type.SHORTLIST);

        String contextualTitle = context.getString(R.string.notification_shortlist_title);
        String contextualBody = context.getString(R.string.notification_shortlist_body);

        return getBuilder(context, contextualTitle, contextualBody, deeplink)
                .setVibrate(new long[]{1000, 0, 1000, 0, 1000})
                .setLights(ContextCompat.getColor(context, R.color.colorPrimary), 3000, 3000)
                .build();
    }
}
