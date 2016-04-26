package so.lvy.app.gankapp.view.presenter.imp;

/**
 * Created by ping on 2016/4/26.
 * 刷新每日数据的IView
 */
public interface ILatestDailyView extends IBaseView {
    /**显示加载对话框*/
    void showProgressBar();
    /**隐藏加载对话框*/
    void hideProgressBar();
    void showDataList();
    void onGetDataErrer();
}
