package fr.scootop.app.shortlist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.scootop.R;
import fr.scootop.app.common.ExtraKey;
import fr.scootop.app.player.details.old.PlayerDetailsActivity;
import fr.scootop.data.model.ShortlistCollectionItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShortlistFragment extends Fragment implements ShortlistView, OnShortlistUserListener
{
    @BindView(R.id.shortlist_swiperefresh)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.shortlist_empty_textview)
    TextView mEmptyTextView;

    @BindView(R.id.shortlist_recyclerview)
    RecyclerView mRecyclerView;

    private ProgressDialog mProgressDialog;
    private ShortlistInteractor mInteractor;
    private ShortlistAdapter mAdapter;

    public static ShortlistFragment newInstance(Long userId)
    {
        Bundle args = new Bundle();
        args.putLong(ExtraKey.INSTANCE.getUSER_ID(), userId);

        ShortlistFragment fragment = new ShortlistFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        mInteractor = new ShortlistInteractor(new ShortlistPresenter(this));
        if (getArguments() != null) {
            mInteractor.setUserId(getArguments().getLong(ExtraKey.INSTANCE.getUSER_ID(), -1));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_shortlist, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new ShortlistAdapter(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                mInteractor.fetchShortlist();
            }
        });
    }

    @Override
    public void onResume()
    {
        super.onResume();
        mInteractor.fetchShortlist();
    }

    @Override
    public void showLoading()
    {
        mProgressDialog = ProgressDialog.show(getContext(), getString(R.string.dialog_loading_title), getString(R.string.dialog_loading_message), true);
    }

    @Override
    public void hideLoading()
    {
        mProgressDialog.dismiss();
    }

    @Override
    public void displayItems(List<ShortlistCollectionItem> items)
    {
        mAdapter.setItems(items);
        mSwipeRefreshLayout.setRefreshing(false);
        mEmptyTextView.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void displayEmptyView()
    {
        mSwipeRefreshLayout.setRefreshing(false);
        mEmptyTextView.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);

        System.out.println("display empty");
    }

    @Override
    public void displayError(String message)
    {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onDisplayPlayer(Integer playerId)
    {
        Intent intent = new Intent(getActivity(), PlayerDetailsActivity.class);
        intent.putExtra(ExtraKey.INSTANCE.getPLAYER_ID(), playerId);
        startActivity(intent);
    }
}
