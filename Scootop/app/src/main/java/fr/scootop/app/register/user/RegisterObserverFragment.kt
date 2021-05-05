package fr.scootop.app.register.user


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import fr.scootop.R


/**
 * A simple [Fragment] subclass.
 */
class RegisterObserverFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_observer, container, false)
    }

}// Required empty public constructor
