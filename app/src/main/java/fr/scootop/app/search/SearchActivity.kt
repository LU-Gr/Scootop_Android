package fr.scootop.app.search

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import fr.scootop.R
import fr.scootop.app.common.ExtraKey
import fr.scootop.app.player.details.PlayerDetailsActivity
import fr.scootop.data.model.PlayerSearchItem
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity(), SearchView, AdapterView.OnItemClickListener {

    private val mInteractor by lazy {
        SearchInteractor(SearchPresenter(this))
    }

    private val mAdapter by lazy {
        SearchPlayerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        ButterKnife.bind(this)

        searchBackButton.setOnClickListener { finish() }

        searchListView.adapter = mAdapter
        searchListView.onItemClickListener = this

        searchSearchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {
                mInteractor.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                mInteractor.search(newText)
                return true
            }
        })

        val searchManager = getSystemService(SEARCH_SERVICE) as SearchManager
        searchSearchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchSearchView.setIconifiedByDefault(false)
        searchSearchView.isFocusable = true
        searchSearchView.isIconified = false
        searchSearchView.requestFocusFromTouch()
    }

    override fun displayPlayers(players: List<PlayerSearchItem>) {
        mAdapter.addPlayers(players)

        searchListView.visibility = View.VISIBLE
        searchPlaceholderLayout.visibility = View.GONE
    }

    override fun displayNoResult() {
        searchListView.visibility = View.GONE
        searchPlaceholderLayout.visibility = View.VISIBLE

        Toast.makeText(this, "Pas de résultat", Toast.LENGTH_SHORT).show()
    }

    override fun displayError(message: String) {
        Toast.makeText(this, "Erreur : " + message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        val playerItem = mAdapter.getPlayerItem(position) ?: return

        val intent = Intent(this, PlayerDetailsActivity::class.java)
        intent.putExtra(ExtraKey.PLAYER_ITEM, playerItem)
        startActivity(intent)
    }
}
