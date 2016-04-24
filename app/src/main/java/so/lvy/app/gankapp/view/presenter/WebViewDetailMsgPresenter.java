package so.lvy.app.gankapp.view.presenter;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import so.lvy.app.gankapp.view.presenter.imp.IWebView;

/**
 * Created by ping on 2016/4/21.
 */
public class WebViewDetailMsgPresenter extends BasePresenter<IWebView> {
    public WebViewDetailMsgPresenter(Context context, IWebView iBaseView) {
        super(context, iBaseView);
    }

    public void setWebViewSettings(WebView webView, String url) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);  //允许加载js脚本
        webSettings.setLoadWithOverviewMode(true); //设置WebView 宽度是否根据屏幕的宽度 自动放大缩小
        webSettings.setAppCacheEnabled(true);   //设置打开缓存
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setSupportZoom(true);   //设置WebView是否根据手势放大缩小
        webView.setWebChromeClient(new ChromerClient());
        webView.setWebViewClient(new WebClient());
        webView.loadUrl(url);
    }

    private class ChromerClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {   //WebView加载页面的当前进展情况。      newProgress当前加载进度
            super.onProgressChanged(view, newProgress);
            if (mIView != null) {
                mIView.showProgressBar(newProgress);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {  //收到当前Title变化情况
            super.onReceivedTitle(view, title);
            if (mIView != null) {
                mIView.setTitle(title);
            }
        }
    }

    private class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void replease() {

    }

}
