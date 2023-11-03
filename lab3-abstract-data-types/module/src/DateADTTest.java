import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class DateADTTest {


    private DateADT date;
    private DateADT anotherDate;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Initialize a DateADT object before each test
        date = new Date(2023, 11, 2);
        anotherDate = new Date(2022,10,1);
        }


    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }


    @org.junit.jupiter.api.Test
    void getYear() {
        int year = date.getYear();
        assertEquals(2023, year);
    }

    @org.junit.jupiter.api.Test
    void getMonth() {
        int month = date.getMonth();
        assertEquals(11, month);
    }

    @org.junit.jupiter.api.Test
    void getDay() {
        int day = date.getDay();
        assertEquals(2, day);
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String dateString = date.toString();
        assertEquals("2023-11-02", dateString);
    }

    @org.junit.jupiter.api.Test
    void compare() {
        int result = date.compare(anotherDate);
        assertEquals(1,result);
    }

    @org.junit.jupiter.api.Test
    void getDiffDays() {
        int daysDiff = date.getDiffDays(anotherDate);
        assertEquals(-397,daysDiff);
    }

    @org.junit.jupiter.api.Test
    void getDiffMonths() {
        int monDiff = date.getDiffMonths(anotherDate);
        assertEquals(-13,monDiff);
    }

    @org.junit.jupiter.api.Test
    void getDiffYears() {
        int yearDiff = date.getDiffYears(anotherDate);
        assertEquals(-1,yearDiff);
    }

    @org.junit.jupiter.api.Test
    void formatDate1() {
        String formattedDate = date.formatDate1();
        assertEquals("2023/11/02", formattedDate);
    }

    @org.junit.jupiter.api.Test
    void adjustDays() {
        DateADT adjustedDate = date.adjustDays(1);
        // assert the properties of adjusted date
        assertEquals(2023, adjustedDate.getYear());
        assertEquals(11, adjustedDate.getMonth());
        assertEquals(3, adjustedDate.getDay());

    }
}