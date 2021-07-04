package fr.scootop.app.push;

import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;
import java.util.Random;

import fr.scootop.R;
import fr.scootop.app.notification.NotificationFactory;

public class ScootopMessagingService extends FirebaseMessagingService
{
    private static final String TAG = "Scootop-Push";

    private static final String KEY_EVENT_NAME = "event";
    private static final String KEY_USER_ID = "user_id";

    private static final String EVENT_SHORTLIST = "shortlist";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
//        Log.d(TAG, "From: " + remoteMessage.getFrom());
//
//        // Check if message contains a data payload.
//        if (remoteMessage.getData().size() > 0) {
//            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
//
//            if (/* Check if data needs to be processed by long running job */ true) {
//                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
//                //scheduleJob();
//            } else {
//                // Handle message within 10 seconds
//                //handleNow();
//            }
//
//        }

        /* notification builder + vibrate (w/ permission) */

        // Check if message contains a notification payload.
        final RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            Log.d(TAG, "Message Notification Body: " + notification.getBody());

            final Context context = getApplicationContext();

            String title = notification.getTitle();
            if (title == null) {
                title = context.getString(R.string.default_notification_title);
            }

            String body = notification.getBody();
            if (body == null) {
                body = context.getString(R.string.default_notification_body);
            }

            // Also if you intend on generating your own notifications as a result of a received FCM
            // message, here is where that should be initiated. See sendNotification method below.
            final Map<String, String> data = remoteMessage.getData();
            if (data != null) {

                NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (manager == null) {
                    return;
                }

                String eventName = data.get(KEY_EVENT_NAME);
                int randInt = new Random().nextInt();
                NotificationFactory factory = new NotificationFactory();

                if (EVENT_SHORTLIST.equalsIgnoreCase(eventName)) {
                    manager.notify(randInt, factory.getShortlistNotification(context, title, body, data));
                } else {
                    manager.notify(randInt, factory.getDefaultNotification(context, title, body, data));
                }

                /*
                'user_id' => $ownerUser->getId(),
                'context_type' => $ownerUser->getType(),
                'event' => 'shortlist'
                 */
            }
        }

    }
}
