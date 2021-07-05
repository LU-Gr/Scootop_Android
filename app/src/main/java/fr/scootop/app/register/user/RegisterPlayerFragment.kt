package fr.scootop.app.register.user

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog
import com.mukesh.countrypicker.CountryPicker
import fr.scootop.R
import fr.scootop.data.api.ApiManager
import fr.scootop.data.definition.Footed
import fr.scootop.data.model.configuration.Category
import fr.scootop.data.model.configuration.Poste
import fr.scootop.data.model.request.RegisterUserPlayer
import fr.scootop.data.model.tools.Club
import fr.scootop.data.model.tools.Team
import kotlinx.android.synthetic.main.fragment_register_player.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RegisterPlayerFragment : Fragment() {

    var player: RegisterUserPlayer = RegisterUserPlayer()

    private var positions: Array<Poste> = emptyArray()
    private var categories: Array<Category> = emptyArray()
    private var teams: Array<Team> = emptyArray()
    private var clubs: Array<Club> = emptyArray()
    private var clubId: Long? = null
    private var countryName: String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_register_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        heightCmInput.setOnClickListener {
            context?.let { it ->
                MaterialDialog.Builder(it)
                    .title(R.string.hint_height_cm)
                    .items(IntRange(120, 250).map { it.toString() })
                    .itemsCallbackSingleChoice(-1) { dialog, _, _, text: CharSequence? ->
                        text.let {
                            val intValue = it.toString().toInt()
                            player.heightCm = intValue

                            val cm = intValue % 100
                            val m = (intValue - cm) / 100

                            heightCmInput.setText("%dm%s".format(m, "$cm".padStart(2, '0')))
                        }
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
                            player.weightKg = it.toString().toInt()
                            weightKgInput.setText("%d kg".format(it.toString().toInt()))
                        }
                        dialog.dismiss()
                        return@itemsCallbackSingleChoice true
                    }
                    .build()
                    .show()
            }
        }

        val footedAdapter = ArrayAdapter.createFromResource(requireContext(), R.array.footed_types, android.R.layout.simple_spinner_item)
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
                countryName = name
                Log.i("Country name",name)
                player.countryCode = countryCode.toLowerCase()
                loadClubs()
            }
            picker.show(activity?.supportFragmentManager!!, "countryPicker")
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
                Log.i("nb clubs", clubs.size.toString())
                if(clubs.isNotEmpty()) {
                    loadTeams()
                }
            }
        }

        clubSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                clubId = clubs[position].id
                loadTeams()
            }
        }

        teamSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.i("team is size on", teams.isNotEmpty().toString() + teams.size.toShort())
                if(teams.isNotEmpty()){
                    player.teamId = teams[position].id
                }

            }
        }

        loadPositions()
        loadCategories()

    }

    private fun loadPositions() {
        ApiManager.get().configurationService.getPostes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ postes ->
                postes?.let { it ->
                    positions = it.toTypedArray()
                    context?.let {
                        favoritePositionSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, this.positions)
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
    }

    private fun loadCategories() {
        ApiManager.get().configurationService.getCategories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ categories ->
                categories?.let {
                    this.categories = it.toTypedArray()
                    context?.let {
                        categorySpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1,this.categories)
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })
    }

    private fun loadTeams() {
        Log.i("club id", clubId.toString())
        val t = clubs.first { c -> c.id == clubId }.teams!!
        Log.i("n t c", t.size.toString())
        teams = clubs.first { c -> c.id == clubId }.teams!!.filter { t -> t.category!!.id == player.categoryId }.toTypedArray()
        Log.i("teams size",teams.size.toString())
        context?.let {
            teamSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, teams)
        }

        /*player.teamId = this.teams.first().id
        ApiManager.get().toolsService.getTeams(/*player.countryCode*/)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ teams ->
                teams?.let {
                    this.teams = it.toTypedArray()
                    context?.let {
                        teamSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, this.teams)
                        player.teamId = this.teams.first().id
                    }
                }
            }, { throwable ->
                throwable.printStackTrace()
            })*/
    }

    private fun loadClubs() {
        ApiManager.get().toolsService.getClubsByCountry(countryName!!)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ clubs ->
                clubs?.let {
                    this.clubs = it.toTypedArray()
                    context?.let {
                        clubSpinner.adapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, android.R.id.text1, this.clubs)
                        loadTeams()
                    }
                }

            }, { throwable ->
                throwable.printStackTrace()
            })
    }

}
