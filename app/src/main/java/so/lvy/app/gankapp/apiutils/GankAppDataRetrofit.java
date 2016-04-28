package so.lvy.app.gankapp.apiutils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import so.lvy.app.gankapp.bean.GankAppAllDataEntity;
import so.lvy.app.gankapp.bean.GankAppEntity;
import so.lvy.app.gankapp.bean.LatestDailyEntity;
import so.lvy.app.gankapp.utils.GankAppConfig;

/**
 * Created by ping on 2016/4/19.
 * 所有资源的请求----》》 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all  | 每日最新
 */
public interface GankAppDataRetrofit {
    /**
     * 同步获取所有类型的资源
     */
    @GET("data/{type}/" + GankAppConfig.PAGER_SIZE + "/{pager}")
    Call<GankAppAllDataEntity> getGankAppAllData(@Path("type") String type, @Path("pager") int pager);
    /**
     * 同步获取当日最新的资源
     */
    @GET("day/{year}/{month}/{day}")
    Call<LatestDailyEntity> getLatestDailyData(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    @GET("day/{date}")
    Call<LatestDailyEntity> getLatestDailyData(@Path("date") String date);
}
