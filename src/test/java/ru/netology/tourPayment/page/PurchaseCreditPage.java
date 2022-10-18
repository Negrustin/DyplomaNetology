package ru.netology.tourPayment.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.netology.tourPayment.data.DataHelper;

public class PurchaseCreditPage extends PaymentsPage {
    @FindBy(xpath = "//h3[text()='Кредит по данным карты']")
    SelenideElement heading;

    public void verifyPurchaseCreditPageVisibility() {

        heading.shouldBe(Condition.visible);
    }

    private PurchaseCreditPage() {
    }

public void paymentOnCredit(DataHelper.CardInfo info){
    cardNumberField.setValue(info.getCardNumber());
    monthField.setValue(info.getMonth());
    yearField.setValue(info.getYear());
    ownerField.setValue(info.getOwner());
    cvvField.setValue(info.getCvv());
    continueButton.click();
}

}
