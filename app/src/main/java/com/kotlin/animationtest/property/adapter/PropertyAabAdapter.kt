package com.kotlin.animationtest.property.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kotlin.animationtest.animator.fragment.*
import com.kotlin.animationtest.property.fragment.*

class PropertyAabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val fragments = arrayListOf<Fragment>()
    val titles = arrayOf("Alpha","Scale","Translate","rotate","point")
    init {
        fragments.add(AlphaPropertyFragment())
        fragments.add(ScalePropertyFragment())
        fragments.add(TranslatePropertyFragment())
        fragments.add(RotatePropertyFragment())
        fragments.add(SpotFragment())
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}