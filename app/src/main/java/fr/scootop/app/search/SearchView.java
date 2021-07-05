package fr.scootop.app.search;

import java.util.List;

import fr.scootop.data.model.user.domain.PlayerSearchResult;

public interface SearchView
{
	void displayPlayers(List<PlayerSearchResult> players);

	void displayNoResult();

	void displayError(String message);
}
