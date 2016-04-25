package so.lvy.app.gankapp.view.activity;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import butterknife.Bind;
import butterknife.ButterKnife;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.utils.GankAppConfig;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseActivity;
import so.lvy.app.gankapp.view.presenter.WebViewDetailMsgPresenter;
import so.lvy.app.gankapp.view.presenter.imp.IWebView;

/**
 * Created by ping on 2016/4/21.
 */
public class WebViewDetailMsgActivity extends BaseActivity<WebViewDetailMsgPresenter> implements IWebView {


    @Bind(R.id.toolbar)
    Toolbar mToolBar;
    @Bind(R.id.webview_show_message)
    WebView mWebView;
    @Bind(R.id.progress_bar)
    ContentLoadingProgressBar progressBar;

    private WebViewDetailMsgPresenter mWebPresenter;
    private GankAppEntity gankAppEntity;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initPresenter() {
        mWebPresenter = new WebViewDetailMsgPresenter(this, this);
        mWebPresenter.init();
    }

    @Override
    public void initView() {
        mToolBar.setNavigationIcon(R.drawable.ic_title_back);
        setSupportActionBar(mToolBar);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Bundle bun = getIntent().getBundleExtra(GankAppConfig.ACTIVITY_PUT_BUNDLE_NAME);
        if (bun != null) {
            gankAppEntity = (GankAppEntity) bun.getSerializable("ganAppEntity");
        }
        if (gankAppEntity != null) {
            mWebPresenter.setWebViewSettings(mWebView, gankAppEntity.getUrl());
            mToolBar.setTitle(gankAppEntity.getDesc());
        }

    }

    @Override
    public void showProgressBar(int progress) {
        Log.e("TAG", "--->>>>" + progress);

        if (progressBar == null) return;
        if (progress == 100) {
            progressBar.setVisibility(View.GONE);
        } else {
            progressBar.setVisibility(View.VISIBLE);
            progressBar .setProgress(progress);
        }
    }

    @Override
    public void setTitle(String title) {
        Log.e("TAG", "-111-->>>>" + title);
//         setTitle(title);
    }

    @Override
    public void openFail() {
        SnackbarUtils.showSnackbar(mWebView, "重试", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gankAppEntity != null)
                    mWebPresenter.setWebViewSettings(mWebView, gankAppEntity.getUrl());
                mWebPresenter.setWebViewSettings(mWebView, gankAppEntity.getUrl());
            }
        });
    }

    @Override
    protected void onResume() {
        if (mWebView != null) mWebView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (mWebView != null) mWebView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {

            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
        mWebPresenter.replease();
    }


}
