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

        //Act

        //Assert

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

        //Act

        //Assert

    }

    @Test
    public void SignInWithoutEmailAddresError() {
        //Arrange

        //Act

        //Assert

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
