package so.lvy.app.gankapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.view.BaseFragment;
import so.lvy.app.gankapp.view.adapter.GankAllDataRecycleViewAdapter;
import so.lvy.app.gankapp.view.presenter.AllDataPresenter;
import so.lvy.app.gankapp.view.presenter.imp.IAllDataView;
import so.lvy.app.gankapp.view.widget.LMRecyclerView;

/**
 * Created by ping on 2016/4/20.
 * 显示全部数据
 */
public class GankAppAllDataFragment extends BaseFragment<AllDataPresenter> implements IAllDataView,SwipeRefreshLayout.OnRefreshListener,LMRecyclerView.LoadMoreListener {

    //    @Bind(R.id.swipe_refresh_layout)
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //    @Bind(R.id.recycler_view)
    private LMRecyclerView mRecyclerView;
    private int pager = 1;
    private GankAllDataRecycleViewAdapter gankAllDataRecycleViewAdapter;

    private List<GankAppEntity> mList;
    private AllDataPresenter mAllDataPresenter;

    private boolean isLoadingData = true;

    @Override
    protected void initWidget(View view) {
        mSwipeRefreshLayout = $(view,R.id.swipe_refresh_layout);
        mRecyclerView = $(view,R.id.recycler_view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_alldata;
    }

    @Override
    protected void initPresenter() {
        mAllDataPresenter = new AllDataPresenter(getActivity(), this);
        mAllDataPresenter.init();
    }

    @Override
    public void showProgressBar() {
        if (!mSwipeRefreshLayout.isRefreshing()) {
            Log.e("TAG","执行这个方法");
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgressBar() {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void getAllDataSucess() {

    }

    @Override
    public void getAllDataError() {

    }

    @Override
    public void showListViewData(List<GankAppEntity> allDataEntityList) {
        if (!isLoadingData) {   //判断是刷新 还是加载更多
            if(mList != null ) {
                mList.clear();
            }
        }
        mList.addAll(allDataEntityList);
        if(gankAllDataRecycleViewAdapter != null ) {
            gankAllDataRecycleViewAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        //初始化所有的View
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        gankAllDataRecycleViewAdapter = new GankAllDataRecycleViewAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(gankAllDataRecycleViewAdapter);
        mRecyclerView.setLoadMoreListener(this);
        mAllDataPresenter.getGankAppAllData("Android", pager);

        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {   //刷新
        isLoadingData = false;
        pager = 1;
        mAllDataPresenter.getGankAppAllData("Android", pager);
    }

    @Override
    public void loadMore() {
        pager ++;
        isLoadingData = true;
        mAllDataPresenter.getGankAppAllData("Android", pager);
    }
}
