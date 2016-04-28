package so.lvy.app.gankapp.view.presenter;

import android.content.Context;

import java.net.HttpRetryException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import so.lvy.app.gankapp.apiutils.ApiClient;
import so.lvy.app.gankapp.bean.LatestDailyEntity;
import so.lvy.app.gankapp.utils.DataUtils;
import so.lvy.app.gankapp.view.presenter.imp.ILatestDailyView;

/**
 * Created by ping on 2016/4/26.
 */
public class LatestDailyPresenter extends BasePresenter<ILatestDailyView> {
    private Call<LatestDailyEntity> ldeCall;

    public LatestDailyPresenter(Context context, ILatestDailyView iBaseView) {
        super(context, iBaseView);
    }

    public void loadLatestDaily() {
        mIView.showProgressBar();
        ldeCall = ApiClient.getGankApiRetrofit().getLatestDailyData(DataUtils.getCurrentDate());
        ldeCall.enqueue(new Callback<LatestDailyEntity>() {
            @Override
            public void onResponse(Call<LatestDailyEntity> call, Response<LatestDailyEntity> response) {
                mIView.hideProgressBar();
                mIView.showDataList(response.body());
            }


            @Override
            public void onFailure(Call<LatestDailyEntity> call, Throwable t) {
                mIView.hideProgressBar();
                mIView.onGetDataErrer();
            }
        });
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void replease() {
        if (ldeCall != null) {
            ldeCall.cancel();
        }
    }
}
