// @author Tyler Montgomery

package com.assessment;

import java.util.List;
import java.util.Map;

interface Subtract
{ 
    int diff(int x, int y); 
} 

class CalculateDateTime
{
	private int day1, day2, month1, month2, year1, year2;
	Map<String, Integer> months;
	List<String> index;
	
	public CalculateDateTime(Map<String, Integer> months, List<String> index)
	{
		this.months = months;
		this.index = index;
	}
	
	public void setDates(String[] date1, String[] date2)
	{
		day1 = Integer.parseInt(date1[2]);
		day2 = Integer.parseInt(date2[2]);
		month1 = Integer.parseInt(date1[1]) - 1;
		month2 = Integer.parseInt(date2[1]) - 1;
		year1 = Integer.parseInt(date1[0]);
		year2 = Integer.parseInt(date2[0]);
	}
	
    private int calculate()
    {
        int day = 0, month = 0, year = 0, leap = 0;
        int tempYear = year1;

        // Lambda Function Definition
        Subtract out = (int x, int y) -> Math.abs(y - x);

        day = out.diff(day1, day2);
        year = out.diff(year1, year2);
        
        for (int i = 0; i < (month2) - (month1); i++) 
        {
            month += months.get(index.get(month1 + i));
        }
        
        for (int j = 0; j < year2 - year1; j++)
        {
        	if (tempYear % 4 == 0 && tempYear % 100 == 0 && tempYear % 400 == 0)
        	{
        		leap += 1;
        	} 
        	else if(tempYear % 4 == 0 && tempYear % 100 != 0) 
        	{
        		leap += 1;
        	}	
        	tempYear += 1;
        }
        
        // Final calculation, user input order irrelevant
        return month + day + year * 365 + leap;
    }
    
    public int getTotal()
    {
    	return calculate();
    }
}