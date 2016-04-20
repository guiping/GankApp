package so.lvy.app.gankapp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
    private View layoutView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(getLayoutId(), container, false);
        initWidget(v);
        ButterKnife.bind(this, v);
        initPresenter();
        this.layoutView = v;
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected <T extends View> T $(View itemView ,int id) {
        return (T) itemView.findViewById(id);
    }

    protected abstract void initWidget(View view);

    protected abstract int getLayoutId();

    protected abstract void initPresenter();
}
