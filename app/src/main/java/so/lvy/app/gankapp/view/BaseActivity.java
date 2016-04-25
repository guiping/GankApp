package so.lvy.app.gankapp.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.view.presenter.BasePresenter;

/**
 * Created by ping on 2016/4/19.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initPresenter();
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initPresenter();

    protected abstract void initView();

    /**
     * findViewById(int id)
     */
    public <V extends View> V $(int id) {
//        return (V) this.findViewById(id);
        return (V) super.findViewById(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
