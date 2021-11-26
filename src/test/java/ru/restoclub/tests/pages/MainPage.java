package ru.restoclub.tests.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final String FORM_TITLE = "Поиск лучших ресторанов Москвы";
    private SelenideElement loginButton = $(".user-account__login").$(By.linkText("Вход / Регистрация")),
                            formTitle = $(".page-main-header");
    public void openPage(){
        open("https://www.restoclub.ru/msk");
        formTitle.shouldHave(text(FORM_TITLE));
    }
    public void clickLogin(){
        loginButton.click();
    }
}
