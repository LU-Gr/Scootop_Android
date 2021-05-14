package fr.scootop.app.register.type

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.register.user.RegisterActivity
import fr.scootop.data.definition.UserType
import kotlinx.android.synthetic.main.activity_register_type.*

class RegisterTypeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_type)
        setSupportActionBar(registerTypeToolbar)

        val userTypesNames = resources.getStringArray(R.array.user_types_names)
        registerTypeListView.adapter = ArrayAdapter(this, R.layout.simple_list_item_who, userTypesNames)
        registerTypeListView.setOnItemClickListener { _, _, position, _ ->
            val userTypeName = userTypesNames[position]
            val intent = Intent(this, RegisterActivity::class.java)

            when (userTypeName) {
                this.getString(R.string.user_type_player) -> {
                    intent.putExtra(ExtraKey.USER_TYPE, UserType.Player.value)
                }
                this.getString(R.string.user_type_coach) -> {

                }
                this.getString(R.string.user_type_observer) -> {
                    intent.putExtra(ExtraKey.USER_TYPE, UserType.Observer.value)
                }
                else -> {
                    return@setOnItemClickListener
                }
            }

            startActivity(intent)
        }
    }

}
