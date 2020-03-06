// @author Tyler Montgomery

package com.assessment;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

class InitMonths
{
    static void initMonths(Map<String, Integer> months)
    {
        // key<String> = month, value<Integer> = number of days
        months.put("January", 31); 
        months.put("February", 28); 
        months.put("March", 31); 
        months.put("April", 30);
        months.put("May", 31); 
        months.put("June", 30); 
        months.put("July", 31); 
        months.put("August", 31);
        months.put("September", 30); 
        months.put("October", 31); 
        months.put("November", 30); 
        months.put("December", 31);
    }

    static List<String> indexMonthKeys(Map<String, Integer> months)
    {
        // keySet() to grab collection's keys, stream() to collect keys into list
        return months.keySet().stream().collect(Collectors.toList());
    }
}