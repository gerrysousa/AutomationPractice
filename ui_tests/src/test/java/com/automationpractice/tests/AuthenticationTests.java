package com.automationpractice.tests;

import com.automationpractice.bases.TestBase;
import com.automationpractice.flows.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.automationpractice.utils.Utils.GetNowDateJustNumbers;

public class AuthenticationTests extends TestBase {
    //Objects
    MenuFlows menuFlows;
    AuthenticationFlows authenticationFlows;
    ForgotPasswordFlows forgotPasswordFlows;

    //Tests
    @Test
    public void SignInSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "123456789";
        String expectedMessage = "ClientName LastName";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = menuFlows.GetTextUserAccount();
        Assert.assertEquals(expectedMessage, text);
    }

    @Test
    public void LogoutSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "123456789";
        String expectLoginOk = "ClientName LastName";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);
        String loginOK = menuFlows.GetTextUserAccount();

        menuFlows.DoLogout();

        //Assert
        boolean linkExists = menuFlows.ReturnExistsLinkSignIn();
        Assert.assertEquals(expectLoginOk, loginOK);
        Assert.assertTrue(linkExists);
    }

    //To do
    @Test
    public void CreateAnAcountSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = GetNowDateJustNumbers() + "@email.com"; //create an email format 202007220811@email.com
        String expectedMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.FillEmailToCreateAnAccount(email);
        //To do

        //Assert
        //To do
    }

    @Test
    public void CreateAnAcountEmailAlreadyBeenRegistered() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String expectedMessage = "An account using this email address has already been registered. Please enter a valid password or request a new one.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.FillEmailToCreateAnAccount(email);

        //Assert
        String text = authenticationFlows.GetTextAlertCreateAccount();
        Assert.assertEquals(expectedMessage, text);
    }

    @Test
    public void SignInWithoutEmailAddresError() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "";
        String password = "123456789";
        String expectedMessage = "An email address required.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = authenticationFlows.GetTextAlertSignIn();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void SignInWithoutPasswordError() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "";
        String expectedMessage = "Password is required.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = authenticationFlows.GetTextAlertSignIn();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void SignInInvalidPasswordError() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "1";
        String expectedMessage = "Invalid password.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = authenticationFlows.GetTextAlertSignIn();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void SignInAuthenticationFailedError() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "111111111111";
        String expectedMessage = "Authentication failed.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = authenticationFlows.GetTextAlertSignIn();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void RetrievePasswordSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();
        forgotPasswordFlows = new ForgotPasswordFlows();
        String email = "auto_teste@a.com";
        String expectedMessage = "A confirmation email has been sent to your address: auto_teste@a.com";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.ClickLinkForgotYourPassword();
        forgotPasswordFlows.RetrievePassword(email);

        //Assert
        String text = forgotPasswordFlows.GetTextAlertSucess();
        Assert.assertEquals(expectedMessage, text);

    }

    @Test
    public void ForgotPasswordInvalidEmailError() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();
        forgotPasswordFlows = new ForgotPasswordFlows();
        String email = "invalid";
        String expectedMessage = "Invalid email address.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.ClickLinkForgotYourPassword();
        forgotPasswordFlows.RetrievePassword(email);

        //Assert
        String text = forgotPasswordFlows.GetTextAlertError();
        Assert.assertEquals(expectedMessage, text);

    }
}
