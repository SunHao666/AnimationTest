package com.kotlin.animationtest.animator.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.kotlin.animationtest.animator.fragment.*

class AnimatorTabAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val fragments = arrayListOf<Fragment>()
    val titles = arrayOf("Alpha","Scale","Translate","rotate","progress")
    init {
        fragments.add(AlphaFragment())
        fragments.add(ScaleFragment())
        fragments.add(TranslateFragment())
        fragments.add(RotateFragment())
        fragments.add(ProgressFragment())
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