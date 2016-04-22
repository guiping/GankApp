package so.lvy.app.gankapp.view.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseFragment;
import so.lvy.app.gankapp.view.activity.MainActivity;
import so.lvy.app.gankapp.view.adapter.GankAllDataRecycleViewAdapter;
import so.lvy.app.gankapp.view.presenter.AllDataPresenter;
import so.lvy.app.gankapp.view.presenter.imp.IAllDataView;
import so.lvy.app.gankapp.view.widget.LMRecyclerView;

import static so.lvy.app.gankapp.view.adapter.GankAllDataRecycleViewAdapter.OnItemRecycleViewListener;

/**
 * Created by ping on 2016/4/20.
 * 显示全部数据
 */
public class GankAppAllDataFragment extends BaseFragment<AllDataPresenter> implements IAllDataView, SwipeRefreshLayout.OnRefreshListener, LMRecyclerView.LoadMoreListener, MainActivity.RefreshShowMessage ,OnItemRecycleViewListener{

    //    @Bind(R.id.swipe_refresh_layout)
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //    @Bind(R.id.recycler_view)
    private LMRecyclerView mRecyclerView;
    private int pager = 1;
    private String mType;
    private GankAllDataRecycleViewAdapter gankAllDataRecycleViewAdapter;
    private final String TAG = "GankAppDataFragment";

    private List<GankAppEntity> mList;
    private AllDataPresenter mAllDataPresenter;

    private boolean isLoadingData = true;

    @Override
    protected void initWidget(View view) {
        mSwipeRefreshLayout = $(view, R.id.swipe_refresh_layout);
        mRecyclerView = $(view, R.id.recycler_view);
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
            Log.e("TAG", "执行这个方法");
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
    public void onDestroy() {
        super.onDestroy();
        mAllDataPresenter.replease();
    }

    @Override
    public void getAllDataError() {
        SnackbarUtils.showSnackbar(layoutView, "网络连接异常,请检查您的网络...", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAllDataPresenter.getGankAppAllData("IOS", 1);
            }
        });
    }

    @Override
    public void showListViewData(List<GankAppEntity> allDataEntityList) {
        if (!isLoadingData) {   //判断是刷新 还是加载更多
            if (mList != null) {
                mList.clear();
            }
        }
        mList.addAll(allDataEntityList);
        if (gankAllDataRecycleViewAdapter != null) {
            gankAllDataRecycleViewAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void initView() {
        mList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (fab != null) {
            mRecyclerView.applyFloatingActionButton(fab);
        }
        gankAllDataRecycleViewAdapter = new GankAllDataRecycleViewAdapter(getActivity(), mList);
        gankAllDataRecycleViewAdapter.setOnItemRecycleViewListener(this);
        mRecyclerView.setAdapter(gankAllDataRecycleViewAdapter);
        mRecyclerView.setLoadMoreListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        if (mAllDataPresenter != null) {
            mAllDataPresenter.getGankAppAllData(mType, pager);
        }
    }

    @Override
    public void onRefresh() {   //刷新
        isLoadingData = false;
        pager = 1;
        mAllDataPresenter.getGankAppAllData(mType, pager);
    }

    @Override
    public void loadMore() {
        pager++;
        isLoadingData = true;
        mAllDataPresenter.getGankAppAllData(mType, pager);
    }

    @Override
    public void OnRefreshShowMessageListener(String type) {
        mType = type;
        if (mAllDataPresenter != null) {
            isLoadingData = false;
            if (mAllDataPresenter != null) {
                mAllDataPresenter.getGankAppAllData(mType, pager);
            }
        }
    }

    @Override
    public void onItemRecycleViewListener(int type, GankAppEntity gankAppEntity) {
     if(type == GankAllDataRecycleViewAdapter.IMGTYPE) {
         SnackbarUtils.showSnackbar(mRecyclerView,"点击选择图片");
     } else if(type == GankAllDataRecycleViewAdapter.TEXTTYPE){
         SnackbarUtils.showSnackbar(mRecyclerView,"点击选择文本");
     } else if(type == GankAllDataRecycleViewAdapter.VIDEOTYPE) {
         SnackbarUtils.showSnackbar(mRecyclerView,"点击选择视频");
     }
    }
}
