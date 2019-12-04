package com.example.navigationview_travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()






        val navView = findViewById(R.id.nav_view) as NavigationView




        navView.setNavigationItemSelectedListener(object :  NavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                var fragmentTransaction = false
                var fragment: Fragment? = null

                when (menuItem.getItemId()) {
                    R.id.menu_seccion_1 -> {

                        fragment = Seccion1()
                        fragmentTransaction = true
                    }
                    R.id.menu_seccion_2 -> {
                        fragment = Fragment1()
                        fragmentTransaction = true
                    }
                    R.id.menu_seccion_3 -> {
                        fragment = Fragment1()
                        fragmentTransaction = true
                    }
                }
                if (fragmentTransaction) {
                    supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment!!).commit()
                    menuItem.setChecked(true)
                    supportActionBar!!.title = menuItem.title
                }
                drawerLayout.closeDrawers()
                return true
            }
        })

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
            when (item.itemId) {
                android.R.id.home -> {
                    drawerLayout.openDrawer(GravityCompat.START)
                    return true
                }
            }
            return super.onOptionsItemSelected(item)
        }






    }
}
