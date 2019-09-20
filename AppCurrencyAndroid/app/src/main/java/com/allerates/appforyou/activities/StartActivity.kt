package com.allerates.appforyou.activities

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.startActivity

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animLogo = AnimationUtils.loadAnimation(this, R.anim.start_logo)
        animLogo.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                startActivity(FragmentsActivity::class.java)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })

        findViewById<ConstraintLayout>(R.id.start_layout).startAnimation(animLogo)
    }

    override fun onRestart() {
        super.onRestart()
        finish()
    }
}