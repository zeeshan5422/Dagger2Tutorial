package com.dagger.demoapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagger.demoapp.R
import com.dagger.demoapp.repo.ActivityManager
import com.dagger.demoapp.repo.DataRepository
import kotlinx.android.synthetic.main.fragment_application.*
import javax.inject.Inject

class ApplicationFragment : Fragment() {

    val TAG = "ApplicationFragment"

    val fragmentComponent by lazy {
        (requireActivity() as MainActivity).activityComponent.applicationFragmentComponent()
            .create()
    }


    @Inject
    lateinit var dataRepo: DataRepository

    @Inject
    lateinit var demoActivityManager: ActivityManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
//        (requireActivity() as MainActivity).activityComponent.inject(this)
        fragmentComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_application, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, " >> Hash code of dataRepository is : " + dataRepo.hashCode().toString())

        Log.v(
            TAG,
            " >> Hash code of demoActivityManager is : " + demoActivityManager.hashCode().toString()
        )

        tab_financial.setOnClickListener {
            loadFragment(0)
        }
        tab_asset.setOnClickListener {
            loadFragment(1)
        }
        loadFragment(0)
    }

    private fun loadFragment(i: Int) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        var fragment: Fragment? = null
        if (i == 0) {
            fragment = FinancialsFragment.newInstance(fragmentComponent)
        } else {
            fragment = AssetsFragment.newInstance(fragmentComponent)
        }
        transaction.replace(R.id.app_fragment_container, fragment)
        transaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = ApplicationFragment()
    }
}