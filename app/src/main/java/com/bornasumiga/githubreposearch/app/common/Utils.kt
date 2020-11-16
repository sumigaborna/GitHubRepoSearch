package com.bornasumiga.githubreposearch.app.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.showFragment(containerId: Int, fragment: Fragment, addToBackStack : Boolean, bundle: Bundle = Bundle.EMPTY){
    this.supportFragmentManager.beginTransaction().apply {
        if(addToBackStack) addToBackStack(fragment.tag)
    }.replace(containerId,fragment).commitAllowingStateLoss()
    fragment.arguments = bundle
}