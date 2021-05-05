package fr.scootop.app.register.user

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.afollestad.materialdialogs.MaterialDialog
import com.mukesh.countrypicker.CountryPicker
import fr.scootop.R
import fr.scootop.app.common.ext.onChange
import fr.scootop.data.api.ApiManager
import fr.scootop.data.definition.Footed
import fr.scootop.data.model.Category
import fr.scootop.data.model.Division
import fr.scootop.data.model.Position
import fr.scootop.data.model.request.RegisterUserPlayer
import kotlinx.android.synthetic.main.fragment_register_player.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterPlayerFragment : Fragment() {

    var player: RegisterUserPlayer.Wrapper = RegisterUserPlayer.Wrapper()

    private var positions: Array<Position> = emptyArray()
    private var categories: Array<Category> = emptyArray()
    private var divisions: Array<Division> = emptyArray()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clubInput.onChange { player.clubName = it }

        heightCmInput.setOnClickListener {
            context?.let {
                MaterialDialog.Builder(it)
                    .title(R.string.hint_height_cm)
                    .items(IntRange(120, 250).map { it.toString() })
                    .itemsCallbackSingleChoice(-1) { dialog, _, _, text: CharSequence? ->
                        text.let({
                            val intValue = it.toString().toInt()
                            player.heightCm = intValue

                            val cm = intValue % 100
                            val m = (intValue - cm) / 100

                            heightCmInput.setText("%dm%s".format(m, "$cm".padStart(2, '0')))
                        })
                        dialog.dismiss()
                        return@itemsCallbackSingleChoice true
                    }
                    .build()
                    .show()
            }
        }

        weightKgInput.setOnClickListener {
            context?.let {
                MaterialDialog.Builder(it)
                    .title(R.string.hint_weight_kg)
                    .items(IntRange(30, 150).map { it.toString() })
                    .itemsCallbackSingleChoice(-1) { dialog, _, _, text: CharSequence? ->
                        text.let {
                            player.weightKg = it.toString().toDouble()
                            weightKgInput.setText("%d kg".format(it.toString().toInt()))
                        }
                        dialog.dismiss()
                        return@itemsCallbackSingleChoice true
                    }
                    .build()
                    .show()
            }
        }

        val footedAdapter = ArrayAdapter.createFromResource(context, R.array.footed_types, android.R.layout.simple_spinner_item)
        footedAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        footedSpinner.adapter = footedAdapter
        footedSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (resources.getStringArray(R.array.footed_types)[position]) {
                    getString(R.string.footed_type_left) -> {
                        player.footed = Footed.Left.value
                    }
                    getString(R.string.footed_type_right) -> {
                        player.footed = Footed.Right.value
                    }
                }
            }
        }

        countryInput.setOnClickListener {
            val picker = CountryPicker.newInstance(getString(R.string.form_inscription_origine))
            picker.setListener { name, countryCode, _, _ ->
                countryInput.setText(name)
                picker.dismiss()
                player.countryCode = countryCode.toLowerCase()
                loadDivisions()
            }
            picker.show(activity?.supportFragmentManager, "countryPicker")
        }

        favoritePositionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                player.favoritePositionId = positions[position].id
            }
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                player.categoryId = categories[position].id
            }
        }

        divisionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                player.divisionId = divisions[position].id
            }
        }

        loadPositions()
        loadCategories()
        loadDivisions()
    }

    private fun loadPositions() {
        ApiManager.get().positionService.getPositions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ pagination ->
                pagination.members?.let {
                    positions = it
                    context?.let {
                        favoritePositionSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, positions)
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
    }

    private fun loadCategories() {
        ApiManager.get().categoryService.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ pagination ->
                pagination.members?.let {
                    categories = it
                    context?.let {
                        categorySpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, categories)
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
    }

    private fun loadDivisions() {
        ApiManager.get().divisionService.getDivisions(player.countryCode)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ pagination ->
                pagination.members?.let {
                    divisions = it
                    context?.let {
                        divisionSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, divisions)
                        player.divisionId = divisions.first().id
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
    }

}
