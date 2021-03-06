package news.spaceghost.com.newsapp.utils;

import com.google.firebase.crash.FirebaseCrash;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by spaceghost on 4/2/17.
 */

public class DateUtils {

  private DateUtils(){

  }

  public static String formatNewsApiDate(String inputDate) {
    if (inputDate == null){
      return null;
    }

    try {
      String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
      String outputDateFormat = "EEE, d MMM yyyy KK:mm";

      SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat, Locale.US);
      SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFormat, Locale.US);

      Date date = inputFormat.parse(inputDate);
      return outputFormat.format(date);
    } catch (ParseException e) {
      e.printStackTrace();
      FirebaseCrash.report(e);
    }
    return inputDate;
  }
}
