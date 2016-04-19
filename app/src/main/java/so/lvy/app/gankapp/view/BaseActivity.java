package so.lvy.app.gankapp.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import so.lvy.app.gankapp.view.presenter.BasePresenter;

/**
 * Created by ping on 2016/4/19.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(getLayoutId());
        initPresenter();
        initView();
    }
    protected abstract int getLayoutId();
    protected abstract void initPresenter();
    protected abstract void initView();

    /**findViewById(int id)*/
    public <T extends View> T $(int id){
       return  (T) super.findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
