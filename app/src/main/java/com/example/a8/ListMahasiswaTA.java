package com.example.a8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.a8.adapters.ListMahasiswaTAAdapter;
import com.example.a8.data.Thesis;
import com.example.a8.models.ThesesData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.example.a8.route.Route;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListMahasiswaTA extends AppCompatActivity implements ListMahasiswaTAAdapter.ItemMahasiswaTAClickListener{

    private RecyclerView rvMahasiswaTA;
    private com.example.a8.models.ListMahasiswaTA mahasiswaTATA;

    private String token;
    private static final String TAG = "ListMahasiswaTA-Debug";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mahasiswata);

        FirebaseMessaging.getInstance().getToken()        //baa caro ma ambiak token
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
                      //  Toast.makeText(ListMahasiswaTA.this, token, Toast.LENGTH_SHORT).show();
                    }
                });

        rvMahasiswaTA = findViewById(R.id.list_mahasiswa);
        //rvMahasiswaTA = findViewById(R.id.rv_cm);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMahasiswaTA.setLayoutManager(layoutManager);

        getMahasiswaTA();
    }

    public ArrayList<Thesis>getMahasiswaTA(){

        //RetrofitClient config = new RetrofitClient();
        ArrayList<Thesis> listMahasiswaTA = new ArrayList<>();
        System.out.println("token saya : "+token);

        Config config = new Config();
        //ArrayList<Thesis>listMahasiswaTA = new ArrayList<>();

        //panggil client
        //Toast.makeText(this, token, Toast.LENGTH_SHORT).show();

        //tipe data tesis nya masih ga tau!


        Call<ThesesData> call = config.configRetrofit().Getlist("Bearer " + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOi8vcHRiLWFwaS5odXNuaWxrYW1pbC5teS5pZC9hcGkvbG9naW4iLCJpYXQiOjE2NzI4ODMwNzgsImV4cCI6MTY3Mjg4NjY3OCwibmJmIjoxNjcyODgzMDc4LCJqdGkiOiJ4NzlGc0FtSnc1cll5b1dlIiwic3ViIjoiNDQ0IiwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.ZgIL8_NAAtCNy6ezez4vqtG93q_McaelQ-tcBnJacV8");  //token nyo masih null!!
        call.enqueue(new Callback<ThesesData>() {
            @Override
            public void onResponse(Call<ThesesData> call, Response<ThesesData> response) {
                Toast.makeText(ListMahasiswaTA.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                ThesesData thesesData = response.body();
                List<Thesis>listTA = thesesData.getTheses();
                ArrayList<Thesis>listMahasiswaTA = new ArrayList<>();
                for(Thesis thesis : listTA){
                    listMahasiswaTA.add(thesis);
                }
                ListMahasiswaTAAdapter adapter = new ListMahasiswaTAAdapter(listMahasiswaTA);
                rvMahasiswaTA.setAdapter(adapter);
                adapter.setListener(ListMahasiswaTA.this);
                System.out.println("data TA : "+listMahasiswaTA);
            }
            @Override
            public void onFailure(Call<ThesesData> call, Throwable t) {
                Toast.makeText(ListMahasiswaTA.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return listMahasiswaTA;

    }

    @Override
    public void onItemMahasiswaTAClick(Thesis mahasiswaTA) {
        Intent detailIntent = new Intent(this, detail_TA_Activity.class); //buat pindah ke halaman berikutnya :)
        detailIntent.putExtra("nama_mahasiswa", mahasiswaTA.getStudentName().toString());   //buat nge load data nama nya ke halaman detail mahasiswa TA
        detailIntent.putExtra("isi_judul_tugas_akhir", mahasiswaTA.getTitle().toString());  //buat nge load data judul nya ke halaman detail mahasiswa TA
        startActivity(detailIntent);



    }
}