package me.simple.nm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private var mFragments = mutableListOf<Fragment>()
    private var mTitles = mutableListOf<String>()

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mTitles.add(title)
    }

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }

    fun getFragment(index: Int) = mFragments[index]

    fun getFragments() = mFragments

    fun getTitle(position: Int) = mTitles[position]
}