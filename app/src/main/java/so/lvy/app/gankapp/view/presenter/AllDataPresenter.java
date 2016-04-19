package so.lvy.app.gankapp.view.presenter;

import android.content.Context;

import so.lvy.app.gankapp.apiutils.ApiClient;
import so.lvy.app.gankapp.view.presenter.imp.IAllDataView;

/**
 * Created by ping on 2016/4/20.
 * 加载所有类型数据的Presenter
 */
public class AllDataPresenter extends BasePresenter<IAllDataView> {
    public AllDataPresenter(Context context, IAllDataView iBaseView) {
        super(context, iBaseView);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void replease() {

    }

    public void getGankAppAllData(String type,int page){
        ApiClient.getGankApiRetrofit().getGankAppAllData(type,page);
    }
}
