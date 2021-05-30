package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
//import android.os.RecoverySystem;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void PLAY(View v){
        if(player==null)
        {
            player=MediaPlayer.create(this,R.raw.ring);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {

                }
            });

        }player.start();
    }
    public void PAUSE(View v){
        if(player!=null)
        {
            player.pause();
        }
    }
    public void STOP(View v)
    {
        stopPlayer();
    }
    public void stopPlayer()
    {
        if(player!=null)
        {
            player.release();
            player=null;
            Toast.makeText(this,"Released",Toast.LENGTH_SHORT).show();

        }
    }
//    protected void onStop()
//    {
//        super.onStop();
//        stopPlayer();
//    }
}

