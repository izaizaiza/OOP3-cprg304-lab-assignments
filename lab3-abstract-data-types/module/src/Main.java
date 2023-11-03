import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        if (args.length != 1){
            System.out.println("Use:  Main <day name> \n where day name is something like monday, tuesday, ...");
            return;
        }

        String dayName = args[0];
        int year = 2010;

        for (int month = 1; month <=12; month++){
            for (int day=1; day <=31; day++){
                // dont include invalid dates
                // make a helper method to check if date is valid
                if (!isValidDate(year, month, day)){
                    continue;
                }

                DateADT date = new Date(year, month, day);
                LocalDate localDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDay());
                String localDateDayOfWeek = String.valueOf(localDate.getDayOfWeek());
                if(localDateDayOfWeek.equalsIgnoreCase(dayName)){
                    System.out.println(date.toString());
                }
            }
        }
    }

    // helper method to check if date is a valid date
    private static boolean isValidDate(int year, int month, int day){
        // check if year is valid
        if(year != 2010){
            return false;
        }

        //check if month is valid
        if (month < 1 || month > 12){
            return false;
        }

        //check if day is valid
        int maxDay;
        // months april, june, sept and nov have 30 days
        if (month == 4 || month == 6 || month == 9 || month == 11){
            maxDay=30;
        }
        else if(month == 2){
            maxDay=28;
        }
        else{
            maxDay = 31; // this is the most num of days in a month
        }

        if (day < 0 || day > maxDay){
            return false;
        }


        return true;
    }
}