package com.roger;

import org.junit.Test;

/**
 * Author: Roger Hill
 * Date: 16/02/2016
 *
 * Test for ConsoleApplication
 */
public class ConsoleAppTest {

    @Test
    public void test() {

        org.junit.Assume.assumeFalse(isWindowsSysem());

        org.junit.Assert.fail("Got to the test condition");
    }

    @Test
    public void test2() {

        org.junit.Assume.assumeTrue(isWindowsSysem());

        org.junit.Assert.assertTrue("Got to the test condition", true);
    }

    private boolean isWindowsSysem() {

        final String PROPERTY_NAME__OS_NAME = "os.name";
        final String OS_NAME__WINDOWS = "WINDOWS";

        final String osName = System.getProperty(PROPERTY_NAME__OS_NAME);

        return osName != null && osName.toUpperCase().contains(OS_NAME__WINDOWS);
    }
}
