package com.example.bucovidmonitor.app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bucovidmonitor.R;
import com.example.bucovidmonitor.ui.login.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    // private Button surveyBtn;
    TextView Banner;
    Button LogOut;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        Banner = findViewById(R.id.welcomeBanner);
        LogOut = findViewById(R.id.logoutBtn);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        //update name to name of person logged in.
        Banner.append(" " + user.getEmail() + "!");

        final Button surveyBtn = findViewById(R.id.button2);
        final Button APIBtn = findViewById(R.id.APIBtn);

        surveyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), SurveyActivity.class));
            }
        });

        APIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(), CovidData.class));
            }
        });

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

    }
}