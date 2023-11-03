
import java.util.Comparator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Date implements DateADT{
    private int year;
    private int month;
    private int day;


    public Date(int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }
    @Override
    public int getYear(){
        return year;
    }

    @Override
    public int getMonth(){
        return month;
    }


    @Override
    public int getDay(){
        return day;
    };

    /**
     * turn the date object to a string object
     * @return string date
     */

    @Override
    public String toString(){
        return String.format("%04d-%02d-%02d", year, month, day);
    };

    /**
     * compare this date to another
     * @param anotherDate to compare
     * @return negative num if current date is before anotherDate,
     *         positive if current date is after anotherDate,
     *         zero if current date is the same as anotherDate
     */
    @Override
    public int compare(DateADT anotherDate){
        // Implement the comparison logic with another DateADT object.
        // Return a negative value if this date is before the other Date,
        // 0 if they are equal, and a positive value if this date is after the other Date.
        // let's compare year first, then month and then day
        Comparator<DateADT> dateComparator = new Comparator<DateADT>() {
            @Override
            public int compare(DateADT date1, DateADT date2) {
                if(date1.getYear() != date2.getYear()){
                    return Integer.compare(date1.getYear(), date2.getYear());
                }
                else if(date1.getMonth() != date2.getMonth()){
                    return Integer.compare(date1.getMonth(), date2.getMonth());
                }
                else{
                    return Integer.compare(date1.getDay(), date2.getDay());
                }
            }
        };

        return dateComparator.compare(this, anotherDate);
    };


    /**
     *  get the difference in days of this date to another
     * @param anotherDate to compare the days with
     * @return the number (int) of days difference: currentDate days - anotherDate days
     */
    @Override
    public int getDiffDays(DateADT anotherDate){
        // is there a method in java that get the days in between two dates?
        // there is src: https://www.baeldung.com/java-date-difference#:~:text=If%20we%20want%20to%20calculate%20the%20difference%20in%20days%20using,is%20the%20most%20straightforward%20way.

        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), this.getDay());
        LocalDate date2 = LocalDate.of(anotherDate.getYear(), anotherDate.getMonth(), anotherDate.getDay());

        return (int) ChronoUnit.DAYS.between(date1,date2);
    };

    /**
     *  get the difference in month of this date to another
     * @param anotherDate to compare the month with
     * @return the number (int) of months difference: currentDate month - anotherDate month
     */
    @Override
    public int getDiffMonths(DateADT anotherDate){
        // the same logic as getDiffDays
        // wait, if only month, then keep the days the same?
        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), 1);
        LocalDate date2 = LocalDate.of(anotherDate.getYear(), anotherDate.getMonth(), 1);

        return (int) ChronoUnit.MONTHS.between(date1, date2);

    };


    /**
     *  get the difference in years of this date to another
     * @param anotherDate to compare the years with
     * @return the number (int) of years difference: currentDate years - anotherDate years
     */
    @Override
    public int getDiffYears(DateADT anotherDate){
        // same as getDiffMonths and getDiffDays
        LocalDate date1 = LocalDate.of(this.getYear(), 1, 1);
        LocalDate date2 = LocalDate.of(anotherDate.getYear(), 1, 1);

        return (int) ChronoUnit.YEARS.between(date1, date2);
    };

    /**
     * format the date into: yyyy/mm/dd
     * @return a string: "yyyy/mm/dd"
     */
    @Override
    public String formatDate1(){

        return String.format("%04d/%02d/%02d", year, month, day);
    };

    /**
     * adjust days to a date and get new date (either in the past or future)
     * @param numDays is number of days; can be positive or negative int
     * @return the new date
     */
    @Override
    public DateADT adjustDays(int numDays){

        // adjust the days based on the given numDays
        // is there a method in LocalDate that adjusts the date?
        // there is plusDays and minusDays, src: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html

        LocalDate date = LocalDate.of(this.getYear(), this.getMonth(), this.getDay());
        DateADT adjustedDate;
        if (numDays < 0){
            date = date.minusDays(numDays); // note that this date is LocalDate now not DateADT
            adjustedDate = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());

        }
        else{
            date = date.plusDays(numDays); // note that this date is LocalDate now not DateADT
            adjustedDate = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        }
        return adjustedDate;
    };


}
