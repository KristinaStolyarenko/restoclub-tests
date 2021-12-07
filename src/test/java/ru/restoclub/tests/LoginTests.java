package ru.restoclub.tests;

import ru.restoclub.config.AppConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import ru.restoclub.tests.pages.AuthorizationPage;
import ru.restoclub.tests.pages.MainPage;
import ru.restoclub.tests.pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

public class LoginTests extends TestData {

    MainPage mainPage = new MainPage();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    RegistrationPage registrationPage = new RegistrationPage();
    AppConfig credentials = ConfigFactory.create(AppConfig.class);

    @Test
    void PositiveRegistration (){
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            mainPage.clickLogin();
        });
        step("Открываем окно регистрации", () -> {
            authorizationPage.openRegistrationForm();
        });
        step("Вводим имя пользователя", () -> {
            registrationPage.setNickname(nickName);
        });
        step("Выбераем пол пользователя", () -> {
            registrationPage.chooseGenderMale();
        });
        step("Вводим email", () -> {
            registrationPage.setEmail(email);
        });
        step("Вводим пароль", () -> {
            registrationPage.setPassword(password);
        });
        step("Подтверждаем регистрацию", () -> {
            registrationPage.сonfirmRegistration();
        });
        step("Регистрация прошла успешно", () -> {
            registrationPage.checkConfirm();
        });
        step("Завершаем регистрацию", () -> {
            registrationPage.submitRegistration();
        });
    }

    @Test
    void  NegativeRegistration (){
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            mainPage.clickLogin();
        });
        step("Открываем окно регистрации", () -> {
            authorizationPage.openRegistrationForm();
        });
        step("Вводим имя пользователя", () -> {
            registrationPage.setNickname(nickName);
        });
        step("Выбераем пол пользователя", () -> {
            registrationPage.chooseGenderMale();
        });
        step("Подтверждаем регистрацию", () -> {
            registrationPage.сonfirmRegistration();
        });
        step("Регистрация не прошла", () -> {
            registrationPage.checkSubmitRegistrationButton();
        });
    }

    @Test
    void PositiveAuthorization (){
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            mainPage.clickLogin();
        });
        step("Вводим почту", () -> {
            authorizationPage.setEmail(credentials.userLogin());
        });
        step("Вводим пароль", () -> {
            authorizationPage.setPassword(credentials.userPassword());
        });
        step("Подтверждаем вход", () -> {
            authorizationPage.submit();
        });
    }

    @Test
    void AuthorizationWithWrongPassword (){
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            mainPage.clickLogin();
        });
        step("Вводим почту", () -> {
            authorizationPage.setEmail(email);
        });
        step("Вводим пароль", () -> {
            authorizationPage.setPassword("password1234");
        });
        step("Подтверждаем вход", () -> {
            authorizationPage.submit();
        });
        step("Ошибка входа", () -> {
            authorizationPage.checkEnterForm();
        });
    }

    @Test
    void AuthorizationWithWrongEmail (){
        step("Открываем главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открываем окно авторизации", () -> {
            mainPage.clickLogin();
        });
        step("Вводим почту", () -> {
            authorizationPage.setEmail(email);
        });
        step("Вводим пароль", () -> {
            authorizationPage.setEmail("awww@mail.ru");
        });
        step("Подтверждаем вход", () -> {
            authorizationPage.submit();
        });
        step("Ошибка входа", () -> {
            authorizationPage.checkEnterForm();
        });
    }

}
