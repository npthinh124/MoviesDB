package net.vinid.moviedb.ui.base

import android.app.Activity
import android.content.Context
import dagger.android.support.DaggerFragment

/**
 * Created by Nguyen Van Lieu on 1/31/2020.
 */
open class BaseFragment : DaggerFragment() {

    private lateinit var activity: Activity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.activity = context as Activity
    }
}