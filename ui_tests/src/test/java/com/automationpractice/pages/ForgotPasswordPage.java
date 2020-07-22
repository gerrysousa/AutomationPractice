package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends PageBase {
    //Mapping
    By txtEmail = By.id("email");
    By btnRetrivePassword = By.xpath("//button[@class='btn btn-default button button-medium']");
    By alertMessage = By.xpath("//p[@class='alert alert-success']");

    //Actions
    public void FillInEmail(String email) {
        SendKeys(txtEmail,email);
    }

    public void ClickBtnRetrivePassword() {
        Click(btnRetrivePassword);
    }

    public String GetTextAlert() {
        String text = GetText(alertMessage);
        return text;
    }
}
