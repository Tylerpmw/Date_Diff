package com.assessment;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void testAssertNotNull() 
    {
        DateTime dt = new DateTime();
        dt.setUserInput("1990-01-01", "2020-03-09");
        assertNotNull("Should NOT be null", dt.getMonths());
    }
    
    @Test
    public void testAssertSame() {
    	DateTime dt = new DateTime();
        dt.setUserInput("2012-01-03", "2013-04-06");
        dt.run();
        assertSame("failure - ints are not equal", dt.getVerifyDate(), 1);
        assertSame("failure - ints are not equal", dt.run(), 459);
        
        dt.setUserInput("2013-04-06", "2012-01-03");
        dt.run();
        assertSame("failure - ints are not equal", dt.getVerifyDate(), -1);
        assertSame("failure - ints are not equal", dt.run(), 459);
        
        dt.setUserInput("2020-03-09", "2020-03-09");
        dt.run();
        assertSame("failure - ints are not equal", dt.getVerifyDate(), 0);
        assertSame("failure - ints are not equal", dt.run(), 0);
        
        // Testing for leap years
        dt.setUserInput("1990-03-09", "2020-03-09");
        dt.run();
        assertSame("failure - ints are not equal", dt.getVerifyDate(), 1);
        assertSame("failure - ints are not equal", dt.run(), 10957);
        
        dt.setUserInput("2020-03-09", "1883-03-09");
        dt.run();
        assertSame("failure - ints are not equal", dt.getVerifyDate(), -1);
        assertSame("failure - ints are not equal", dt.run(), 50038);
    }
}