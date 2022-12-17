package com.example.a8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity-Debug";
    public ImageButton imageButton5, imageButton6, imageButton7, imageButton8;;

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
                        String token = task.getResult();

                        // Log and toast
                        Log.d(TAG, token);
                        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

    }

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
                Intent i = new Intent(MainActivity.this,ListPermintaanTA.class);
                startActivity(i);
                finish();
                return true;
            }
            if (id == R.id.item3){
                Intent i = new Intent(MainActivity.this,ListPermintaanTA.class);
                startActivity(i);
                finish();
                return true;
            }
            if (id == R.id.item4){
                Intent i = new Intent(MainActivity.this,ListPermintaanTA.class);
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