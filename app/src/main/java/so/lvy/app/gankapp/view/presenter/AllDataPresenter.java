package so.lvy.app.gankapp.view.presenter;

import android.content.Context;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import so.lvy.app.gankapp.apiutils.ApiClient;
import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.view.presenter.imp.IAllDataView;

/**
 * Created by ping on 2016/4/20.
 * 加载所有类型数据的Presenter
 */
public class AllDataPresenter extends BasePresenter<IAllDataView> {
    Call<GankAppAllDataEntity> gankAppCall;
    public AllDataPresenter(Context context, IAllDataView iBaseView) {
        super(context, iBaseView);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void replease() {
        if (mIView != null)
           mIView = null;
        mContext = null;
        if (gankAppCall !=null){
            gankAppCall.cancel();
        }
    }

    public void getGankAppAllData(String type, int page) {
        if (mIView != null)
            mIView.showProgressBar();
        gankAppCall  = ApiClient.getGankApiRetrofit().getGankAppAllData(type, page);
        gankAppCall.enqueue(new Callback<GankAppAllDataEntity>() {
            @Override
            public void onResponse(Call<GankAppAllDataEntity> call, Response<GankAppAllDataEntity> response) {
                if (mIView != null) {
                    mIView.hideProgressBar();
                    mIView.showListViewData(response.body().getResults());
                }
            }

            @Override
            public void onFailure(Call<GankAppAllDataEntity> call, Throwable t) {
                if (mIView != null) {
                    mIView.hideProgressBar();
                    mIView.getAllDataError();
                }
            }
        });
    }
}
