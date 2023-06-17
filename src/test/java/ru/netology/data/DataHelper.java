package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
    public static String generateRandomLogin() {
        return faker.name().username();
    }
    public static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(),generateRandomPassword());
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }


}
