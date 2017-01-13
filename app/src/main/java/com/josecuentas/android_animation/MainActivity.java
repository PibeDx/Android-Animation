package com.josecuentas.android_animation;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView mIviImage;
    Button mButAnimation;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        injectView();


        findViewById(R.id.butAnimation).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {


//                mIviImage.animate().alpha(0.5f).setDuration(1000);


//                mIviImage.animate().setDuration(1000);
//                mIviImage.animate().alpha(1);

//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                valueAnimator.setDuration(1000);
//                valueAnimator.start();




                ObjectAnimator animatorX = ObjectAnimator.ofFloat(mIviImage, View.SCALE_X, 1, 0.5f, 1);
                animatorX.setDuration(1000);
                ObjectAnimator animatorY = ObjectAnimator.ofFloat(mIviImage, View.SCALE_Y, 1, 0.5f, 1);
                animatorY.setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
//                animatorSet.play(animatorX).with(animatorY);
//                animatorSet.start();


                ObjectAnimator animatorXY = ObjectAnimator.ofPropertyValuesHolder(
                        mIviImage,
                        PropertyValuesHolder.ofFloat(View.SCALE_X, 2),
                        PropertyValuesHolder.ofFloat(View.SCALE_Y, 2)
                );

                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setIntValues(Color.parseColor("#000000"), Color.parseColor("#FFFFFF"));
                valueAnimator.setEvaluator(new ArgbEvaluator());


                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        int val = (Integer) valueAnimator.getAnimatedValue();
                        Log.v("TAG", "" + val);
                    }
                });

                valueAnimator.start();



            }
        });

//                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                valueAnimator.setDuration(1000);
//                valueAnimator.start();

    }

    private void injectView() {
        mIviImage = (ImageView) findViewById(R.id.iviImage);
        mButAnimation = (Button) findViewById(R.id.butAnimation);
    }
}
