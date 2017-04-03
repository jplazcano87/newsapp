package news.spaceghost.com.newsapp;

import java.util.ArrayList;
import java.util.List;

import news.spaceghost.com.newsapp.model.Article;

/**
 * Created by spaceghost on 3/26/17.
 */

public class NewsStore {
  private static List<Article> sNewsArticles = new ArrayList<>();

  public static List<Article> getNewsArticles() {
    return sNewsArticles;
  }

  public static void setNewsArticles(List<Article> newsArticles) {
    sNewsArticles = newsArticles;
  }
}
