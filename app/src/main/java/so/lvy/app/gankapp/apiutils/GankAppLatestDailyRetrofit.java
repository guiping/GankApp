package so.lvy.app.gankapp.apiutils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import so.lvy.app.gankapp.bean.GankAppEntity;

/**
 * Created by ping on 2016/4/19.
 * 每日最新资源的 Retrofit
 */
public interface GankAppLatestDailyRetrofit {
    @GET("day/{year}/{month}/{day}")
    Call<GankAppEntity> getLatestDailyData(@Path("year") String year,@Path("month") String month,@Path("day") String day);


    @GET("day/{time}")
    Call<GankAppEntity> getLatestDailyData(@Path("time") String time);

}
