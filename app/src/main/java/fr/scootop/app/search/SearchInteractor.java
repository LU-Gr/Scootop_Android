package fr.scootop.app.search;

import android.text.TextUtils;

import java.util.List;

import fr.scootop.data.api.ApiManager;
import fr.scootop.data.model.PlayerSearchItem;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SearchInteractor
{
	private final SearchPresenter mPresenter;

	public SearchInteractor(SearchPresenter presenter)
	{
		mPresenter = presenter;
	}

	public void search(String text)
	{
		/** si le texte est vide, on ne fait pas la rechercher avec l'API */
		if (TextUtils.isEmpty(text)) {
			mPresenter.presentPlayers(null);
			return;
		}

		if (text.length() < 4){
			return;
		}

		/** appel de l'API pour recherche les joueurs correspondant au texte */
		ApiManager.Companion.get().getSearchService()
                            .searchPlayers(text)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Action1<List<PlayerSearchItem>>()
			{
				/** en cas de succès */
				@Override
				public void call(List<PlayerSearchItem> playerSearchItems)
				{
					mPresenter.presentPlayers(playerSearchItems);
				}
			}, new Action1<Throwable>()
			{
				/** en cas d'erreur */
				@Override
				public void call(Throwable throwable)
				{
					mPresenter.presentError(throwable.getMessage());
				}
			});
	}
}
