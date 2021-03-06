package so.lvy.app.gankapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import so.lvy.app.gankapp.view.presenter.BasePresenter;

/**
 * Created by ping on 2016/4/20.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {
    public View layoutView;

    protected FloatingActionButton fab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, v);
        this.layoutView = v;
        initPresenter();
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
  public void setFloatingActionButton(FloatingActionButton floatingActionButton){
      this.fab = floatingActionButton;
  }
    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }


    protected abstract int getLayoutId();

    protected abstract void initPresenter();
}
