package fr.scootop.app.dashboard;

import fr.scootop.data.model.Board;

public interface DashboardView
{
    void showEmptyState();

    void showError(String message);

    void showBoard(Board board);
}
