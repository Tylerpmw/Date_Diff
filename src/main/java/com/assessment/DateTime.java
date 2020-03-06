// @author Tyler Montgomery

package com.assessment;

import java.util.Scanner;
import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
  
class DateTime
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String[] userInput = new String[2], date1, date2;
        
        // LinkedHashMap for order, List for index
        Map<String, Integer> months = new LinkedHashMap<String, Integer>();
        InitMonths.initMonths(months);
        List<String> index = InitMonths.indexMonthKeys(months);

        System.out.println("Enter two dates separately given the format: dd/mm/yyyy");

        try
        {
            for (int i = 0; i < userInput.length; i++) 
            {
                userInput[i] = input.nextLine();
            }
            input.close();

            System.out.print("Input: ");
            
            for (String x: userInput)
            {
                System.out.print(x + " ");
            }

            System.out.println();

            // Tokenize user inputs
            date1 = userInput[0].split("/");
            date2 = userInput[1].split("/");

            // Calculation of days between two dates
            int total = CalculateDateTime.calculate(date1, date2, months, index);
            
            System.out.println("There are " + total + " days between " + 
                index.get(Integer.parseInt(date1[0]) - 1) + " " + 
                date1[1] + " " + date1[2]
                + " and " + 
                index.get(Integer.parseInt(date2[0]) - 1) + " " +
                date2[1] + " " + date2[2]);
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong, please check for input errors and try again...");
        }
    }
}