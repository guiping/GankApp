package so.lvy.app.gankapp.view.presenter.imp;

import java.util.List;

import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.bean.GankAppEntity;

/**
 * Created by ping on 2016/4/20.
 */
public interface IAllDataView extends IBaseView{
    /**显示加载对话框*/
    void showProgressBar();
    /**隐藏加载对话框*/
    void hideProgressBar();
    void getAllDataError();
    void showListViewData(List<GankAppEntity> allDataEntityList);
}
