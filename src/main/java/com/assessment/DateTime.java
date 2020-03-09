// @author Tyler Montgomery

package com.assessment;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
  
class DateTime
{
	private String[] userInput;
	private String[] date1, date2;
	private int intDate1, intDate2;
	private Map<String, Integer> months;
	private List<String> index;
	
	public DateTime() 
	{
        userInput = new String[2];
        
        // LinkedHashMap for order, List for index
        months = new LinkedHashMap<String, Integer>();
        InitMonths.initMonths(months);
        index = InitMonths.indexMonthKeys(months);
	}
	
    private int verifyDate(int pos) 
    {
    	intDate1 = Integer.parseInt(date1[pos]);
    	intDate2 = Integer.parseInt(date2[pos]);
    	
    	if (intDate1 == intDate2)
    	{
    		if (pos == 2)
    		{
    			return 0;
    		}
    		return verifyDate(pos += 1);
    	} 
    	else if(intDate1 < intDate2) 
    	{
    		return 1;
    	}
    	else 
    	{
    		return -1;
    	}
    }
    
    public Map<String, Integer> getMonths() 
    {
    	return months;
    }
    
    public int getVerifyDate()
    {
    	return verifyDate(0);
    }
    
    public void setUserInput(String input1, String input2)
    {
    	userInput[0] = input1;
    	userInput[1] = input2;
    }
    
    public String toString(int total)
    {
    	return "There are " + total + " days between " + 
    			index.get(Integer.parseInt(date1[1]) - 1) + " " + date1[2] + ", " + date1[0] + " and " + 
    			index.get(Integer.parseInt(date2[1]) - 1) + " " + date2[2] + ", " + date2[0] + ".";
    }
    
    private Integer main() 
    {
        try
        {
        	int total = 0;
        	CalculateDateTime cdt = new CalculateDateTime(months, index);
        	
            // Tokenize user inputs
            date1 = userInput[0].split("-");
            date2 = userInput[1].split("-");
            
            switch(verifyDate(0)) 
            {
            case 0: // date1 and date2 are the same
            	break;
            case 1: // date1 comes before date2
            	cdt.setDates(date1, date2);
            	total = cdt.getTotal();
            	break;
            case -1: // date1 comes after date2
            	cdt.setDates(date2, date1);
            	total = cdt.getTotal();
            	break;
            }
            return total;
        }
        catch(Exception e)
        {
        	System.out.println(e);
            return -1;
        }
    }
    
    public int run()
    {
    	return main().intValue();
    }
}