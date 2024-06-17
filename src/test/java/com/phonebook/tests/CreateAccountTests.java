/*
 * created by max$
 */


package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {
    @Test(enabled = false)
    public void createAccountPositiveTests() {
        
        app.getUser().clickOnLoginLink();
       
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("maxtest@gmail.com")
                .setPassword("Maxtest123!"));
        app.getUser().clickOnRegistrationButton();
        
        Assert.assertTrue(app.getUser().isSighOutButtonPresent());
    }

    @Test
    public void createExistedAccountNegativeTests() {
        SoftAssert softAssert = new SoftAssert();
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("maxtest@gmail.com")
                .setPassword("Maxtest123!"));
        app.getUser().clickOnRegistrationButton();
        // asser Alert is present
        //Assert.assertTrue(isAlertPresent());
        softAssert.assertTrue(app.getUser().isAlertPresent());

        //assert error messageis present
        // Assert.assertTrue(isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
        softAssert.assertTrue(app.getUser().isError409Present());
        softAssert.assertAll();
    }

}
