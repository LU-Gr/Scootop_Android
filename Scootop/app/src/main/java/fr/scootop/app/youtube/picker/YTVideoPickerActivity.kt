package fr.scootop.app.youtube.picker

import android.app.Activity
import android.app.SearchManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.SearchView
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import fr.scootop.R
import fr.scootop.data.model.youtube.YTSearchResult
import kotlinx.android.synthetic.main.activity_ytvideo_picker.*

class YTVideoPickerActivity : AppCompatActivity(), YTVideoPickerView, AdapterView.OnItemClickListener {

    companion object {
        val REQUEST_CODE: Int = 1000
    }

    private val interactor = YTVideoPickerInteractor(YTVideoPickerPresenter(this))
    private val adapter = YTVideoPickerAdapter(this)

    private var progressDialog: MaterialDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ytvideo_picker)
        setSupportActionBar(toolbar)

        backButton.setOnClickListener {
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                interactor.searchVideos(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return true
            }
        })

        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.isFocusable = true
        searchView.isIconified = false
        searchView.requestFocusFromTouch()

        listView.adapter = adapter
        listView.onItemClickListener = this
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

    override fun hideLoading() {
        runOnUiThread {
            progressDialog?.hide()
            progressDialog = null
        }
    }

    override fun displayError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }


    override fun displayInfo(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun displayItems(items: Array<YTSearchResult>) {
        adapter.items = items
    }

    override fun successfulDismiss() {
        setResult(Activity.RESULT_OK)
        finish()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        adapter.items[position].id?.videoId?.let {
            interactor.attachVideo(it)
        }
    }

}
