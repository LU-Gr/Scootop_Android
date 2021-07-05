package fr.scootop.app.search;

import androidx.annotation.Nullable;

import java.lang.ref.WeakReference;
import java.util.List;

import fr.scootop.data.model.user.domain.PlayerSearchResult;

public class SearchPresenter
{
	private WeakReference<SearchView> mView;

	public SearchPresenter(SearchView view)
	{
		mView = new WeakReference<>(view);
	}

	public void presentPlayers(@Nullable List<PlayerSearchResult> players)
	{
		if (null != players && !players.isEmpty()) {
			mView.get().displayPlayers(players);
		} else {
			mView.get().displayNoResult();
		}
	}

	public void presentError(String message)
	{
		mView.get().displayError(message);
	}
}
