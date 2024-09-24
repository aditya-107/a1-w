package androidsamples.java.whatday;

import android.util.Log;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * Represents the date to be set, whether it is a valid date, and the text with error status or the day of the week.
 */
public class DateModel {

  /**
   * Initializes the {@link DateModel} with the given year, month, and date.
   * If the date is not valid, it sets the appropriate error text.
   * If it is valid, it sets the appropriate day of the week text.
   *
   * @param yearStr  a {@code String} representing the year, e.g., "1947"
   * @param monthStr a {@code String} representing the month, e.g., "8"
   * @param dateStr  a {@code String} representing the date, e.g., "15"
   */
  public static Date date;
  public static String text ;

  public static void initialize(String yearStr, String monthStr, String dateStr) {
    // TODO implement the method to match the description
      if( yearStr.isEmpty()){
        text = "Enter year";
        return;
      }
      else if( monthStr.isEmpty()){
        text = "Enter month";
        return;
      }
      else if( dateStr.isEmpty()){
        text = "Enter date";
        return;
      }
      int year=0,month=-2,dateInt=-3;
      try{
        year = Integer.parseInt(yearStr);
        month = Integer.parseInt(monthStr);
        dateInt = Integer.parseInt(dateStr);
      }
      catch(NumberFormatException e){
        text="Enter values in a proper numeric format";
        return ;
      }


      if(year<1){
        text = "Invalid year";
        return;
      }
      if (month < 1 || month > 12) {
        text = "Invalid month";
        return;
      }
    if(dateInt<1 || dateInt>31){
      text = "Invalid date";
      return;
    }
//
      // Validate the day based on month and leap year
      boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
      int[] daysInMonth = { 31, isLeapYear? 29:28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      if (dateInt < 1 || dateInt > daysInMonth[month-1]) {
        if( month == 2 && dateInt ==29 && !isLeapYear)
          text = "February of "+yearStr+" does not have 29 days";
        else if( dateInt < 1)
          text = "Data must be greater 0";
        else if( dateInt > daysInMonth[month-1])
          text ="This month does not have "+dateStr+ " days";
        else
          text = "Invalid date";
        return;
      }
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
      try {
          date = sdf.parse(yearStr + "-" + monthStr + "-" + dateStr);

      } catch (ParseException e) {
      }
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

      // Convert dayOfWeek to a string representation
      String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
      Calendar.getInstance();
      text = weekDays[dayOfWeek-1];
  }

  /**
   * Retrieves the text from the {@link DateModel}.
   * It can be an error text like "February of 2019 does not have 29 days"
   * or a success text like "Friday".
   *
   * @return the text from the model
   */
  @NonNull
  public static String getMessage() {
    // TODO implement the method to match the description
    return text;
  }
}
