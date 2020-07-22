package com.automationpractice.tests;

import com.automationpractice.bases.TestBase;
import com.automationpractice.flows.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTests extends TestBase {
    //Objects
    MenuFlows menuFlows;
   ContactUsFlows contactUsFlows;


    //Tests
    @Test
    public void SendMessageSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        contactUsFlows = new ContactUsFlows();

        String email = "auto_teste@a.com";
        String message = "message contact us";
        String subjectHeading = "Customer service";
        String orderReference = "123456789";
        String expectedMessage = "Your message has been successfully sent to our team.";

        //Act
        menuFlows.ClickContactUs();
        contactUsFlows.SendAMessage(email, message, subjectHeading, orderReference);

        //Assert
        String text = contactUsFlows.GetTextAlertSucess();
        Assert.assertEquals(expectedMessage, text);
    }

    //Tests
    @Test
    public void SendMessageInvalidEmailAddressError() {
        //Arrange
        menuFlows = new MenuFlows();
        contactUsFlows = new ContactUsFlows();

        String email = "invalid";
        String message = "message contact us";
        String subjectHeading = "Customer service";
        String orderReference = "123456789";
        String expectedMessage = "Invalid email address.";

        //Act
        menuFlows.ClickContactUs();
        contactUsFlows.SendAMessage(email, message, subjectHeading, orderReference);

        //Assert
        String text = contactUsFlows.GetTextAlertError();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void SendMessageWithoutContentError() {


    }
}
