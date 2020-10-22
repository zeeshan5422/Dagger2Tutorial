package com.dagger.demoapp.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.dagger.demoapp.MyApplication
import com.dagger.demoapp.R
import com.dagger.demoapp.repo.ActivityManager
import com.dagger.demoapp.repo.DataRepository
import javax.inject.Inject

class SettingsActivity : AppCompatActivity() {

    val TAG = "SettingsActivity"

    @Inject
    lateinit var dataRepository: DataRepository

    @Inject
    lateinit var demoActivityManager: ActivityManager

    override fun onCreate(savedInstanceState: Bundle?) {

        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        Log.v(TAG, " >> Hash code of Data Repo is : " + dataRepository.hashCode().toString())
        Log.v(
            TAG,
            " >> Hash code of demoActivityManager is : " + demoActivityManager.hashCode().toString()
        )
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