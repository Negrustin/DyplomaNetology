package ru.netology.tourPayment.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataHelper {
    private static final String APPROVED_CARD_NUMBER = "4444444444444441";
    private static final String DECLINED_CARD_NUMBER = "4444444444444442";
    private static Faker faker = new Faker(new Locale("EN"));
    private static int randomNumber = ThreadLocalRandom.current().nextInt(61);

    public static CardInfo getApprovedCardInfo() {
        return new CardInfo(
                APPROVED_CARD_NUMBER,
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomFullName(),
                generateRandomCVV());
    }

    public static CardInfo getDeclinedCardInfo() {
        return new CardInfo(
                DECLINED_CARD_NUMBER,
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomFullName(),
                generateRandomCVV());
    }


    public static CardInfo getFiledCardInfo() {
        return new CardInfo(
                generateRandomCardNumber(),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomFullName(),
                generateRandomCVV());
    }


    private static String generateRandomFullName() {

        return faker.name().firstName() + " " + faker.name().lastName();
    }

    private static String generateRandomCardNumber() {
        return faker.finance().creditCard();
    }


    public static String generateRandomCVV() {
        return faker.numerify("###");
    }


    private static String generateRandomMonth() {
        YearMonth now = YearMonth.now();
        // int randomNumber = ThreadLocalRandom.current().nextInt(61);
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
        YearMonth randomDate = now.plusMonths(randomNumber);
        String randomMonth = randomDate.format(month);
        return randomMonth;
    }

    private static String generateRandomYear() {
        YearMonth now = YearMonth.now();
        // int randomNumber = ThreadLocalRandom.current().nextInt(61);
        YearMonth randomDate = now.plusMonths(randomNumber);
        String randomYear = Integer.toString(randomDate.getYear());
        randomYear = randomYear.substring(2, 4);
        return randomYear;
    }


    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cvv;
    }

    public static PaymentStatus getPaymentStatus(String status) {

        return new PaymentStatus(status);
    }

    @Value
    public static class PaymentStatus {
        private String status;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentsEntity {
        private String id;
        private String amount;
        private String created;
        private String status;
        private String transaction_id;
    }

    @Value
    public static class StatusCode {
        private String code;
    }


}
