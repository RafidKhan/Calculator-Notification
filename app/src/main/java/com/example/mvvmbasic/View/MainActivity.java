package com.example.mvvmbasic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelProvider;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmbasic.R;
import com.example.mvvmbasic.ViewModel.MainActivityViewModel;
import com.example.mvvmbasic.databinding.ActivityMainBinding;

import java.util.Random;

import static androidx.core.content.ContextCompat.getSystemService;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    MainActivityViewModel mainActivityViewModel;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding =  ActivityMainBinding.inflate(getLayoutInflater());
        View view1 = activityMainBinding.getRoot();
        setContentView(view1);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        activityMainBinding.btnaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String resultVal = mainActivityViewModel.Addition(activityMainBinding.val1et.getText().toString(), activityMainBinding.val2et.getText().toString());
                String resultVal2 = mainActivityViewModel.Subtraction(activityMainBinding.val1et.getText().toString(), activityMainBinding.val2et.getText().toString());
                String resultVal3 = mainActivityViewModel.Multy(activityMainBinding.val1et.getText().toString(), activityMainBinding.val2et.getText().toString());

                mainActivityViewModel.SharedPref(MainActivity.this,resultVal,resultVal2,resultVal3);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);

                String resultConcat = resultVal+"\n"+resultVal2+"\n"+resultVal3;
                //Notificaion
                mainActivityViewModel.notification(MainActivity.this,resultConcat);

            }
        });
    }


}