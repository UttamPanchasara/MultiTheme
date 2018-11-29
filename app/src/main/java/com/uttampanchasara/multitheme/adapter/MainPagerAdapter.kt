package com.uttampanchasara.multitheme.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.uttampanchasara.multitheme.fragment.FirstFragment
import com.uttampanchasara.multitheme.fragment.SecondFragment
import com.uttampanchasara.multitheme.fragment.ThirdFragment

/**
 * @author [Uttam Panchasara](https://github.com/UttamPanchasara)
 * @since 11/2/2018
 */
class MainPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    val pagerTitles = arrayOf("First", "Second", "Third")

    override fun getItem(p0: Int): Fragment {
        lateinit var fragment: Fragment
        when (p0) {
            0 -> fragment = FirstFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ThirdFragment()
        }
        return fragment
    }

    override fun getCount(): Int {
        return pagerTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pagerTitles[position]
    }
}