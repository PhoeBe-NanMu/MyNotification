package com.example.leiyang.mynotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button btn_send_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button2);
        btn_send_notice = (Button) findViewById(R.id.send_Notice);
        button.setOnClickListener(this);
        btn_send_notice.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        switch (view.getId()) {
            case R.id.button2:
                Intent intent = new Intent(MainActivity.this, MyTest.class);
                startActivity(intent);
                break;
            case R.id.send_Notice:
                sendNotification();

                break;
            case R.id.button7:
                cancel_notification();

        }
    }
    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    public void sendNotification(){

        NotificationCompat.Builder mbuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Hello")
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setDefaults(Notification.DEFAULT_LIGHTS)
                .setContentTitle("This is Title")
                .setContentText("This is ContentText");
        Intent intent1 = new Intent(this,OnClick.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent1,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        Intent intent2 = new Intent(this,OnClose.class);
        mbuilder.setContentIntent(pendingIntent);
        notificationManager.notify(1, mbuilder.build());
    }
    public void cancel_notification(){
        notificationManager.cancel(1);
    }
}
