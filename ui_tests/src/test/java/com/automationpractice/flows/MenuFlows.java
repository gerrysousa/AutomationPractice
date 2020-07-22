package com.automationpractice.flows;

import com.automationpractice.pages.MenuPage;

public class MenuFlows {
    //Objects
    MenuPage menuPage = new MenuPage();

    //Flows
    public void ClickSignIn() {
        menuPage.ClickLinkSignIn();
    }

    public String GetTextUserAccount() {
        return menuPage.GetTextUserAccount();
    }
}
