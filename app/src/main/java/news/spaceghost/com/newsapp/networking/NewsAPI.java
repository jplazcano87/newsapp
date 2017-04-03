package news.spaceghost.com.newsapp.networking;

import news.spaceghost.com.newsapp.model.GetArticlesResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by spaceghost on 3/30/17.
 */

public class NewsAPI {

  private static final String API_KEY = "8962bbea322e448fbf0b42f67ca14d8e";
  private static final String API_PATH = "https://newsapi.org/v1/";

  private static NewsService sNewsService = null;

  public static NewsService getApi(){
    if(sNewsService == null){
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(API_PATH)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      sNewsService = retrofit.create(NewsService.class);
    }
    return sNewsService;
  }

  
  public interface NewsService {
    @GET("articles?apiKey=" + API_KEY)
    Call<GetArticlesResponse> getArticles(@Query("source") String source, @Query("sortBy") String
        sortBy);
  }

}
