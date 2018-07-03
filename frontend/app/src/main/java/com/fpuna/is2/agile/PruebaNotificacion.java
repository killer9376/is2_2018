package com.fpuna.is2.agile;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PruebaNotificacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "is2";
            String description ="is2";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("defatul", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Button _btnnotify = (Button) findViewById(R.id.button_prueba);
        _btnnotify.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
// Create an explicit intent for an Activity in your app
                Intent intent = new Intent(PruebaNotificacion.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(PruebaNotificacion.this, 0, intent, 0);

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(PruebaNotificacion.this, "default")
                        .setSmallIcon(R.drawable.ic_notificacion)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!\nNew line \nHola \nasdfasdfa")
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText("Much longer text that cannot fit one line...a" +
                                        "sdfasdfasljdfjasldfj af \n ajsdfl akjs;fdlaj sdfl"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        // Set the intent that will fire when the user taps the notification
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(PruebaNotificacion.this);

                // notificationId is a unique int for each notification that you must define
                notificationManager.notify(001, mBuilder.build());

            }
        });
    }
}
