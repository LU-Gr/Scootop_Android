package fr.scootop.app.post.create

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import fr.scootop.R
import kotlinx.android.synthetic.main.activity_create_post.*
import java.util.*

class CreatePostActivity : AppCompatActivity(), CreatePostView {

    private val interactor = CreatePostInteractor(CreatePostPresenter(this))

    private var calendar: Calendar = Calendar.getInstance()
    private var progressDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
        setSupportActionBar(toolbar)
        calendar.set(Calendar.SECOND, 0)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        val context: Context = this

        dateInput.setOnClickListener {
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(context, { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                dateInput.setText("%02d-%02d-%d".format(dayOfMonth, monthOfYear + 1, year))
            }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH))

            datePicker.show()
        }

        hourInput.setOnClickListener {
            val now = Calendar.getInstance()
            val timePicker = TimePickerDialog(context, { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)
                calendar.set(Calendar.SECOND, 0)
                hourInput.setText("%02d:%02d".format(hourOfDay, minute))
            }, now.get(Calendar.HOUR_OF_DAY), 0, true)

            timePicker.show()
        }

        createPostButton.setOnClickListener {
            if (textInput.text.isEmpty() || addressInput.text.isEmpty() || dateInput.text.isEmpty() || hourInput.text.isEmpty()) {
                Toast.makeText(context, R.string.toast_form_incomplete, Toast.LENGTH_LONG).show()
            } else {
                val text: String = textInput.text.toString()
                val address: String = addressInput.text.toString()
                interactor.createPost(text, address, calendar.time)
            }
        }
    }

    override fun displayLoading() {
        progressDialog = MaterialDialog.Builder(this)
            .title(R.string.dialog_loading_title)
            .content(R.string.dialog_loading_message)
            .progress(true, 0)
            .progressIndeterminateStyle(true)
            .build()
        progressDialog?.show()
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        progressDialog?.hide()
    }

    override fun displayInfo(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onPostCreated() {
        createPostButton.isEnabled = false
        Toast.makeText(this, R.string.feedback_post_created, Toast.LENGTH_SHORT).show()

        Handler().postDelayed({
            runOnUiThread({
                finish()
            })
        }, 1200)
    }

}
