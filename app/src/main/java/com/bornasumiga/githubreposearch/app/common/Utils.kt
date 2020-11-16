package com.bornasumiga.githubreposearch.app.common

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import org.joda.time.format.DateTimeFormat
import java.util.*

fun FragmentActivity.showFragment(containerId: Int, fragment: Fragment, addToBackStack : Boolean, bundle: Bundle = Bundle.EMPTY){
    this.supportFragmentManager.beginTransaction().apply {
        if(addToBackStack) addToBackStack(fragment.tag)
    }.replace(containerId,fragment).commitAllowingStateLoss()
    fragment.arguments = bundle
}

fun localizeDate(serverDate : String):String{
    val dtf = DateTimeFormat.shortDate().withLocale(Locale.getDefault())
    return dtf.print(org.joda.time.LocalDate(serverDate.substring(0,10))).replace(" ","")
}

fun hideProgressBar(progressBar : ProgressBar){
    progressBar.visibility = View.GONE
}
fun showProgressBar(progressBar: ProgressBar){
    progressBar.visibility = View.VISIBLE
}