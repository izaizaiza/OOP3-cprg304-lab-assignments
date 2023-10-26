/**
 * DateADT represents a date in the calendar that has year, month, and day
 * it has methods that are used to manipulate those data
 * */
public interface DateADT {


    //abstract methods

    /**
     * create  a date object
     * @param y year
     * @param m month
     * @param d day
     * */
   DateADT createDate(int y, int m, int d);

    /**
     * get the year of a dateADT
     * @return an int that is the year
     */
    int getYear();

    /**
     * get the month of that date
     * @return int month
     * */
    int getMonth();

    /**
     * get the day of the date
     * @return int day
     **/
    int getDay();

    /**
     * turn the date object to a string object
     * @return string date
     */
    String toString();

    /**
     * compare this date to another
     * @param anotherDate to compare
     * @return negative num if current date is before anotherDate,
     *         positive if current date is after anotherDate,
     *         zero if current date is the same as anotherDate
     */
    int compare(DateADT anotherDate);


    /**
     *  get the difference in days of this date to another
     * @param anotherDate to compare the days with
     * @return the number (int) of days difference: currentDate days - anotherDate days
     */
    int getDiffDays(DateADT anotherDate);

    /**
     *  get the difference in month of this date to another
     * @param anotherDate to compare the month with
     * @return the number (int) of months difference: currentDate month - anotherDate month
     */
    int getDiffMonths(DateADT anotherDate);


    /**
     *  get the difference in years of this date to another
     * @param anotherDate to compare the years with
     * @return the number (int) of years difference: currentDate years - anotherDate years
     */
    int getDiffYears(DateADT anotherDate);

    /**
     * format the date into: yyyy-mm-dd
     * @return a string: "yyyy-mm-dd"
     * @param date object
     */
    String formatDate1(DateADT date);

    /**
     * adjust days to a date and get new date (either in the past or future)
     * @param date chosen date
     * @param numDays is number of days; can be positive or negative int
     * @return the new date
     */
    DateADT adjustDays(DateADT date, int numDays);


}
