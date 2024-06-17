/*
 * created by max$
 */


package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("maxtest@gmail.com")
                .setPassword("Maxtest123!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        //click on Add link
        app.getContact().clickOnAddLink();
        //enter name
        app.getContact().fillAddContactForm(new Contact()
                .setName("Bil")
                .setLastName("Scholz")
                .setPhone("1234567890")
                .setEmail("oliver@gmail.com")
                .setAddress("London")
                .setDescription("keeper"));
        //click on Save button
        app.getContact().clickOnSaveButton();
        //assert by text
        Assert.assertTrue(app.getContact().isContactAdded("Bil"));
    }

    @AfterMethod
    public void postCondition() {
        //click on Card

        app.getContact().removeContact();
        app.getContact().pause(1000);

    }

}
