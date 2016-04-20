package so.lvy.app.gankapp.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import so.lvy.app.gankapp.R;

/**
 * @author gping  email: gping.vip@gmail.com
 * @date Created by 2016/4/20.20:08
 * @filename ImageLoader.class
 * @description
 * @TODO
 */
public class ImageLoaderUtils {
    public static void imageLoader(Context context, ImageView iv, String ivPath) {

        Glide.with(context)
                .load(ivPath)
                .centerCrop()
                .into(iv);
    }
}
