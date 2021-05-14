package fr.scootop.app.user.details

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import fr.scootop.R
import fr.scootop.app.login.LoginActivity
import fr.scootop.app.youtube.picker.YTVideoPickerActivity
import fr.scootop.data.storage.TokenStorage
import fr.scootop.data.storage.UserStorage
import kotlinx.android.synthetic.main.fragment_my_profile.*

class UserDetailsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logoutButton.setOnClickListener {
            // best way is to show confirm dialog
            UserStorage.get(context).clear()
            TokenStorage.get(context).clear()

            startActivity(Intent(context, LoginActivity::class.java))
            activity?.finish()
        }

        fab.setOnClickListener {
            startActivityForResult(Intent(context, YTVideoPickerActivity::class.java), YTVideoPickerActivity.REQUEST_CODE)
        }

        // recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == YTVideoPickerActivity.REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(context, R.string.feedback_video_attached, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
