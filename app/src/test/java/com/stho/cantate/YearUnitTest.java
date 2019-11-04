package com.stho.cantate;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class YearUnitTest {
    @Test
    public void year_2019_isCorrect() {
        Year year = Year.fromYear(null, null, 2019);

        assertEquals("Year 2019", 2019, year.year);
        assertEquals("New Year 2019 is Tuesday", Calendar.TUESDAY, year.newYear.get(Calendar.DAY_OF_WEEK));
        assertEquals("Epiphanie 2019 is EvangelicSunday", Calendar.SUNDAY, year.epiphany.get(Calendar.DAY_OF_WEEK));
        assertEquals("Easter 2019 is April 21st", "Sun. 2019-04-21", Formatter.toString(year.easter));
        assertEquals("Pentecost 2019 is June 9th", "Sun. 2019-06-09", Formatter.toString(year.pentecost));
        assertEquals("Trinitatis 2019 is June 16th", "Sun. 2019-06-16", Formatter.toString(year.trinity));
        assertEquals("Christmas 2019 is Wednesday", Calendar.WEDNESDAY, year.christmas.get(Calendar.DAY_OF_WEEK));
        assertEquals("Advent 2019 starts December 1st", "Sun. 2019-12-01", Formatter.toString(year.advent));
    }

    @Test
    public void liturgicalYear_isCorrect() {
        @CatholicLiturgicalYearAnnotation.Year String y = Algorithms.getLiturgicalYear(2019, 200,  Algorithms.getDate(2019, 12, 1));
        Assert.assertEquals(CatholicLiturgicalYearAnnotation.C, y);
     }
}

