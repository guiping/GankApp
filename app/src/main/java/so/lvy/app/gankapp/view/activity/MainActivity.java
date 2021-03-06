package so.lvy.app.gankapp.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.apiutils.ApiClient;
import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.utils.DataUtils;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseActivity;
import so.lvy.app.gankapp.view.activity.imp.RefreshMessage;
import so.lvy.app.gankapp.view.fragment.GankAppAllDataFragment;
import so.lvy.app.gankapp.view.fragment.GankAppLatestDailyFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RelativeLayout rLayoutContentView;
    private GankAppAllDataFragment gankAppAllDataFragment;
    private GankAppLatestDailyFragment gankAppLatestDailyFragment;
    private FloatingActionButton fab;
    FragmentManager fm ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();
        fab = (FloatingActionButton) findViewById(R.id.action_share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SnackbarUtils.showSnackbar(view, "测试", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SnackbarUtils.showSnackbar(v, "点击查看的效果--->>>");
                    }
                });
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    protected void initView() {
        rLayoutContentView = (RelativeLayout) $(R.id.rlayout_content_view);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {  //分享

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.daily_data) {   //TODO 每日最新
            replaceAllDataView("每日最新");
        } else if (id == R.id.xia_data) {   //TODO 瞎推荐
            replaceAllDataView("瞎推荐");
        } else if (id == R.id.all_data) { //TODO 所有数据
            replaceAllDataView("all");
        } else if (id == R.id.android_data) { // TODO ANDROID
            replaceAllDataView("Android");
        } else if (id == R.id.ios_data) {   // TODO iOS
            replaceAllDataView("iOS");
        } else if (id == R.id.front_data) { // TODO 前端
            replaceAllDataView("前端");
        } else if (id == R.id.welfare_data) { // TODO 福利
            replaceAllDataView("福利");
        } else if (id == R.id.video_rest_data) {  // TODO 休息视频
            replaceAllDataView("休息视频");
        } else if (id == R.id.spread_resource_data) { // TODO 拓展资源
            replaceAllDataView("拓展资源");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceAllDataView(String type) {
        if (type.contains("每日最新")) {   //每日数据
            if (gankAppLatestDailyFragment == null ) {
                gankAppLatestDailyFragment = new GankAppLatestDailyFragment();
                gankAppLatestDailyFragment.setFloatingActionButton(fab);
            }
            fm.beginTransaction().replace(R.id.rlayout_content_view, gankAppLatestDailyFragment).commitAllowingStateLoss();
        } else {
            if (gankAppAllDataFragment == null) {
                gankAppAllDataFragment = new GankAppAllDataFragment();
                Bundle bun = new Bundle();
                bun.putString("type", type);
                gankAppAllDataFragment.setFloatingActionButton(fab);
                gankAppAllDataFragment.setArguments(bun);
                refreshShowMessageListener = gankAppAllDataFragment;
            }
            fm.beginTransaction().replace(R.id.rlayout_content_view, gankAppAllDataFragment).commitAllowingStateLoss();
            if (gankAppAllDataFragment != null) {
                refreshShowMessageListener.OnRefreshShowMessageListener(type);
            }

        }
    }

    public RefreshShowMessage refreshShowMessageListener;
    public interface RefreshShowMessage {
        void OnRefreshShowMessageListener(String type);
    }
}
