package fr.scootop.app.search;

import java.util.List;

import fr.scootop.data.model.PlayerSearchItem;

public interface SearchView
{
	void displayPlayers(List<PlayerSearchItem> players);

	void displayNoResult();

	void displayError(String message);
}
