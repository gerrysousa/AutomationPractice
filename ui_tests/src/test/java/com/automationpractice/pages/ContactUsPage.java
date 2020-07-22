package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class ContactUsPage extends PageBase {
    //Mapping
    By txtEmail = By.id("email");
    By txtMessage = By.id("message");
    By alertMessageSuccess = By.xpath("//p[@class='alert alert-success']");
    By alertMessageError = By.xpath("//div[@class='alert alert-danger']//li");
    By btnSend = By.id("submitMessage");
    By cbxSubjectHeading = By.xpath("//div[@class='selector']");

    //Actions
    public void SelectSubjectHeading(String subjectHeading) {
        Click(cbxSubjectHeading);
        Click(ConvertTextToBy(subjectHeading));
    }

    public void FillInEmail(String email) {
        SendKeys(txtEmail,email);
    }

    public void FillInMessage(String message) {
        SendKeys(txtMessage,message);
    }

    public void ClickBtnSend() {
        Click(btnSend);
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
