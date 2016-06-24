package nahid.example.com.navigationdrayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SpalshScreen extends AppCompatActivity {

    private ImageView forL, forO, forV, forE, forCal;
    private Animation animation1,animation2,animation3,animation4,animation5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_main);

        forL=(ImageView)findViewById(R.id.imageL);
        forO=(ImageView)findViewById(R.id.imageO);
        forV=(ImageView)findViewById(R.id.imageV);
        forE=(ImageView)findViewById(R.id.imageE);
        forCal=(ImageView)findViewById(R.id.calcIcon);


        animation1= AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        animation2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        animation3= AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        animation4= AnimationUtils.loadAnimation(getBaseContext(),R.anim.alpha);
        animation5= AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_in_micro);

        forL.setVisibility(View.VISIBLE);
        forL.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                AnimationTwo();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void AnimationTwo(){

        forO.setVisibility(View.VISIBLE);
        forO.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AnimationThree();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void AnimationThree(){
        forV.setVisibility(View.VISIBLE);
        forV.startAnimation(animation3);
        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AnimationFour();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void AnimationFour(){
        forE.setVisibility(View.VISIBLE);
        forE.startAnimation(animation4);
        animation4.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AnimationFive();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void AnimationFive(){
       forCal.setVisibility(View.VISIBLE);
        forCal.startAnimation(animation5);
        animation5.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent,0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
