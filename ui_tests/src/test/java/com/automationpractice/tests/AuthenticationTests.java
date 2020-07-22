package com.automationpractice.tests;

import com.automationpractice.bases.TestBase;
import com.automationpractice.flows.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTests extends TestBase {
    //Objects
    MenuFlows menuFlows;
    AuthenticationFlows authenticationFlows;

    //Tests
    @Test
    public void SignInSucess() {
        //Arrange
        menuFlows = new MenuFlows();
        authenticationFlows = new AuthenticationFlows();

        String email = "auto_teste@a.com";
        String password = "123456789";
        String expectMessage = "ClientName LastName";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = menuFlows.GetTextUserAccount();
        Assert.assertEquals(expectMessage, text);
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

    @Test
    public void CreateAnAcountSucess() {
        //Arrange

        //Act

        //Assert

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
        String expectMessage = "An email address required.";

        //Act
        menuFlows.ClickSignIn();
        authenticationFlows.DoLogin(email, password);

        //Assert
        String text = authenticationFlows.GetTextAlertSignIn();
        Assert.assertEquals(expectMessage, text);

    }

    @Test
    public void SignInWithoutPasswordError() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    public void SignInInvalidPasswordError() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    public void ForgotPasswordSucess() {
        //Arrange

        //Act

        //Assert

    }

    @Test
    public void ForgotPasswordInvalidEmailError() {
        //Arrange

        //Act

        //Assert

    }
}
