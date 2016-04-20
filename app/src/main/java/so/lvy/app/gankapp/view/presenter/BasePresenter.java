package so.lvy.app.gankapp.view.presenter;

import android.content.Context;

import so.lvy.app.gankapp.view.presenter.imp.IBaseView;

/**
 *
 * Created by ping on 2016/4/20.
 * 基类Presenter
 */
public abstract class BasePresenter <T extends IBaseView>{
    public Context mContext;
    public T mIView;
   public BasePresenter(Context context,T iBaseView){
        this.mContext = context;
        this.mIView = iBaseView;
    }
    protected void init(){

         mIView.initView();
    }

    protected abstract void replease();
}
