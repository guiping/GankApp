package so.lvy.app.gankapp.view.presenter.imp;

import java.util.List;

import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.bean.GankAppEntity;

/**
 * Created by ping on 2016/4/20.
 */
public interface IAllDataView extends IBaseView{
    void showProgressBar();
    void hideProgressBar();
    void getAllDataSucess();
    void getAllDataError();
    void showListViewData(List<GankAppEntity> allDataEntityList);
}
