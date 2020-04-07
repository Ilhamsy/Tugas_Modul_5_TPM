package com.example.hayotebak;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import java.util.Objects;

public class NotificationViewActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_view);
    }

    public void onCreate() {
        NotificationManager nm;
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        assert nm != null;
        nm.cancel(Objects.requireNonNull(getIntent().getExtras()).getInt("notificationID"));
    }
}
