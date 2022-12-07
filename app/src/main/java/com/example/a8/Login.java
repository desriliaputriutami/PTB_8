package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    //notifikasi
    //1. deklarasi objek
    private static final String CHANNEL_ID="Kelompok 3";
    private Button btn_login;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //2. panggil objek
        btn_login = findViewById(R.id.btn_login);
        notificationManager= NotificationManagerCompat.from(this);

        //create channel
        createNotificationChannel();

        //3. buat onclick listener
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, MainActivity.class);
                TaskStackBuilder stackBuilder= TaskStackBuilder.create(Login.this);
                stackBuilder.addNextIntentWithParentStack(i);
                PendingIntent resultPendingIntent=
                        stackBuilder.getPendingIntent(0,
                                PendingIntent.FLAG_UPDATE_CURRENT| PendingIntent.FLAG_IMMUTABLE);

                //5. buat builder varnya
                NotificationCompat.Builder builder  = new NotificationCompat.Builder(Login.this, CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_account)
                        .setContentTitle("Yeay login berhasil")
                                .setContentText("Selamat")
                        .addAction(R.drawable.ic_account,"login", resultPendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                //Toast.makeText(Login.this, "Anda Berhasil Login", Toast.LENGTH_SHORT).show();

                //6. Buat objek notifikasi
                //Notification notification= builder.build();

                //7. Tampilkan notifikasi
                notificationManager.notify(102, builder.build());

                Intent a = new Intent(Login.this, MainActivity.class);
                startActivity(a);
            }
        });
    }

    //4. Buat channel id nya
    private void createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Contoh Notifikasi";
            String description = "ini contoh notifikasi manual";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showPopupMenu(View view) {
    }

    public void logoutClick(View view) {
        Intent detailIntent = new Intent (this,Login.class);
        startActivity(detailIntent);
    }
}