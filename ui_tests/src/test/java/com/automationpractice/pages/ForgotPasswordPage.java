package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends PageBase {
    //Mapping
    By txtEmail = By.id("email");
    By btnRetrivePassword = By.xpath("//button[@class='btn btn-default button button-medium']");
    By alertMessageSuccess = By.xpath("//p[@class='alert alert-success']");
    By alertMessageError = By.xpath("//div[@class='alert alert-danger']//li");

    //Actions
    public void FillInEmail(String email) {
        SendKeys(txtEmail,email);
    }

    public void ClickBtnRetrivePassword() {
        Click(btnRetrivePassword);
    }

    public String GetTextAlertSucess() {
        String text = GetText(alertMessageSuccess);
        return text;
    }

    public String GetTextAlertError() {
        String text = GetText(alertMessageError);
        return text;
    }
}
