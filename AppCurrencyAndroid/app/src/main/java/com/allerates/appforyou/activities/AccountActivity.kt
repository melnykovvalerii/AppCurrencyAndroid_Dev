package com.allerates.appforyou.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allerates.appforyou.helpers.startActivity
import com.allerates.appforyou.R
import com.google.firebase.auth.FirebaseAuth


class AccountActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var mAuthStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        mAuth = FirebaseAuth.getInstance()
        mAuthStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            if (firebaseAuth.currentUser == null)
                startActivity(MainActivity::class.java)
        }
    }

    fun logOutClick(v: View) = mAuth!!.signOut()

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener(mAuthStateListener!!)
    }
}
