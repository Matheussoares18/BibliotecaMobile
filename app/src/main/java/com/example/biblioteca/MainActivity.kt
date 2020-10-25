package com.example.biblioteca

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_drawer.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)


        var navController = findNavController(R.id.nav_host_fragment)


        navigationView.setNavigationItemSelectedListener {
            item -> when(item.itemId){
            R.id.itemLista ->
                navController.navigate(R.id.listaLivroFragment)
            R.id.itemfragment1 -> navController.navigate(R.id.fragment1)

            R.id.itemFragment2 -> navController.navigate(R.id.fragment2)

            R.id.itemFragment3 -> navController.navigate(R.id.fragment3)
        }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }






    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.itemHome -> showHomeActivity()
            else ->  super.onOptionsItemSelected(item)
        }

    }

    private fun showHomeActivity(): Boolean {

        var intent = Intent(this,HomePageActivity::class.java)
        startActivity(intent)
        return true
    }
}