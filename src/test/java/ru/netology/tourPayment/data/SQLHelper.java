package ru.netology.tourPayment.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private SQLHelper() {
    }

    private static QueryRunner runner = new QueryRunner();
    static String dbUrl = System.getProperty("db.url");
    static String dbUser = System.getProperty("db.user");
    static String dbPassword = System.getProperty("db.password");

    public static DataHelper.PaymentStatus getStatusCode() {
        var codeSQl = "SELECT status FROM payment_entity WHERE created = (SELECT MAX(created) FROM payment_entity);";
        try (var conn = getConn()) {
            var result = runner.query(conn, codeSQl, new ScalarHandler<String>());
            return new DataHelper.PaymentStatus(result);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    public static DataHelper.PaymentStatus getCreditStatusCode(){
        var codeSQl = "SELECT status FROM credit_request_entity WHERE created = (SELECT MAX(created) FROM credit_request_entity);";
        try (var conn = getConn()) {
            var result = runner.query(conn, codeSQl, new ScalarHandler<String>());
            return new DataHelper.PaymentStatus(result);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }




    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConn();
        runner.execute(connection, "DELETE FROM credit_request_entity;");
        runner.execute(connection, "DELETE FROM order_entity;");
        runner.execute(connection, "DELETE FROM payment_entity;");
    }


}
