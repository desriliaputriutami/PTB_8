package com.example.a8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;

import android.content.DialogInterface;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.example.a8.models.MessageClass;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.a8.retrofit.TugasClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-Debug";
    public ImageButton imageButton5, imageButton6, imageButton7, imageButton8;;
    String token;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

    }



    //==================<buat log out>===========================
    public void kembali_landing(View view) {

        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Yakin mau keluar?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String API_BASE_URL = "http://ptb-api.husnilkamil.my.id/";
                        Retrofit retrofit = new Retrofit.Builder()

                                .baseUrl(API_BASE_URL)
                                .addConverterFactory( GsonConverterFactory.create() )
                                .client( new OkHttpClient.Builder().build() )
                                .build();

                        TugasClient logout = retrofit.create(TugasClient.class);

                        Call<MessageClass> call = logout.logout(token);

                        call.enqueue(new Callback<MessageClass>() {




                            @Override
                            public void onResponse(Call<MessageClass> call, retrofit2.Response<MessageClass> response) {
                                if (response.code() == 200){
                                    if (response.isSuccessful()){

                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        finish();
                                        startActivity(intent);
                                    }
                                }

                            }

                            @Override
                            public void onFailure(Call<MessageClass> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .show();
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
    //===========================================================


    public void logoutClick(View view) {
        Intent detailIntent = new Intent (this,Login.class);
        startActivity(detailIntent);
    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());
        //Register for menu item click listener
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return onPopupMenuClick(menuItem);
            }
        });
        popupMenu.show();
    }
    private boolean onPopupMenuClick(MenuItem item){
            int id = item.getItemId();
            if (id == R.id.item1){
                Intent i = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
                finish();
                return true;
            }
            if (id == R.id.item2){
                Intent i = new Intent(MainActivity.this, PermintaanActivity.class);
                startActivity(i);
                finish();
                return true;
            }
            if (id == R.id.item3){
                Intent i = new Intent(MainActivity.this,ListPermintaanSidang.class);
                startActivity(i);
                finish();
                return true;
            }
            if (id == R.id.item4){
                Intent i = new Intent(MainActivity.this, PermintaanActivity.class);
                startActivity(i);
                finish();
                return true;
            }
        if (id == R.id.item5){
            Intent i = new Intent(MainActivity.this, ListMahasiswaTA.class);
            startActivity(i);
            finish();
            return true;
        }
        return true;
    }
}