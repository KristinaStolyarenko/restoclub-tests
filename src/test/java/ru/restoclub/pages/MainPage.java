package ru.restoclub.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private final String FORM_TITLE = "Поиск лучших ресторанов Москвы";
    private SelenideElement loginButton = $(".user-account__login").$(By.linkText("Вход / Регистрация")),
            formTitle = $(".page-main-header"),
            termsOfUseButton = $(".about__links").$(By.linkText("Пользовательское соглашение")),
            projectAboutButton = $(".about__links").$(By.linkText("О проекте")),
            contactsButton = $(".about__links").$(By.linkText("Контакты Restoclub"));

    public void openPage() {
        open("https://www.restoclub.ru/msk");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickTermsOfUseButton() {
        termsOfUseButton.click();
    }

    public void clickProjectAboutButton() {
        projectAboutButton.click();
    }

    public void clickContactsButton() {
        contactsButton.click();
    }
}
