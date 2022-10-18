package ru.netology.tourPayment.page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.tourPayment.data.DataHelper;

import java.time.Duration;

public class PaymentsPage {
    @FindBy(xpath = "//*[text()='Номер карты']/..//input")
    SelenideElement cardNumberField;
    @FindBy(xpath = "//*[text()='Месяц']/..//input")
    SelenideElement monthField;
    @FindBy(xpath = "//*[text()='Год']/..//input")
    SelenideElement yearField;
    @FindBy(xpath = "//*[text()='Владелец']/..//input")
    SelenideElement ownerField;
    @FindBy(xpath = "//*[text()='CVC/CVV']/..//input")
    SelenideElement cvvField;
    @FindBy(xpath = "//*[text()='Продолжить']")
    SelenideElement continueButton;

    @FindBy(css = ".notification")
    SelenideElement notification;
    @FindBy(css = ".notification_status_ok")
    SelenideElement notificationSuccess;
    @FindBy(css = ".notification_status_error")
    SelenideElement notificationFailed;


    public void payOnCard(DataHelper.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }

    public void shouldSuccessMessage(String msg) {
        notificationSuccess.shouldBe(Condition.text(msg), Duration.ofSeconds(10));
        notificationFailed.shouldBe(Condition.not(Condition.visible));
    }

    public void shouldErrorMessage(String msg){
        notificationFailed.shouldBe(Condition.text(msg), Duration.ofSeconds(10));
        notificationSuccess.shouldBe(Condition.not(Condition.visible));
    }
    public void shouldNotificationMessage(){
        notification.shouldBe((Condition.visible), Duration.ofSeconds(10));
    }
}
