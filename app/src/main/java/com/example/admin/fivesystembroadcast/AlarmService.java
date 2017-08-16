package com.example.admin.fivesystembroadcast;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class AlarmService extends Service {
    static MediaPlayer mediaPlayer;

    public void Play() {
        if(mediaPlayer ==null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), Settings.System.DEFAULT_NOTIFICATION_URI);
            mediaPlayer.start();
        }
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    @Override

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Play();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
