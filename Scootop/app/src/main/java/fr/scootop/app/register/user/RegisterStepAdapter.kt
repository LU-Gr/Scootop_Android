package fr.scootop.app.register.user

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import fr.scootop.data.definition.UserType
import fr.scootop.data.model.request.RegisterUser
import fr.scootop.data.model.request.RegisterUserPlayer

class RegisterStepAdapter(fm: FragmentManager, private val userType: UserType) : FragmentPagerAdapter(fm) {

    companion object {
        val STEP_USER = 0
        val STEP_PLAYER = 1
    }

    val items: ArrayList<Int> = arrayListOf()

    var userFragment: RegisterUserFragment? = null
    var playerFragment: RegisterPlayerFragment? = null

    init {
        items.add(STEP_USER)

        if (userType == UserType.Player) {
            items.add(STEP_PLAYER)
        }
    }

    override fun getItem(position: Int): Fragment {
        when (items[position]) {
            STEP_USER -> {
                userFragment = RegisterUserFragment()
                return userFragment!!
            }
            STEP_PLAYER -> {
                when (userType) {
                    UserType.Player -> {
                        playerFragment = RegisterPlayerFragment()
                        return playerFragment!!
                    }
                    else -> {

                    }
                }
            }
        }
        return Fragment()
    }

    override fun getCount(): Int {
        return items.size
    }
}