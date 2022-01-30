package ru.restoclub.tests;

import ru.restoclub.config.App;
import org.junit.jupiter.api.Test;
import ru.restoclub.pages.AuthorizationPage;
import ru.restoclub.pages.MainPage;
import ru.restoclub.pages.RegistrationPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.*;

public class HighTests extends TestData {

    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void positiveRegistration() {
        step("Открываем окно регистрации", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
            authorizationPage.openRegistrationForm();
        });
        step("Вводим данные пользователя", () -> {
            registrationPage.setNickname(nickName);
            registrationPage.chooseGenderMale();
            registrationPage.setEmail(email);
            registrationPage.setPassword(password);
        });
        step("Подтверждаем регистрацию", () ->
            registrationPage.сonfirmRegistration());
        step("Регистрация прошла успешно", () ->
            registrationPage.checkConfirm());
        step("Завершаем регистрацию", () ->
            registrationPage.submitRegistration());
    }

    @Test
    void negativeRegistration() {
        step("Открываем окно регистрации", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
            authorizationPage.openRegistrationForm();
        });
        step("Вводим данные пользователя", () -> {
            registrationPage.setNickname(nickName);
            registrationPage.chooseGenderMale();
        });
        step("Подтверждаем регистрацию", () ->
            registrationPage.сonfirmRegistration());
        step("Регистрация не прошла", () ->
            registrationPage.checkSubmitRegistrationButton());
    }

    @Test
    void positiveAuthorization() {
        step("Открываем окно авторизации", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
        });
        step("Вводим данные пользователя", () -> {
            authorizationPage.setEmail(App.config.userLogin());
            authorizationPage.setPassword(App.config.userPassword());
        });
        step("Подтверждаем вход", () ->
            authorizationPage.submit());
    }

    @Test
    void authorizationWithWrongPassword() {
        step("Открываем окно авторизации", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
        });
        step("Вводим данные пользователя", () -> {
            authorizationPage.setEmail(email);
            authorizationPage.setPassword("password1234");
        });
        step("Подтверждаем вход", () ->
            authorizationPage.submit());
        step("Ошибка входа", () ->
            authorizationPage.checkEnterForm());
    }

    @Test
    void authorizationWithWrongEmail() {
        step("Открываем окно авторизации", () -> {
            mainPage.openPage();
            mainPage.clickLogin();
        });
        step("Вводим почту", () ->
            authorizationPage.setEmail("awww@mail.ru"));
        step("Подтверждаем вход", () ->
            authorizationPage.submit());
        step("Ошибка входа", () ->
            authorizationPage.checkEnterForm());
    }

    @Test
    void termsOfUseCheck() {
        step("Открываем главную страницу", () ->
            mainPage.openPage());
        step("Нажимаем на кнопку Пользовательское Соглашение", () ->
            mainPage.clickTermsOfUseButton());
        step("Проверяем открытие Пользовательского Соглашения", () ->
            webdriver().shouldHave(url("https://www.restoclub.ru/user-agreement"), Duration.ofSeconds(30)));
    }

    @Test
    void projectAboutCheck() {
        step("Открываем главную страницу", () ->
            mainPage.openPage());
        step("Нажимаем на кнопку О проекте", () ->
            mainPage.clickProjectAboutButton());
        step("Проверяем открытие страницы О проекте", () ->
            webdriver().shouldHave(url("https://www.restoclub.ru/about"), Duration.ofSeconds(30)));
    }

    @Test
    void contactsCheck() {
        step("Открываем главную страницу", () ->
            mainPage.openPage());
        step("Нажимаем на кнопку Контакты Restoclub", () ->
            mainPage.clickContactsButton());
        step("Проверяем открытие страницы Контакты Restoclub", () ->
            webdriver().shouldHave(url("https://www.restoclub.ru/contacts"), Duration.ofSeconds(30)));
    }
}
