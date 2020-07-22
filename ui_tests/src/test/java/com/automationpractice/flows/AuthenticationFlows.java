package com.automationpractice.flows;

import com.automationpractice.pages.*;


public class AuthenticationFlows {
    //Objects
    AuthenticationPage authenticationPage = new AuthenticationPage();

    //Flows

    public void DoLogin(String email, String password) {
        authenticationPage.FillInEmail(email);
        authenticationPage.FillInPassword(password);
        authenticationPage.ClickBtnSignIn();
    }


}
