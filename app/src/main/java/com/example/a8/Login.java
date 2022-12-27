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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

//import com.example.a8.models.loginResponse;
import com.google.android.material.button.MaterialButton;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity {


    //notifikasi
    //1. deklarasi objek
    private static final String CHANNEL_ID="Kelompok 8";
    private Button btn_login;
    private NotificationManagerCompat notificationManager;

    private EditText inputEmail;
    private EditText inputPassword;
    private Config config;


    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.editUsername);
        inputPassword = findViewById(R.id.editPassword);

        test();
    }


    //=================<<validasi username dan password >>========================
    public void toHome(View view){
        String email = inputEmail.getText().toString(). trim();
        String password = inputPassword.getText().toString().trim();

        if(validation(email, password).equals(1)){
            config = new Config();
            Call<LoginResponse> call = config.configRetrofit().login(email, password);
            toggleViewProgressBar(true);
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    String message = null;
                    JSONObject jsonObject = null;

                    if(response.code() == 200){
                        if (response.isSuccessful()){
                            LoginResponse loginResponse = response.body();
                            String token = loginResponse.getAuthorisation().getToken();
                            String nama = loginResponse.getUser().getUsername();
                            String email = loginResponse.getUser().getEmail();
//                            String no_hp = loginResponse.getUser().get();
                            message = loginResponse.getStatus();

                            SharedPreferences sharedPreferences = getSharedPreferences("com.nongskuy.nongskuy.PREFS", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("Token", token);
                            editor.putString("Nama", nama);
                            editor.putString("Email", email);
                          //  editor.putString("NoHp", no_hp);
                            editor.apply();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                    else if(response.code() == 400){
                        if(!response.isSuccessful()) {
                            try {
                                jsonObject = new JSONObject(response.errorBody().string());
                                message = jsonObject.getString("message");
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    else if(response.code() == 403){
                        if(!response.isSuccessful()){
                            try {
                                jsonObject = new JSONObject(response.errorBody().string());
                                message = jsonObject.getString("message");
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    // menampilkan pesan
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                    toggleViewProgressBar(false);
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    toggleViewProgressBar(false);
                }
            });
        }
    }
    //============================================================================


    public void toggleViewProgressBar(Boolean active) {
        Button buttonLogin = findViewById(R.id.btn_login);
        ProgressBar progressBar = findViewById(R.id.progressBarLogin);

        if(active){
            inputEmail.getText().clear();
            inputPassword.getText().clear();
            inputEmail.setEnabled(false);
            inputPassword.setEnabled(false);
            buttonLogin.setEnabled(false);
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            inputEmail.setEnabled(true);
            inputPassword.setEnabled(true);
            buttonLogin.setEnabled(true);
            progressBar.setVisibility(View.GONE);
        }
    }



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







    public Integer validation(String email, String password) {
        Integer valid = 1;
        if(email.isEmpty()){
            inputEmail.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_IN);
            inputEmail.setError("Masukkan email!");
            valid = 0;
        }
        else{
            inputEmail.getBackground().setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        }

        if(password.isEmpty()){
            inputPassword.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
            inputPassword.setError("Masukkan password");
            valid = 0;
        }
        else{
            inputPassword.getBackground().setColorFilter(getResources().getColor(R.color.yellow), PorterDuff.Mode.SRC_ATOP);
        }

        return valid;
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