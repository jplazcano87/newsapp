package news.spaceghost.com.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import news.spaceghost.com.newsapp.model.GetArticlesResponse;
import news.spaceghost.com.newsapp.networking.NewsAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private RecyclerView newsRecyclerView;
  private CoordinatorLayout mCoordinatorLayout;
  private ProgressBar mProgressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);
    newsRecyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
    newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    mProgressBar = (ProgressBar) findViewById(R.id.activity_main_progressbar);



    Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("espn", "top");

    call.enqueue(new Callback<GetArticlesResponse>() {
      @Override
      public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
        mProgressBar.setVisibility(View.GONE);
        showNewsApiSnack();
        GetArticlesResponse getArticlesResponse = response.body();
        NewsStore.setNewsArticles(getArticlesResponse.getArticles());
        Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(getArticlesResponse.getArticles());
        newsRecyclerView.setAdapter(homeNewsAdapter);
      }

      @Override
      public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(MainActivity.this, "response received", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void showNewsApiSnack(){
    Snackbar.make(mCoordinatorLayout, "Powered by NewsApi.org", Snackbar.LENGTH_LONG).setAction
        ("Visit", new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            loadNewsWebsite();
          }
        }).show();
  }

  private void loadNewsWebsite(){
    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org")));
  }
}
