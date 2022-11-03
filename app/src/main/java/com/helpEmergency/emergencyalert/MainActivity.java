package com.helpEmergency.emergencyalert;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer police_music = MediaPlayer.create(this, R.raw.police);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.police);
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {
                    mp.start();
                    Toast.makeText(getApplicationContext(), "Down Volume", Toast.LENGTH_SHORT).show();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    mp.stop();
                    Toast.makeText(getApplicationContext(), "UP Volume", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }
}