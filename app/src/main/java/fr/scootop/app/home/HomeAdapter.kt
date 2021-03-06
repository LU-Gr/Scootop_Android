package fr.scootop.app.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import fr.scootop.R
import fr.scootop.app.dashboard.DashboardFragment
import fr.scootop.app.shortlist.ShortlistFragment
import fr.scootop.app.user.details.UserDetailsFragment

class HomeAdapter(fm: FragmentManager, private val userId: Long?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when {
            PAGE_DASHBOARD == position -> DashboardFragment()
            PAGE_SHORTLIST == position -> ShortlistFragment.newInstance(userId ?: 0) // temp code: 0 is invalid
            PAGE_MY_PROFILE == position -> UserDetailsFragment() //UserMyProfileFragment()
            else -> return DashboardFragment()
        }
    }

    override fun getCount(): Int {
        return PAGES_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return null
    }

    fun getPageIcon(position: Int): Int {
        if (PAGE_DASHBOARD == position) {
            return R.mipmap.ic_dashboard_white_24dp
        } else if (PAGE_SHORTLIST == position) {
            return R.mipmap.ic_grade_white_24dp
        } else if (PAGE_MY_PROFILE == position) {
            return R.mipmap.ic_person_white_24dp
        }
        return -1
    }

    companion object {
        private val PAGE_DASHBOARD = 0
        private val PAGE_SHORTLIST = 1
        private val PAGE_MY_PROFILE = 2
        private val PAGES_COUNT = 3
    }
}
