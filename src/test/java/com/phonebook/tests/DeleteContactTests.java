/*
 * created by max$
 */


package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        //click on Login link
        app.getUser().clickOnLoginLink();
        //enter email
        app.getUser().fillRegisterLoginForm(new User()
                .setEmail("maxtest@gmail.com")
                .setPassword("Maxtest123!"));
        //click on Login button
        app.getUser().clickOnLoginButton();

        //click on Add link
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Bil")
                .setLastName("Scholz")
                .setPhone("1234567890")
                .setEmail("oliver@gmail.com")
                .setAddress("London")
                .setDescription("keeper"));
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void deleteContactPositiveTest(){
        //get size of contacts before delete
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on Card
        app.getContact().removeContact();
        app.getContact().pause(500);
        //get size of contacts after delete
        int sizeAfter = app.getContact().sizeOfContacts();
        //compare size before and size after with assert
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }

}
