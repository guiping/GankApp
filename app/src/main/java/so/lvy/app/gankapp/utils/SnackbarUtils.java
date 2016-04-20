package so.lvy.app.gankapp.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by ping on 2016/4/19.
 */
public class SnackbarUtils {

    public static void showSnackbar(View view, String message, View.OnClickListener listener){
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setAction("点击",listener).show();
    }
    public static void showSnackbar(View view, String message){
        showSnackbar(view,message,null);
    }

}
