/*
 * created by max$
 */


package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
@Test
    public void loginPositiveTest(){
    //click on Login link
    app.getUser().clickOnLoginLink();
    //enter email
    app.getUser().fillRegisterLoginForm(new User()
            .setEmail("maxtest@gmail.com")
            .setPassword("Maxtest123!"));
    //click on Login button
    app.getUser().clickOnLoginButton();
    //assert Sign out button is present
    //driver.findElement(By.xpath("//button[.='Sign Out']"));
    Assert.assertTrue(app.getUser().isSighOutButtonPresent());
}

@Test
    public void loginNegativeWithoutEmailTest(){

    app.getUser().clickOnLoginLink();
    app.getUser().fillRegisterLoginForm(new User()
            .setPassword("Maxtest123!"));
    app.getUser().clickOnLoginButton();

    Assert.assertTrue(app.getUser().isAlertPresent());
}

}
