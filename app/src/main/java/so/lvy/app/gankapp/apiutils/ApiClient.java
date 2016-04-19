package so.lvy.app.gankapp.apiutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ping on 2016/4/19.
 */
public class ApiClient {
   private static final String BASEHOST = "http://gank.io/api/" ;
   private static Retrofit mRetrofit;
   private static GankAppDataRetrofit mGankAppDataRetrofit;
   private static final Object monity = new Object();

   public ApiClient(){
   }
   static {
      Gson mGson = new GsonBuilder()
              .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
              .create();
      mRetrofit =new Retrofit.Builder()
              .baseUrl(BASEHOST)
              .addConverterFactory(GsonConverterFactory.create(mGson))
              .build();
   }

   public static GankAppDataRetrofit getGankApiRetrofit(){
      synchronized (monity){
         if(mGankAppDataRetrofit == null ) {
            mGankAppDataRetrofit = mRetrofit.create(GankAppDataRetrofit.class);
         }
         return mGankAppDataRetrofit;
      }
   }


}
