package ru.netology.tourPayment.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.tourPayment.data.DataHelper;
import ru.netology.tourPayment.data.SQLHelper;
import ru.netology.tourPayment.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentsOnCardTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    @DisplayName("Покупка разрешенной картой, отображается сообщение об одобрении банком")
    void shouldSuccessMessageIfPaymentOfCard() {
        var mainPage = open("http://104.0.5112.79:57972", MainPage.class);
        var paymentOnCardPage = mainPage.paymentOnCard();

        paymentOnCardPage.payOnCard(DataHelper.getApprovedCardInfo());


        paymentOnCardPage.shouldSuccessMessage("Операция одобрена Банком.");
    }

    @Test
    @DisplayName("Покупка разрешенной картой, статус в базе данных: 'APPROVED'.")
    void shouldStatusCodeIfTransactionIsSuccessful(){
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCardPage = mainPage.paymentOnCard();

        paymentOnCardPage.payOnCard(DataHelper.getApprovedCardInfo());
        paymentOnCardPage.shouldNotificationMessage();

        var statusCode = SQLHelper.getStatusCode().getStatus();


        String expectedCode = "APPROVED";
        String actualCode = statusCode;

        Assertions.assertEquals(expectedCode,actualCode);
    }


    @Test
    @DisplayName("A message should appear telling you that the operation has been rejected.")
    void shouldRejectionMessageIfPaymentOfCard() {
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCardPage = mainPage.paymentOnCard();

        paymentOnCardPage.payOnCard(DataHelper.getDeclinedCardInfo());

        paymentOnCardPage.shouldErrorMessage("Банк отказал в проведении операции");
    }
    @Test
    @DisplayName("The status in the database should be 'DECLINED'")
    void shouldStatusCodeIfTransactionIsUnsuccessful(){
        var mainPage = open("http://localhost:8080", MainPage.class);
        var paymentOnCardPage = mainPage.paymentOnCard();

        paymentOnCardPage.payOnCard(DataHelper.getDeclinedCardInfo());
        paymentOnCardPage.shouldNotificationMessage();


        var statusCode = SQLHelper.getStatusCode().getStatus();

        String expectedCode = "DECLINED";
        String actualCode = statusCode;

        Assertions.assertEquals(expectedCode,actualCode);

    }


}
