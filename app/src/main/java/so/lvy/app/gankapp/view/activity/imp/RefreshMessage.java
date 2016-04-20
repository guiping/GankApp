package so.lvy.app.gankapp.view.activity.imp;

/**
 * Created by ping on 2016/4/21.
 */
public class RefreshMessage {
    public  static RefreshShowMessage refreshShowMessage;
    public interface RefreshShowMessage{
        void OnRefreshShowMessageListener(String type);
    }
    public static void setOnRefreshShowMessageListener(RefreshShowMessage refreshShowMessageListener){
        refreshShowMessage = refreshShowMessageListener;
    }
}
