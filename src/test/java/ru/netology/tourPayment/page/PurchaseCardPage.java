package ru.netology.tourPayment.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.tourPayment.data.DataHelper;

import java.time.Duration;

public class PurchaseCardPage extends PaymentsPage {
    @FindBy(xpath = "//h2[text()='Путешествие дня']")
    SelenideElement mainPageHeading;

//    public void verifyPurchaseCardPageVisibility() {
//
//        mainPageHeading.shouldBe(Condition.visible);
//    }

    public void payOnApprovedCard(DataHelper.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }
    public void payOnDeclinedCard(DataHelper.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }


public void shouldFailedMsgIfCardIsBad(String msg){
    cardNumberField.setValue("4444 4444 4444 4444");
    monthField.setValue("11");
    yearField.setValue("22");
    ownerField.setValue("Ivan");
    cvvField.setValue("222");
    continueButton.click();
}

    public void payOnFailedCard(DataHelper.CardInfo info) {
        cardNumberField.setValue(info.getCardNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }
    public void shouldSuccessMsg(String msg) {
        notificationSuccess.shouldBe(Condition.text(msg), Duration.ofSeconds(10));
        notificationFailed.shouldBe(Condition.not(Condition.visible));
    }
    public void shouldFailedMsg(String msg) {
        notificationFailed.shouldBe(Condition.text(msg), Duration.ofSeconds(10));
        notificationSuccess.shouldBe(Condition.not(Condition.visible));
    }
    public void sendCardInfo(DataHelper.CardInfo info){

    }
}
