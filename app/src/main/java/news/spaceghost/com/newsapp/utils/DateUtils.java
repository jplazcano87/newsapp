package news.spaceghost.com.newsapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by spaceghost on 4/2/17.
 */

public class DateUtils {

  private DateUtils(){

  }

  public static String formatNewsApiDate(String inputDate) {
    if (inputDate == null)
      return null;
    try {
      String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
      String outputDateFormat = "EEE, d MMM yyyy KK:mm";

      SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
      SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat);

      Date date = inputFormat.parse(inputDate);
      return outputFormat.format(date);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return inputDate;
  }
}