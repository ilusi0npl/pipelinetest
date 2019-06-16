package com.capgemini.tests.login;

import com.capgemini.page.objects.LoginPage;
import com.capgemini.tests.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void asUserTryToLoginWithIncorrectCredentialsTest() {
        String badData = "awdawd";
        new LoginPage()
                .load()
                .typeIntoEmailTextField(badData)
                .typeIntoPasswordTextField(badData)
                .clickOnLoginButton()
                .assertThatWarningMessageWasDisplayed(
                        "There is 1 error\n" +
                                "Invalid email address.")
                .makeLoginPageScreenShot();
    }


}
