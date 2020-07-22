package com.automationpractice.flows;

import com.automationpractice.pages.*;

public class ForgotPasswordFlows {
    ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();

    public void RetrievePassword(String email) {
        forgotPasswordPage.FillInEmail(email);
        forgotPasswordPage.ClickBtnRetrivePassword();
    }

    public String GetTextAlert() {
        return forgotPasswordPage.GetTextAlert();
    }

    //Flows
}
