package so.lvy.app.gankapp.view.presenter.imp;

/**
 * Created by ping on 2016/4/21.
 */
public interface IWebView extends IBaseView {
    /**
     * 显示加载条
     */
    void showProgressBar(int progress);

    /**
     * 设置标题
     */
    void setTitle(String title);

    /**
     * 打开网页失败
     */
    void openFail();

}
