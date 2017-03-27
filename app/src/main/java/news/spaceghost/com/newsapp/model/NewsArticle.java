package news.spaceghost.com.newsapp.model;

/**
 * Created by spaceghost on 3/26/17.
 */

public class NewsArticle {

  private String mTitle;
  private String mDetails;
  private String mImageUrl;
  private String mTime;
  private String mUrlToArticle;


  public NewsArticle(String title, String details, String imageUrl, String time, String urlToArticle) {
    mTitle = title;
    mDetails = details;
    mImageUrl = imageUrl;
    mTime = time;
    mUrlToArticle = urlToArticle;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public String getDetails() {
    return mDetails;
  }

  public void setDetails(String details) {
    mDetails = details;
  }

  public String getImageUrl() {
    return mImageUrl;
  }

  public void setImageUrl(String imageUrl) {
    mImageUrl = imageUrl;
  }

  public String getTime() {
    return mTime;
  }

  public void setTime(String time) {
    mTime = time;
  }

  public String getUrlToArticle() {
    return mUrlToArticle;
  }

  public void setUrlToArticle(String urlToArticle) {
    mUrlToArticle = urlToArticle;
  }
}
