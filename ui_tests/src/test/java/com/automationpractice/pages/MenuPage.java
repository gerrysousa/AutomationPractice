package com.automationpractice.pages;

import com.automationpractice.bases.PageBase;
import org.openqa.selenium.By;

public class MenuPage extends PageBase {
    //Mapping
    By linkContactUs = By.id("contact-link");
    By linkSignout = By.xpath("//a[@class='logout']");
    By linkSignin = By.xpath("//a[@class='login']");
    By linkAccount = By.xpath("//a[@class='account']/span");


    //Actions
    public void ClickLinkSignIn() {
        Click(linkSignin);
    }

    public void ClickLinkSignout() {
        Click(linkSignout);
    }

    public void ClickLinkContactUs() {
        Click(linkContactUs);
    }

    public String GetTextUserAccount() {
        String text = GetText(linkAccount);
        return  text;
    }
}