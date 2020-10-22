package com.dagger.demoapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dagger.demoapp.MyApplication
import com.dagger.demoapp.R
import com.dagger.demoapp.repo.DataRepository
import com.dagger.demoapp.repo.ActivityManager
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val activityComponent by lazy { (application as MyApplication).appComponent.mainActivityComponent().create() }


    val TAG = "MainActivity"

    @Inject
    lateinit var dataRepository: DataRepository

    @Inject
    lateinit var demoActivityManager: ActivityManager

    override fun onCreate(savedInstanceState: Bundle?) {

//        (application as MyApplication).appComponent.inject(this)
        activityComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    loadFragment(it.position)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Opening Settings", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            val mIntent = Intent(this, SettingsActivity::class.java)
            startActivity(mIntent)
        }

        Log.v(TAG, " >> Hash code of dataRepository is : " + dataRepository.hashCode().toString())
        Log.v(
            TAG,
            " >> Hash code of demoActivityManager is : " + demoActivityManager.hashCode().toString()
        )

        loadFragment(0)
    }

private fun loadFragment(i: Int) {
    val transaction = supportFragmentManager.beginTransaction()

    var fragment: Fragment? = null
    if (i == 0) {
        fragment = DashboardFragment.newInstance()
    } else {
        fragment = ApplicationFragment.newInstance()
    }
    transaction.replace(R.id.fragment_container, fragment)
    transaction.commitNow()
}

}