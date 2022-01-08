package ru.restoclub.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    private SelenideElement emailInput = $("#username"),
                            passwordInput = $("#password"),
                            submitButton = $(byText("Войти")),
                            registrationButton = $("#registerLink"),
                            enterForm = $(byText("Войти на сайт"));

    public void setEmail(String value){
        emailInput.setValue(value);
    }
    public void setPassword(String value){
        passwordInput.setValue(value);
    }
    public void submit(){
        submitButton.click();
    }
    public void openRegistrationForm(){
        registrationButton.click();
    }
    public void checkEnterForm(){ enterForm.shouldBe(Condition.visible); }
}
