package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Math.*;


public class DinAlgorithm {

    public double[] sunPosition() {

        Calendar cal = new GregorianCalendar(2018,7,7,12,0);
        System.out.println("Zeit: " + cal.getTime());

        double latitude = 50.56 * PI / 180;
        double longitude = 6.59 * PI / 180;

        //int daysOfTheYear = daysOfYear(cal);
        int daysOfTheYear = 365;

        int timeZone = cal.getTimeZone().getDSTSavings() / 3600000;
        double localTime = (double)cal.get(cal.HOUR) + 12 + (double)(cal.get(cal.MINUTE))/60;

        System.out.println("Timezone: " + timeZone);
        System.out.println("Days of year: " + daysOfTheYear);
        System.out.println("Stunde: " + (cal.get(cal.HOUR)+12));
        System.out.println("Minute: " + cal.get(cal.MINUTE));
        System.out.println("Day of year: " + cal.get(cal.DAY_OF_YEAR));
        System.out.println("Localtime: " + localTime);

        double dayAngle = 2 * PI * ((double)cal.get(cal.DAY_OF_YEAR) / (double)daysOfTheYear);
        double solarDeclination = (0.3948 - 23.2559 * cos(dayAngle + 0.1588) - 0.3915 * cos(2 * dayAngle + 0.0942) - 0.1764 * cos(3 * dayAngle + 1.8361)) * PI / 180;
        double eqt = (0.0066 + 7.3525 * cos(dayAngle + 1.4992) + 9.9359 * cos(2 * dayAngle + 1.9007) + 0.3387 * cos(3 * dayAngle + 1.8361)); // [min]
        double mlt = (localTime - timeZone) + 4 * (longitude * 180 / PI) / 60; // * min/°
        double solarTime = mlt + eqt / 60;
        double hourAngle = ((12 - solarTime) * 15) * PI / 180; // [°/h]
        double sunHeight = asin(cos(hourAngle) * cos(latitude) * cos(solarDeclination) + sin(latitude) * sin(solarDeclination));

        double sunAzimuth;

        if(solarTime <= 720)
            sunAzimuth = PI - acos((sin(sunHeight) * sin(latitude) - sin(solarDeclination))/(cos(sunHeight) * cos(latitude)));
        else
            sunAzimuth = PI + acos((sin(sunHeight) * sin(latitude) - sin(solarDeclination))/(cos(sunHeight) * cos(latitude)));

        sunHeight = sunHeight * 180 / PI;
        sunAzimuth = sunAzimuth * 180 / PI;

        double[] sunPosition = new double[2];
        sunPosition[0] = sunHeight;
        sunPosition[1] = sunAzimuth;

        return sunPosition;
    }


    /**
     * Calculates weather the given Date is a leap year
     * @param calendar
     * @return
     */
    private int daysOfYear(Calendar calendar){
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);

        int daysOfTheYear = calendar.get(calendar.DAY_OF_YEAR);

        return daysOfTheYear;
    }
}