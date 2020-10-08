package com.dagger.demoapp.ui

import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.dagger.demoapp.MyApplication
import com.dagger.demoapp.R
import com.dagger.demoapp.repo.DataRepository
import com.dagger.demoapp.repo.DemoActivitymanager
import javax.inject.Inject

class SettingsActivity : AppCompatActivity() {

    val TAG = "SettingsActivity"

    @Inject
    lateinit var dataRepository: DataRepository

    @Inject
    lateinit var demoActivitymanager: DemoActivitymanager

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        Log.v(TAG, " >> Hash code of Data Repo is : " + dataRepository.hashCode().toString())
        Log.v(TAG, " >> Hash code of demoActivityManager is : " + demoActivitymanager.hashCode().toString())
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}