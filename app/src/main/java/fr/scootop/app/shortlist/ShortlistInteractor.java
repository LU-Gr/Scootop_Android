package fr.scootop.app.shortlist;

import java.util.List;

import fr.scootop.data.api.ApiManager;
import fr.scootop.data.model.ShortlistCollectionItem;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class ShortlistInteractor
{
    private final ShortlistPresenter mPresenter;

    private Long mUserId;

    public ShortlistInteractor(ShortlistPresenter presenter)
    {
        mPresenter = presenter;
    }

    public void setUserId(Long userId)
    {
        mUserId = userId;
    }

    public void fetchShortlist()
    {
        if (mUserId == null) {
            return;
        }

        //mPresenter.presentLoading();

        ApiManager.Companion.get().getShortlistItemService().getShortlistItems(mUserId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<List<ShortlistCollectionItem>>()
                {
                    @Override
                    public void call(List<ShortlistCollectionItem> shortlistCollectionItems)
                    {
                        //mPresenter.dismissLoading();
                        mPresenter.presentShortlistItems(shortlistCollectionItems);
                    }
                }, new Action1<Throwable>()
                {
                    @Override
                    public void call(Throwable throwable)
                    {
                        //mPresenter.dismissLoading();
                        throwable.printStackTrace();
                        mPresenter.presentError(throwable.getLocalizedMessage());
                    }
                });
    }
}
