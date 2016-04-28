package so.lvy.app.gankapp.view.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.LatestDailyEntity;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseFragment;
import so.lvy.app.gankapp.view.presenter.LatestDailyPresenter;
import so.lvy.app.gankapp.view.presenter.imp.ILatestDailyView;
import so.lvy.app.gankapp.view.widget.LMRecyclerView;

/**
 * Created by ping on 2016/4/20.
 * 显示每日最新的Fragment
 */
public class GankAppLatestDailyFragment extends BaseFragment<LatestDailyPresenter> implements ILatestDailyView {

    @Bind(R.id.show_gankRecycleView)
    LMRecyclerView showGankRecycleView;
    @Bind(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private LatestDailyPresenter mLatestDailyPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ganlatestdaily;
    }

    @Override
    protected void initPresenter() {
        mLatestDailyPresenter = new LatestDailyPresenter(getActivity(), this);
        mLatestDailyPresenter.init();
    }

    @Override
    public void showProgressBar() {
        if (!swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideProgressBar() {
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showDataList(LatestDailyEntity latestDailyEntity) {

    }

    @Override
    public void onGetDataErrer() {
        SnackbarUtils.showSnackbar(showGankRecycleView, "网络连接错误,请检查网络后重试...");
    }

    @Override
    public void initView() {
        showGankRecycleView.applyFloatingActionButton(fab);


        mLatestDailyPresenter.loadLatestDaily();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLatestDailyPresenter.replease();
    }

}
