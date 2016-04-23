package so.lvy.app.gankapp.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Activity 之间跳转 工具类
 * Created by ping on 2016/4/23.
 */
public class StartActivityUtils {
    private StartActivityUtils() {
    }

    public static void startActivity(Activity atc, Class t) {
        startActivity(atc, t, false);
    }

    public static void startActivity(Activity atc, Class t, boolean isFinish) {
        startActivity(atc, t, isFinish, null);
    }

    public static void startActivity(Activity atc, Class t, boolean isFinish, Bundle bundle) {
        Intent intent = new Intent(atc, t);
        if (bundle != null) {
            intent.putExtra(GankAppConfig.ACTIVITY_PUT_BUNDLE_NAME,bundle);
        }
        atc.startActivity(intent);
        if (isFinish) {
            atc.finish();
        }
    }
}
