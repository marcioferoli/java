package com.marcioferoli.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void test() {
        System.out.println("- test");
        String str1="This is the testcase in this class";
        Assert.assertEquals("This is the testcase in this class", str1);
    }

    @Test
    public void fail() {
        System.out.println("- fail");
        // Assert.fail("Not yet implemented");
    }

}