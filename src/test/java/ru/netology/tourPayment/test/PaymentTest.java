package ru.netology.tourPayment.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.tourPayment.data.DataHelper;
import ru.netology.tourPayment.data.SQLHelper;
import ru.netology.tourPayment.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentTest {

    //    @BeforeEach
//    public void openPage() {
//        String url = System.getProperty("sut.url");
//        open(url);
//    }
//    @Test
//    @DisplayName("A pop-up window is displayed to confirm successful payment")
//    void paymentOnApprovedCard() {
//        var mainPage = open("http://localhost:8080", MainPage.class);
//        var purchaseCardPage = mainPage.payOnCard();
//        purchaseCardPage.verifyPurchaseCardPageVisibility();
//
//        purchaseCardPage.payOnApprovedCard(DataHelper.getApprovedCardInfo());
//
//        purchaseCardPage.shouldSuccessMsg("Операция одобрена Банком.");
//
//        var statusCode = SQLHelper.getStatusCode().getStatus();
//
//        String expected = "APPROVED";
//        String actual = statusCode;
//
//        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    @DisplayName("A pop-up window is displayed with a refusal to pay.")
//    void paymentOnDeclinedCard() {
//        var mainPage = open("http://localhost:8080", MainPage.class);
//        var purchaseCardPage = mainPage.payOnCard();
//
//        purchaseCardPage.payOnDeclinedCard(DataHelper.getDeclinedCardInfo());
//
//        purchaseCardPage.shouldFailedMsg("Банк отказал в проведении операции");
//
////        var statusCode = SQLHelper.getStatusCode().getStatus();
////
////        String expected = "DECLINED";
////        String actual = statusCode;
////
////        Assertions.assertEquals(expected,actual);
//    }
//
//    @Test
//    @DisplayName("Payment refusal messages when a non-existent card is used")
//    void paymentsOnFailedCard() {
//        var mainPage = open("http://localhost:8080", MainPage.class);
//        var purchaseCardPage = mainPage.payOnCard();
//        purchaseCardPage.payOnFailedCard(DataHelper.getFiledCardInfo());
//
//        purchaseCardPage.shouldFailedMsg("Банк отказал в проведении операции");
//    }
//
//    @Test
//    @DisplayName("A pop-up window is displayed to confirm successful payment on credit")
//    void paymentOnCreditByApprovedCard(){
//        var mainPage = open("http://localhost:8080", MainPage.class);
//        var purchaseCreditPage = mainPage.PayOnCredit();
//        purchaseCreditPage.verifyPurchaseCreditPageVisibility();
//
//        purchaseCreditPage.paymentOnCredit(DataHelper.getFiledCardInfo());
//
//    }

    }

