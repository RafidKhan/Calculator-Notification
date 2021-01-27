package com.example.mvvmbasic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvvmbasic.R;
import com.example.mvvmbasic.ViewModel.MainActivityViewModel;
import com.example.mvvmbasic.ViewModel.ResultActivityViewModel;
import com.example.mvvmbasic.databinding.ActivityMainBinding;
import com.example.mvvmbasic.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    ResultActivityViewModel resultActivity;
    ActivityResultBinding activityResultBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        resultActivity = new ViewModelProvider(this).get(ResultActivityViewModel.class);

        activityResultBinding =  ActivityResultBinding.inflate(getLayoutInflater());
        View view2 = activityResultBinding.getRoot();
        setContentView(view2);

        String fetchResult = resultActivity.SharedPref1(ResultActivity.this, activityResultBinding.result1.getText().toString());
        String fetchResult2 = resultActivity.SharedPref2(ResultActivity.this, activityResultBinding.result2.getText().toString());
        String fetchResult3 = resultActivity.SharedPref3(ResultActivity.this, activityResultBinding.result3.getText().toString());

        activityResultBinding.result1.setText("Addition: "+fetchResult);
        activityResultBinding.result2.setText("Subtraction: "+fetchResult2);
        activityResultBinding.result3.setText("Multiplication: "+fetchResult3);

        activityResultBinding.result1.setTextSize(30);
        activityResultBinding.result2.setTextSize(30);
        activityResultBinding.result3.setTextSize(30);

    }
}