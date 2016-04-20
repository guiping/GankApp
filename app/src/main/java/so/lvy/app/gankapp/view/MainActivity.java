package so.lvy.app.gankapp.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.apiutils.ApiClient;
import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.utils.SnackbarUtils;
import so.lvy.app.gankapp.view.BaseActivity;
import so.lvy.app.gankapp.view.fragment.GankAppAllDataFragment;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private RelativeLayout rLayoutContentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.action_share);
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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.daily_data) {   //TODO 每日最新
            // Handle the camera action
            Log.e("TAG", "点击查看 每日最新数据--->>>>");

            Call<GankAppAllDataEntity> callRequest = ApiClient.getGankApiRetrofit().getGankAppAllData("Android", 1);
            callRequest.enqueue(new Callback<GankAppAllDataEntity>() {
                @Override
                public void onResponse(Call<GankAppAllDataEntity> call, Response<GankAppAllDataEntity> response) {
                    Log.e("TAG", response.body().getResults().size() + "----" + response.body().getResults().get(0).getWho());
                }
                @Override
                public void onFailure(Call<GankAppAllDataEntity> call, Throwable t) {
                    Log.e("TAG", "失败" + t.getMessage());
                }
            });


        } else if (id == R.id.all_data) { //TODO 所有数据
            GankAppAllDataFragment gankAppAllDataFragment = new GankAppAllDataFragment();
            replaceView(gankAppAllDataFragment);
        } else if (id == R.id.android_data) { // TODO ANDROID

        } else if (id == R.id.ios_data) {   // TODO IOS

        } else if (id == R.id.front_data) { // TODO 前段

        } else if (id == R.id.welfare_data) { // TODO 福利

        } else if (id == R.id.video_rest_data) {  // TODO 休息视频

        } else if (id == R.id.spread_resource_data) { // TODO 拓展资源

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceView(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.rlayout_content_view, fragment).commitAllowingStateLoss();
    }
}
