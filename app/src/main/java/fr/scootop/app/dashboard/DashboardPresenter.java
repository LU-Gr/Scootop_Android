package fr.scootop.app.dashboard;

import java.lang.ref.WeakReference;

import fr.scootop.data.model.Board;

public class DashboardPresenter
{
    private WeakReference<DashboardView> mView;

    public DashboardPresenter(DashboardView view)
    {
        mView = new WeakReference<>(view);
    }

    public void presentEmptyState()
    {
        mView.get().showEmptyState();
    }

    public void presentError(Throwable throwable)
    {
        mView.get().showError(throwable.getLocalizedMessage());
    }

    public void presentBoard(Board board)
    {
        if (board.video == null && (board.players == null || board.players.isEmpty())) {
            presentEmptyState();
        } else {
            mView.get().showBoard(board);
        }
    }
}
