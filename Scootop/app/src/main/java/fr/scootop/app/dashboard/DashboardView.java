package fr.scootop.app.dashboard;

import fr.scootop.data.model.Board;

/**
 * Created by ludovicriviere on 23/02/2018.
 */
public interface DashboardView
{
    void showEmptyState();

    void showError(String message);

    void showBoard(Board board);
}
