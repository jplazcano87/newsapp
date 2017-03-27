package news.spaceghost.com.newsapp;

import java.util.ArrayList;
import java.util.List;

import news.spaceghost.com.newsapp.model.NewsArticle;

/**
 * Created by spaceghost on 3/26/17.
 */

public class NewsStore {
  private static List<NewsArticle> sNewsArticles = new ArrayList<>();

  public static List<NewsArticle> getNewsArticles() {
    return sNewsArticles;
  }

  public static void setNewsArticles(List<NewsArticle> newsArticles) {
    sNewsArticles = newsArticles;
  }
}
