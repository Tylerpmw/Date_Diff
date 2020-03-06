package com.assessment;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(true);
    }
    
    @Test
    public void testAssertNotNull() 
    {
        Map<String, Integer> months = new LinkedHashMap<String, Integer>();
        InitMonths.initMonths(months);

        // assert statements
        assertNotNull("Should NOT be null", months);
    }
}
