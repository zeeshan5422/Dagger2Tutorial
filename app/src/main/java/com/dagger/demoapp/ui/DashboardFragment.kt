package com.dagger.demoapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagger.demoapp.MyApplication
import com.dagger.demoapp.R
import com.dagger.demoapp.repo.ActivityManager
import com.dagger.demoapp.repo.DataRepository
import javax.inject.Inject

class DashboardFragment : Fragment() {

    val TAG = "DashboardFragment"

    @Inject
    lateinit var dataRepo: DataRepository

    @Inject
    lateinit var demoActivityManager: ActivityManager

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
        (requireActivity() as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, " >> Hash code of dataRepository is : " + dataRepo.hashCode().toString())

        Log.v(
            TAG,
            " >> Hash code of demoActivityManager is : " + demoActivityManager.hashCode().toString()
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }
}