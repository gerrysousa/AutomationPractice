package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class AuthenticationPage  extends PageBase {
    //Mapping
    By txtEmail = By.id("email");
    By txtPassword = By.id("passwd");
    By btnSignIn = By.id("SubmitLogin");



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
}
