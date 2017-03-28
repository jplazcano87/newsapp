package news.spaceghost.com.newsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NewsDetailsActivity extends AppCompatActivity {

  private static final String KEY_INDEX = "KEY_INDEX";
  private WebView mWebView;
  private ProgressBar mProgressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_news_details);

    mWebView = (WebView) findViewById(R.id.activity_news_details_webview);
    mProgressBar = (ProgressBar) findViewById(R.id.activity_news_details_progressbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    int index = getIntent().getIntExtra(KEY_INDEX, -1);
    updateNewsDetails(index);
    if (index != -1) {
      updateNewsDetails(index);
    } else {
      Toast.makeText(NewsDetailsActivity.this, "Index error", Toast.LENGTH_SHORT)
          .show();
    }
  }

  public void updateNewsDetails(int index) {
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.setWebViewClient(new WebViewClient() {
      @Override
      public void onPageStarted(WebView view, String url, Bitmap favicon) {
        mProgressBar.setVisibility(View.VISIBLE);
      }

      @Override
      public void onPageFinished(WebView view, String url) {
        mProgressBar.setVisibility(View.GONE);
      }

      @Override
      public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        mProgressBar.setVisibility(View.GONE);
        Toast.makeText(NewsDetailsActivity.this, "Error loading the page", Toast.LENGTH_SHORT)
            .show();
      }
    });
    mWebView.loadUrl(NewsStore.getNewsArticles().get(index).getUrlToArticle());
    getSupportActionBar().setTitle(NewsStore.getNewsArticles().get(index).getTitle());

  }


  public static void launch(Context context, int index) {

    Intent intent = new Intent(context, NewsDetailsActivity.class);
    intent.putExtra(KEY_INDEX, index);
    context.startActivity(intent);

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
      case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
