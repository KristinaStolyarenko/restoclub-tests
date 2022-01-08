package ru.restoclub.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private final String VERIFICATION_TEXT = "Отлично!";
    private SelenideElement nicknameInput = $("#user_register_nickname"),
                            emailInput = $("#user_register_email"),
                            passwordInput = $("#user_register_password"),
                            registrationConfirmButton = $(byText("Зарегистрироваться")),
                            genderMale = $(byAttribute("for", "male")),
                            genderFemale = $(byAttribute("for", "female")),
                            submitRegistrationButton = $(byText("ОК")),
                            registrationForm = $("#alertAccept");

    public void checkConfirm(){
        registrationForm.shouldHave(Condition.text(VERIFICATION_TEXT));
    }
    public void setNickname(String value){
        nicknameInput.setValue(value);
    }
    public void setEmail(String value){
        emailInput.setValue(value);
    }
    public void setPassword(String value){
        passwordInput.setValue(value);
    }
    public void сonfirmRegistration(){
        registrationConfirmButton.click();
    }
    public void chooseGenderMale(){
        genderMale.click();
    }
    public void chooseGenderFemale(){
        genderFemale.click();
    }
    public void submitRegistration(){submitRegistrationButton.click();}
    public void checkSubmitRegistrationButton(){registrationConfirmButton.shouldBe(Condition.visible);}
}
