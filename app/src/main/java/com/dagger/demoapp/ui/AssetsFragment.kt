package com.dagger.demoapp.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dagger.demoapp.R
import com.dagger.demoapp.di.component.FragmentComponent
import com.dagger.demoapp.repo.ActivityManager
import com.dagger.demoapp.repo.ApplicationFragmentManager
import com.dagger.demoapp.repo.DataRepository
import javax.inject.Inject

class AssetsFragment private constructor() : Fragment() {

    lateinit var fragmentComponent: FragmentComponent

    val TAG = "AssetsFragment"

    @Inject
    lateinit var dataRepo: DataRepository

    @Inject
    lateinit var demoActivityManager: ActivityManager

    @Inject
    lateinit var fragManager: ApplicationFragmentManager


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_assets, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.v(TAG, " >> Hash code of dataRepository is : " + dataRepo.hashCode().toString())

        Log.v(
            TAG,
            " >> Hash code of demoActivityManager is : " + demoActivityManager.hashCode().toString()
        )
        Log.v(
            TAG,
            " >> Hash code of fragment manager is : " + fragManager.hashCode().toString()
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(fragmentComponent: FragmentComponent) = AssetsFragment(fragmentComponent)
    }


    private constructor(fragmentComponent: FragmentComponent) : this() {
        this.fragmentComponent = fragmentComponent
    }
}