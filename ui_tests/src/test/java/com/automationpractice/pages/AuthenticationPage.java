package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class AuthenticationPage  extends PageBase {
    //Mapping
    By txtEmail = By.id("email");
    By txtPassword = By.id("passwd");
    By btnSignIn = By.id("SubmitLogin");
    By txtNewEmail = By.id("email_create");
    By btnCreateAnAccount = By.id("SubmitCreate");
    By alertMessageCreateAccount = By.id("create_account_error");
    By alertMessageSignIn = By.xpath("//div[@class='alert alert-danger']//li");
    By linkForgotYourPassword= By.xpath("//a[@title='Recover your forgotten password']");

    //Actions
    public void FillInEmail(String email) {
        SendKeys(txtEmail,email);
    }

    public void FillInPassword(String password) {
        SendKeys(txtPassword, password);
    }

    public void ClickBtnSignIn() {
        Click(btnSignIn);
    }

    public void FillInNewEmail(String email) {
        SendKeys(txtNewEmail, email);
    }

    public void ClickBtnCreateAnAccount() {
        Click(btnCreateAnAccount);
    }

    public String GetTextAlertCreateAccount() {
        String text = GetText(alertMessageCreateAccount);
        return  text;
    }

    public String GetTextAlertSignIn() {
        String text = GetText(alertMessageSignIn);
        return  text;
    }

    public void ClickLinkForgotYourPassword() {
        Click(linkForgotYourPassword);
    }
}
