package com.example.abdullah.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv, tv2, avatar;
    Button btn;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et1);
        btn = findViewById(R.id.src);
        tv = findViewById(R.id.login);
        tv2 = findViewById(R.id.uid);
        avatar = findViewById(R.id.avatar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et.getText().toString();
                getHeroes(s);
            }
        });
    }

    public void getHeroes(String s) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();

        Api api = retrofit.create(Api.class);

        Call<Hero> call = api.getHeroes(s);

        call.enqueue(new Callback<Hero>() {
            @Override
            public void onResponse(Call<Hero> call, Response<Hero> response) {
                Hero heroes = response.body();
                tv.setText("Login: "+heroes.getLogin());
                tv2.setText("Uid: "+heroes.getId().toString());
                avatar.setText("Avatar Link:"+heroes.getAvatarUrl());
            }

            @Override
            public void onFailure(Call<Hero> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
