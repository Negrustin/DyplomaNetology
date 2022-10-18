package ru.netology.tourPayment.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentOnCardPage extends PaymentsPage {
    private PaymentOnCardPage() {
        $x("//h3[text()='Оплата по карте']").shouldBe(Condition.visible);
    }

    @FindBy(xpath = "//h3[text()='Оплата по карте']")
    SelenideElement paymentOnCardPageHeading;

    public void verifyPaymentOnCardPageVisibility(){

        paymentOnCardPageHeading.shouldBe(Condition.visible);
    }


}
