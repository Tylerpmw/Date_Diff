// @author Tyler Montgomery

package com.assessment;

import java.lang.Math;
import java.util.List;
import java.util.Map;

interface Subtract
{ 
    int diff(String x, String y); 
} 

class CalculateDateTime
{
    static int calculate(String[] date1, String[] date2, Map<String, Integer> months, List<String> index)
    {
        int day = 0, month = 0, year = 0, leap = 0, total = 0;

        // Lambda Function Definition
        Subtract out = (String x, String y) -> Integer.parseInt(y) - Integer.parseInt(x);

        day = out.diff(date1[1], date2[1]);
        for (int i = 0; i < (Integer.parseInt(date2[0]) - 1) - (Integer.parseInt(date1[0]) - 1); i++) 
        {
            month += months.get(index.get(Integer.parseInt(date1[0]) - 1 + i));
        }
        year = out.diff(date1[2], date2[2]);
        leap = year / 4;

        // Final calculation, user input order irrelevant
        total = Math.abs(month + day + year * 365 + leap);
        return total;
    }
}