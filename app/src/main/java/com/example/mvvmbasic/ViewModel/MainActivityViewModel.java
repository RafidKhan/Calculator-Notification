package com.example.mvvmbasic.ViewModel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModel;

import com.example.mvvmbasic.R;
import com.example.mvvmbasic.View.MainActivity;
import com.example.mvvmbasic.View.ResultActivity;

import java.util.Random;

import static android.content.Context.NOTIFICATION_SERVICE;
import static androidx.core.content.ContextCompat.createDeviceProtectedStorageContext;
import static androidx.core.content.ContextCompat.getSystemService;
import static androidx.core.content.ContextCompat.startActivity;

public class MainActivityViewModel extends ViewModel {

    public void SharedPref(Context context, String result1, String result2, String result3) {
        SharedPreferences sp;
        sp = context.getSharedPreferences("result", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("result", result1);
        editor.putString("result2", result2);
        editor.putString("result3", result3);
        editor.commit();
    }

    public String Addition(Context context, String val1, String val2) {
        int value1 = Integer.parseInt(val1);
        int value2 = Integer.parseInt(val2);
        int result = value1 + value2;

        return String.valueOf(result);
    }

    public String Subtraction(Context context, String val1, String val2) {
        int value1 = Integer.parseInt(val1);
        int value2 = Integer.parseInt(val2);
        int result = value1 - value2;

        return String.valueOf(result);
    }

    public String Multy(Context context, String val1, String val2) {
        int value1 = Integer.parseInt(val1);
        int value2 = Integer.parseInt(val2);
        int result = value1 * value2;

        return String.valueOf(result);
    }

    public void notification(Context context, String result) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

        String NOTIFIATION_CHANNEL_ID = "id_1";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFIATION_CHANNEL_ID, "Notification", NotificationManager.IMPORTANCE_DEFAULT);

            notificationChannel.setDescription("Calculator Notification");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.BLUE);
            notificationChannel.enableLights(true);
            notificationManager.createNotificationChannel(notificationChannel);

        }
        Bitmap bitmapAndroidLogo = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher_foreground);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, NOTIFIATION_CHANNEL_ID);
        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_cal)
                .setLargeIcon(bitmapAndroidLogo)
                .setContentTitle("Your Results")
                .setContentText(result)
                .setContentInfo("Info");

        notificationManager.notify(new Random().nextInt(), notificationBuilder.build());
    }

}
