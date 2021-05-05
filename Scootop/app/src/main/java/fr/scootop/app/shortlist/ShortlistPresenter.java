package fr.scootop.app.shortlist;

import java.lang.ref.WeakReference;
import java.util.List;

import fr.scootop.app.common.vip.LoadingPresenter;
import fr.scootop.app.login.LoginView;
import fr.scootop.data.model.ShortlistCollectionItem;

public class ShortlistPresenter implements LoadingPresenter
{
	private WeakReference<ShortlistView> mView;

	public ShortlistPresenter(ShortlistView view)
	{
		mView = new WeakReference<>(view);
	}

	@Override
	public void presentLoading()
	{
		mView.get().showLoading();
	}

	@Override
	public void dismissLoading()
	{
		mView.get().hideLoading();
	}

	public void presentShortlistItems(List<ShortlistCollectionItem> items)
	{
		if (items != null && !items.isEmpty()) {
			mView.get().displayItems(items);
		} else {
			mView.get().displayEmptyView();
		}
	}

	public void presentError(String message)
	{
		mView.get().displayError(message);
	}
}
