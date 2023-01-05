package com.example.a8;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CHANNEL_ID="test_kanal";
    private static final String TAG="Service-Debug";
    private NotificationManagerCompat notificationManager;

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //notificationManager  ;
        displayNotification(remoteMessage.getNotification());

    }

    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //CharSequence name = "Contoh Notifikasi";
            //String description = "ini contoh notifikasi manual";
            //int importance = NotificationManager.IMPORTANCE_DEFAULT;
            //channel.setDescription(description);
            // notificationManager.createNotificationChannel(channel);
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Kanal Contoh",NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("ini hanya kanal untuk notifikasi");
            NotificationManagerCompat.from(this).createNotificationChannel(channel);
        }
        Intent i = new Intent(this, PermintaanActivity.class);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(i);
        PendingIntent resultPendingIntent=
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT| PendingIntent.FLAG_IMMUTABLE);

        //5. buat builder varnya
        NotificationCompat.Builder builder  = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_check)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setContentIntent(resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        //7. Tampilkan notifikasi
        NotificationManagerCompat.from(this).notify(102, builder.build());
    }
}