package com.allerates.appforyou.activities


import android.os.Bundle
import android.support.design.widget.NavigationView
import android.content.Intent
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.fragment.*
import com.allerates.appforyou.helpers.Setting
import com.allerates.appforyou.helpers.showToast
import com.allerates.appforyou.helpers.startActivity


class FragmentsActivity:
        AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener {

    lateinit var coursesFragment: CoursesFragment
    lateinit var converterFragment: ConvertFragment
    lateinit var scheduleFragment: ScheduleFragment
    lateinit var searchPlaceOnMapFragment: SearchPlaceOnMapFragment

    lateinit var navigationView: NavigationView
    lateinit var drawer: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer)

        navigationView = findViewById(R.id.nav_view)
        navigationView.itemIconTintList = null
        navigationView.setNavigationItemSelectedListener(this)

        drawer = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
                this, drawer, findViewById(R.id.toolbar3), R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        val infoBlock = navigationView.getHeaderView(0)

        val ava = infoBlock.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.img_user)
        val name = infoBlock.findViewById<TextView>(R.id.tv_name)
        val email = infoBlock.findViewById<TextView>(R.id.tv_gmail)

        if (Setting(this).isLogged.get()) {
            //ava
            name.text = Setting(this).userLogin.get()
            email.text = Setting(this).userMail.get()
        }

        infoBlock.setOnClickListener {
            if (Setting(this).isLogged.get())
                startActivity(SettingActivity::class.java)
            else
                startActivity(LoginActivity::class.java)
        }

        searchPlaceOnMapFragment = SearchPlaceOnMapFragment()
        coursesFragment = CoursesFragment()
        converterFragment = ConvertFragment()
        scheduleFragment = ScheduleFragment()

        fragmentManager
                .beginTransaction()
                .add(R.id.frame, coursesFragment)
                .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.drawer_item_courses -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, coursesFragment)
                        .commit()
            }
            R.id.drawer_item_converter -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, converterFragment)
                        .commit()
            }
            R.id.drawer_item_map -> {
                if (Setting(this).isLogged.get()) {
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frame, searchPlaceOnMapFragment)
                            .commit()
                } else
                    showToast(this, "Sign in for continue")
            }
            R.id.drawer_item_schedule -> {
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame, scheduleFragment)
                        //.replace(R.id.frame, AddFragment())
                        .commit()
            }
            R.id.drawer_item_share -> {
                val sendInt = Intent(Intent.ACTION_SEND)
                sendInt.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
                sendInt.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text))
                sendInt.type = "text/plain"
                startActivity(Intent.createChooser(sendInt, getString(R.string.txt_share)))
                overridePendingTransition(R.anim.open_next, R.anim.close_next)
            }
            R.id.drawer_item_send -> {
                startActivity(ActivityContactUs::class.java)
                overridePendingTransition(R.anim.open_next, R.anim.close_next)
            }
            R.id.drawer_item_setting -> {
                if (Setting(this).isLogged.get())
                    startActivity(SettingActivity::class.java)
                else
                  showToast(this, "Sign in for continue")
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_top, menu)
        return true
    }

}
