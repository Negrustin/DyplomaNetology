package ru.netology.tourPayment.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.tourPayment.data.DataHelper;
import ru.netology.tourPayment.data.SQLHelper;
import ru.netology.tourPayment.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentOnCreditTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    @DisplayName("Покупка в кредит разрешенной картой, отображается сообщение об одобрении операции банком")
    void shouldSuccessMessageIfPaymentOnCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCreditPage = mainPage.PaymentOnCredit();

        paymentOnCreditPage.payOnCard(DataHelper.getApprovedCardInfo());


        paymentOnCreditPage.shouldSuccessMessage("Операция одобрена Банком.");
    }

    @Test
    @DisplayName("Покупка в кредит разрешенной картой, статус операции в БД 'APPROVED'")
    void shouldStatusCodeIfPaymentOnCredit() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCreditPage = mainPage.PaymentOnCredit();

        paymentOnCreditPage.payOnCard(DataHelper.getApprovedCardInfo());

        paymentOnCreditPage.shouldSuccessMessage("Операция одобрена Банком.");
        var statusCode = SQLHelper.getCreditStatusCode().getStatus();

        String expected = "APPROVED";
        String actual = statusCode;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Покупка в кредит запрещённой  картой, отображается сообщение об отказе в операции банком")
    void shouldRejectionMessageIfPaymentOfCredit(){
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCreditPage = mainPage.PaymentOnCredit();

        paymentOnCreditPage.payOnCard(DataHelper.getDeclinedCardInfo());

        paymentOnCreditPage.shouldErrorMessage("Банк отказал в проведении операции");

    }



}
