package fr.scootop.app.shortlist;

import java.util.List;

import fr.scootop.app.common.vip.LoadingView;
import fr.scootop.data.model.ShortlistCollectionItem;

public interface ShortlistView extends LoadingView
{
    void displayItems(List<ShortlistCollectionItem> items);

    void displayEmptyView();

    void displayError(String message);
}
