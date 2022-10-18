package ru.netology.tourPayment.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

//private SelenideElement payOnCard = $x("//*[text()='Купить']");
//private SelenideElement creditOnCard =$x("//*[text()='Купить в кредит']");
//private SelenideElement getHeading = $x("//h2");
private MainPage() {
$x("//h2[contains(class,heading)]").shouldBe(Condition.visible);
}
    @FindBy(xpath = "//h2[contains(class,heading)]")
    SelenideElement heading;

    @FindBy(xpath = "//*[text()='Купить']")
    SelenideElement payOnCardButton;
    @FindBy(xpath = "//*[text()='Купить в кредит']")
    SelenideElement payCreditCardButton;


    public  PaymentOnCardPage paymentOnCard(){
        payOnCardButton.click();
        return page(PaymentOnCardPage.class);
    }
    public PaymentOnCreditPage PaymentOnCredit(){
        payCreditCardButton.click();
        return page(PaymentOnCreditPage.class);
    }

}
