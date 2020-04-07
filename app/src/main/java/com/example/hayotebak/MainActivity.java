package com.example.hayotebak;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat.Builder;

public class MainActivity extends AppCompatActivity {
    RelativeLayout kuis;
    int notificationID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kuis = findViewById(R.id.kuisku);
        kuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Kuis.class);
                //displayNotification();
                startActivity(i);
            }
        });
    }

    private void displayNotification() {
        Intent i = new Intent(this, NotificationViewActivity.class);
        i.putExtra("notificationID", notificationID);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Builder notifBuilder;
        notifBuilder = new Builder(this)
                .setContentTitle("Jawaban Salah!!!")
                .setContentText("Silakan Ulangi!")
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher, "Read More", pendingIntent);

        Vibrator vi;
        vi=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        assert vi != null;
        if (vi.hasVibrator()){
            vi.vibrate(20000);
        }

        assert nm != null;
        nm.notify(notificationID, notifBuilder.build());
    }

}


