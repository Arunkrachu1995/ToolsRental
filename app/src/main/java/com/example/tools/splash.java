package com.example.tools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.tools.myapplication.R;

public class splash extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView(R.layout.splash);
        final ImageView iv=(ImageView ) findViewById( R.id.imageView );
        final Animation an= AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotate  );
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out  );
        iv.startAnimation( an );
        an.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation( an2 );
finish();
                Intent i=new Intent(splash.this,MainActivity.class);
                startActivity( i );
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        } );
    }
}
