package com.example.a8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.TaskStackBuilder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

//import com.example.a8.models.loginResponse;
import com.example.a8.route.Route;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Login extends AppCompatActivity {


    //notifikasi
    //1. deklarasi objek
    private static final String CHANNEL_ID="Kelompok 8";
    //private Button btn_login;
    private NotificationManagerCompat notificationManager;

    //referensi ibal buat login
    //private EditText inputEmail;
    //private EditText inputPassword;
    //private Config config;

    //buat login
    EditText editEmail, editPassword;   //buat ambil data email dan password yang dimasukkan
    Button btn_login;                   //ngambil object buttonnya


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inputEmail = findViewById(R.id.editUsername);
        //inputPassword = findViewById(R.id.editPassword);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });
    }


    //========================<<validasi username dan password >>=====================================
    public void cekLogin(){
        editEmail = findViewById(R.id.editUsername);
        editPassword = findViewById(R.id.editPassword);
        btn_login = findViewById(R.id.btn_login);


        //abis tu, kita perlu buat handler untuk, ketika di click maka dia akan cek login
        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
        String email = editEmail.getText().toString();          //ambil data email yang di entry kan oleh si pengguna
        String password = editPassword.getText().toString();    //ambil data password yang di entry kan oleh si pengguna



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory( GsonConverterFactory.create() )
                .client( new OkHttpClient.Builder().build() )
                .build();

        Route client = retrofit.create(Route.class);

        //panggil client
        Call<LoginResponse> call = client.login(email, password);
        System.out.println("keprint ini");

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();


                if(loginResponse !=null){                                     //kalo loginresponsnya tidak sama dengan null artinya ada kita dapatkan object nya, kemungkinan besar sukses
                    Toast.makeText(Login.this, "sukses login", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(Login.this,MainActivity.class);    //kalo sukses, akan di arahkan ke activity berikutnya
                    startActivity(mainIntent);
                }else{
                    Toast.makeText(Login.this, "gagal menghubungi server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });




    }



    //============================================================================






    private void test(){
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
        }
        );
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