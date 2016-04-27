package so.lvy.app.gankapp.view.fragment;

import butterknife.Bind;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseFragment;
import so.lvy.app.gankapp.view.presenter.LatestDailyPresenter;
import so.lvy.app.gankapp.view.presenter.imp.ILatestDailyView;
import so.lvy.app.gankapp.view.widget.LMRecyclerView;

/**
 * Created by ping on 2016/4/20.
 * 显示每日最新的Fragment
 */
public class GankAppLatestDailyFragment extends BaseFragment<LatestDailyPresenter> implements ILatestDailyView{

    @Bind(R.id.show_gankRecycleView)
    LMRecyclerView showGankRecycleView;
    private LatestDailyPresenter mLatestDailyPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_ganlatestdaily;
    }

    @Override
    protected void initPresenter() {
        mLatestDailyPresenter = new LatestDailyPresenter(getActivity(),this);
        mLatestDailyPresenter.init();
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showDataList() {

    }

    @Override
    public void onGetDataErrer() {
        SnackbarUtils.showSnackbar(showGankRecycleView,"网络连接错误,请检查网络后重试...");
    }

    @Override
    public void initView() {
        showGankRecycleView.applyFloatingActionButton(fab);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
         mLatestDailyPresenter.replease();
    }
}
