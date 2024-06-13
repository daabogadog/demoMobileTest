package com.labs.digital.aval.demoMobile.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {

    public static final Target logInMain = Target.the(" login button main ").located(By.id("com.saucelabs.mydemoapp.android:id/mTvTitle"));
    //public static final Target logInMain = Target.the(" login button main ").locatedForAndroid(By.id("com.saucelabs.mydemoapp.android:id/mTvTitle")).locatedForIOS("ios");
    public static final Target menu = Target.the("menu").located(By.id("com.saucelabs.mydemoapp.android:id/menuIV"));
    public static final Target BUTTON_LOG_IN = Target.the("boton login ").located(By.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/itemTV' and @text='Log In']"));
    public static final Target TITLE_LOGIN = Target.the("titulo del login").located(By.id("com.saucelabs.mydemoapp.android:id/loginTV"));
    public static final Target INPUT_USER = Target.the("caja de texto user").located(By.id("com.saucelabs.mydemoapp.android:id/nameET"));
    public static final Target INPUT_KEY = Target.the("caja de texto password").located(By.id("com.saucelabs.mydemoapp.android:id/passwordET"));
    public static final Target BUTTON_LOGIN = Target.the("boton login").located(By.id("com.saucelabs.mydemoapp.android:id/loginBtn"));
    public static final Target TITLE_PRODUCTS = Target.the("titulo de productos").located(By.id("com.saucelabs.mydemoapp.android:id/productTV"));



}
