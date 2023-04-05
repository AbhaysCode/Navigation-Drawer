package com.example.navigationdrawer

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle:ActionBarDrawerToggle
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    val drawerLayout: DrawerLayout = binding.drawerLayout
    toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
    drawerLayout.addDrawerListener(toggle)
    toggle.syncState()

    val home = HomeFragment()
    val gallery = GallleryFragment()
    val todo = AddtodoFragment()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.title = ""
    binding.navigationView.setNavigationItemSelectedListener {
        Toast.makeText(this,"Inside setNavigationItemSelectedListener",Toast.LENGTH_SHORT).show()
        when (it.itemId) {
            R.id.Home -> {
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, home)
                    commit()
                }
                true
            }
            R.id.Gallery -> {
                Toast.makeText(this,"Galley Clicked!!",Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, gallery)
                    commit()
                }
                true
            }
            R.id.addTask -> {
                Toast.makeText(this,"Galley Clicked!!",Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, todo)
                    commit()
                }
                true
            }
            else -> false
        }
    }
}

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            Toast.makeText(this,"Inside If of OnOptionsItemSelectedListener",Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}