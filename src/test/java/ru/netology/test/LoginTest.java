package ru.netology.test;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.LoginPage;
import static com.codeborne.selenide.Selenide.*;


class LoginTest {
    @AfterAll
    static void cleanBase() {
        SQLHelper.cleanBase();
    }

    @Test
    @DisplayName("Should log in to account")
    void shouldLogin() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
    @Test
    @DisplayName("Should get an error message if user is not exist")
    void shouldGetError() {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.generateRandomUser();
        loginPage.validLoginForError(authInfo);
        loginPage.verifyErrorVisibility();
    }

}
