/*
 * created by max$
 */


package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest() {
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
        //driver.findElements(By.cssSelector("div:nth-child(2)>div>div>h1"));////div[2]/div/div/h1
        //System.out.println("Home Component is " + isHomeComponentPresent());
    }
}

