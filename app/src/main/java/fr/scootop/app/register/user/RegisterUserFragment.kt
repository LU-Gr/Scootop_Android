package fr.scootop.app.register.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mukesh.countrypicker.CountryPicker
import com.tsongkha.spinnerdatepicker.SpinnerDatePickerDialogBuilder
import fr.scootop.R
import fr.scootop.app.common.ext.onChange
import fr.scootop.data.model.request.RegisterUser
import kotlinx.android.synthetic.main.fragment_register_user.*

/**
 * A simple [Fragment] subclass.
 */
class RegisterUserFragment : Fragment() {

    var registerUser: RegisterUser = RegisterUser()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstNameInput.onChange { registerUser.firstName = it }
        lastNameInput.onChange { registerUser.lastName = it }
        emailInput.onChange { registerUser.email = it }
        passwordInput.onChange { registerUser.password = it }

        val adapter = ArrayAdapter.createFromResource(requireContext(), R.array.gender_names, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        genderSpinner.adapter = adapter
        genderSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (resources.getStringArray(R.array.gender_names)[position]) {
                    getString(R.string.gender_male) -> {
                        registerUser.gender = getString(R.string.gender_male_value)
                    }
                    getString(R.string.gender_female) -> {
                        registerUser.gender = getString(R.string.gender_female_value)
                    }
                }
            }
        }

        birthDateInput.setOnClickListener {
            SpinnerDatePickerDialogBuilder()
                .context(context)
                .callback { _, year, monthOfYear, dayOfMonth ->
                    val month = monthOfYear + 1
                    val dateText = "$year-" + "$month".padStart(2, '0') + "-" + "$dayOfMonth".padStart(2, '0')
                    registerUser.birthDate = dateText
                    birthDateInput.setText(dateText)
                }
                .build()
                .show()
        }

        originInput.setOnClickListener {
            val picker = CountryPicker.newInstance(getString(R.string.form_inscription_origine))
            picker.setListener { name, countryCode, _, flagDrawableResID ->
                //originInput.setCompoundDrawablesWithIntrinsicBounds(flagDrawableResID, 0, 0, 0)
                originInput.setText(name)
                picker.dismiss()
                registerUser.originCountry = countryCode.toLowerCase()
            }
            picker.show(activity!!.supportFragmentManager, "originPicker")
        }

        nationalityInput.setOnClickListener {
            val picker = CountryPicker.newInstance(getString(R.string.form_inscription_origine))
            picker.setListener { name, countryCode, _, flagDrawableResID ->
                //nationalityInput.setCompoundDrawablesWithIntrinsicBounds(flagDrawableResID, 0, 0, 0)
                nationalityInput.setText(name)
                picker.dismiss()
                registerUser.nationalityCountry = countryCode.toLowerCase()
            }
            picker.show(activity!!.supportFragmentManager, "nationalityPicker")
        }
    }

}
