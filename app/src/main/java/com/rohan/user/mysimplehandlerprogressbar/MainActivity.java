package com.rohan.user.mysimplehandlerprogressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Handler handler;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler=new Handler();
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
    }

    public void startProgress(View view) {
        Toast.makeText(this,"Running in progress",Toast.LENGTH_LONG).show();
        new Thread(new Task()).start();
    }
    class Task implements Runnable{

        @Override
        public void run() {
        for(int i=0;i<100;i++){
            final int value=i;
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(value);
                }
            });
        }
        }
    }
}
