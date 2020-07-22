package com.automationpractice.flows;

import com.automationpractice.pages.*;

public class ContactUsFlows {

    //Objects
    ContactUsPage contactUsPage = new ContactUsPage();

    //Flows
    public void SendAMessage(String email, String message, String subjectHeading, String orderReference) {
        contactUsPage.SelectSubjectHeading(subjectHeading);
        contactUsPage.FillInEmail(email);
        //contactUsPage.FillInorderReference(orderReference);
        contactUsPage.FillInMessage(message);
        contactUsPage.ClickBtnSend();
    }

    public String GetTextAlertSucess() {
        return contactUsPage.GetTextAlertSucess();
    }

    public String GetTextAlertError() {
        return contactUsPage.GetTextAlertError();
    }
}
