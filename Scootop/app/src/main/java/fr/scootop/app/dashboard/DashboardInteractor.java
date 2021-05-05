package fr.scootop.app.dashboard;

import fr.scootop.data.api.ApiManager;
import fr.scootop.data.model.Board;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ludovicriviere on 23/02/2018.
 */
public class DashboardInteractor
{
    private final DashboardPresenter mPresenter;

    public DashboardInteractor(DashboardPresenter presenter)
    {
        mPresenter = presenter;
    }

    void fetchBoard()
    {
        ApiManager.Companion.get().getBoardService().getBoard()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<Board>()
            {
                @Override
                public void call(Board board)
                {
                    mPresenter.presentBoard(board);
                }
            }, new Action1<Throwable>()
            {
                @Override
                public void call(Throwable throwable)
                {
                    mPresenter.presentError(throwable);
                }
            });
    }
}
