package news.spaceghost.com.newsapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import news.spaceghost.com.newsapp.model.NewsArticle;

/**
 * Created by spaceghost on 3/26/17.
 */

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {

  private List<NewsArticle> mNewsArticles;

  public HomeNewsAdapter(List<NewsArticle> newsArticles) {
    mNewsArticles = newsArticles;
  }

  @Override
  public HomeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
    return new HomeNewsViewHolder(view);

  }

  @Override
  public void onBindViewHolder(HomeNewsViewHolder holder, int position) {
    NewsArticle newsArticle = mNewsArticles.get(position);
    Glide.with(holder.mCardViewImageView.getContext()).load(newsArticle.getImageUrl())
        .centerCrop()
        .into(holder.mCardViewImageView);
    holder.mNewsTitleTextView.setText(newsArticle.getTitle());
    holder.mNewsTimeTextView.setText(newsArticle.getTime());
    holder.mNewsDescriptionTextView.setText(newsArticle.getDetails());
    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
      //  NewsDetailsActivity.launch(v.getContext(), position);
      }
    });

  }

  @Override
  public int getItemCount() {
    //TODO perform a null check before return the size
    return mNewsArticles.size();
  }

  public static class HomeNewsViewHolder extends RecyclerView.ViewHolder{

    ImageView mCardViewImageView;
    TextView mNewsTitleTextView;
    TextView mNewsTimeTextView;
    TextView mNewsDescriptionTextView;

    public HomeNewsViewHolder(View itemView) {
      super(itemView);
      mCardViewImageView = (ImageView) itemView.findViewById(R.id.card_news_image);
      mNewsTitleTextView = (TextView) itemView.findViewById(R.id.card_news_title);
      mNewsTimeTextView = (TextView) itemView.findViewById(R.id.card_news_time);
      mNewsDescriptionTextView = (TextView) itemView.findViewById(R.id.card_news_content);

    }
  }
}
