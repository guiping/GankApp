package so.lvy.app.gankapp.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.view.BaseFragment;
import so.lvy.app.gankapp.view.presenter.AllDataPresenter;
import so.lvy.app.gankapp.view.presenter.imp.IAllDataView;

/**
 * Created by ping on 2016/4/20.
 * 显示全部数据
 */
public class GankAppAllDataFragment extends BaseFragment<AllDataPresenter> implements IAllDataView {

    @Bind(R.id.swipe_refresh_layout)
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Bind(R.id.recycler_view)
    private RecyclerView mRecyclerView;

    private AllDataPresenter mAllDataPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_alldata;
    }
    @Override
    protected void initPresenter() {
        mAllDataPresenter = new AllDataPresenter(getActivity(),this);
        mAllDataPresenter.init();
    }

    @Override
    public void showProgressBar() {
     if(!mSwipeRefreshLayout.isRefreshing()) {
         mSwipeRefreshLayout.setRefreshing(true);
     }
    }

    @Override
    public void hideProgressBar() {
        if(mSwipeRefreshLayout.isRefreshing()) {
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

    }

    @Override
    public void initView() {
      //初始化所有的View


    }
}
