package so.lvy.app.gankapp.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import so.lvy.app.gankapp.R;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.utils.GankAppConfig;
import so.lvy.app.gankapp.utils.ImageLoaderUtils;
import so.lvy.app.gankapp.view.BaseActivity;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by ping on 2016/4/23.
 */
public class ShowPhotoViewActivity  extends AppCompatActivity implements Toolbar.OnMenuItemClickListener{
    private ImageView ivShowPhotoView;
    private GankAppEntity gankAppEntity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showphotoview);
        Bundle bun = getIntent().getBundleExtra(GankAppConfig.ACTIVITY_PUT_BUNDLE_NAME);
        if( bun != null ) {
            gankAppEntity = (GankAppEntity) bun.getSerializable("ganAppEntity");
        }

        initView();
    }
    private void initView(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(gankAppEntity.getDesc()+"");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_title_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        toolbar.setOnMenuItemClickListener(this);


        ivShowPhotoView = (ImageView) findViewById(R.id.iv_show_photoview);
        ImageLoaderUtils.imageLoader(this,ivShowPhotoView,gankAppEntity.getUrl());
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(ivShowPhotoView);
        photoViewAttacher.update();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
       switch (item.getItemId()) {
           case R.id.action_photo_save:
               Log.e("TAG","保存----》》》");
               break;
           case R.id.action_photo_share:
               Log.e("TAG","分享---->>>");
               break;
       }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.show_photodetail_menu,menu);
        return true;
    }
}
