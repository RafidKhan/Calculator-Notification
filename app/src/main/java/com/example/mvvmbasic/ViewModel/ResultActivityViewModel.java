package com.example.mvvmbasic.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.ViewModel;

public class ResultActivityViewModel extends ViewModel {
    public String SharedPref1(Context context, String result)
    {
        SharedPreferences sp2 = context.getApplicationContext().getSharedPreferences("result", Context.MODE_PRIVATE);
        String fetchResult = sp2.getString("result", "Result: ");
        return fetchResult;
    }

    public String SharedPref2(Context context, String result)
    {
        SharedPreferences sp2 = context.getApplicationContext().getSharedPreferences("result", Context.MODE_PRIVATE);
        String fetchResult2 = sp2.getString("result2", "Result: ");
        return fetchResult2;
    }

    public String SharedPref3(Context context, String result)
    {
        SharedPreferences sp2 = context.getApplicationContext().getSharedPreferences("result", Context.MODE_PRIVATE);
        String fetchResult3 = sp2.getString("result3", "Result: ");
        return fetchResult3;
    }
}
