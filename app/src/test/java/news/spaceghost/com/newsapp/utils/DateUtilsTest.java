package news.spaceghost.com.newsapp.utils;

import com.google.firebase.crash.FirebaseCrash;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

/**
 * Created by juanpablolazcano on 03-04-17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({FirebaseCrash.class})
public class DateUtilsTest {

  private String correctInputDate1 = "2016-07-25T09:56:27Z";
  private String correctOutputDate1 = "Mon, 25 Jul 2016 09:56";
  private String incorrectInputDate1 = "2016-07-25T09";

  @Test
  public void formatNewsApiDate_correctDate_outputsCorrectDate() {
    String outputDate = DateUtils.formatNewsApiDate(correctInputDate1);

    assertEquals(outputDate, correctOutputDate1);
  }

  @Test
  public void formatNewsApiDate_nullInput_outputsNull() {
    String outputDate = DateUtils.formatNewsApiDate(null);
    assertEquals(outputDate, null);
  }

  @Test
  public void formatNewsApiDate_incorrectInputDate_returnSame() {
    PowerMockito.mockStatic(FirebaseCrash.class);
    String outputDate = DateUtils.formatNewsApiDate(incorrectInputDate1);
    assertEquals(outputDate, incorrectInputDate1);
    PowerMockito.verifyStatic();
    FirebaseCrash.report(Matchers.isA(ParseException.class));
  }


}
