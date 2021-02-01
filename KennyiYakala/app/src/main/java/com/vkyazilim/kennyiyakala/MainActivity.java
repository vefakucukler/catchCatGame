package com.vkyazilim.kennyiyakala;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    int score;
    ImageView [] imageArray;
    Handler handler;
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        ImageView imageView2=(ImageView)findViewById(R.id.imageView2);
        ImageView imageView3=(ImageView)findViewById(R.id.imageView3);
        ImageView imageView4=(ImageView)findViewById(R.id.imageView4);
        ImageView imageView5=(ImageView)findViewById(R.id.imageView5);
        ImageView imageView6=(ImageView)findViewById(R.id.imageView6);
        ImageView imageView7=(ImageView)findViewById(R.id.imageView7);
        ImageView imageView8=(ImageView)findViewById(R.id.imageView8);
        ImageView imageView9=(ImageView)findViewById(R.id.imageView9);
        imageArray= new ImageView[]{imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};
        score=0;
        imajSakla();

        new CountDownTimer(30000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText("Süre: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText=(TextView) findViewById(R.id.textTime);
                timeText.setText("Süre Bitti.");
                handler.removeCallbacks(runnable);
            }
        }.start();
    }
    public void skorArtir(View view){
        scoreText=(TextView)findViewById(R.id.textScore);
        score++;
        scoreText.setText("Skor "+score);

    }
    public void imajSakla(){
        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray ){
                    image.setVisibility(View.INVISIBLE);
                }
                Random r =new Random();
                int i=r.nextInt(8-0);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
                

            }
        };
        handler.post(runnable);
         }
}
