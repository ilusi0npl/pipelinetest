package com.capgemini.page.objects;

import com.capgemini.manager.DriverManager;
import com.capgemini.utils.ScreenshotMaker;
import com.capgemini.waits.WaitUntil;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.capgemini.utils.Constants.ENV_URL;
import static com.capgemini.utils.ScreenshotMaker.makeScreenShot;
import static org.testng.AssertJUnit.assertEquals;

public class LoginPage extends BasePage<LoginPage> {

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "passwd")
    private WebElement passwordTextField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;

    @FindBy(xpath = "//*[@id='center_column']/div[1]")
    private WebElement warningMessageLabel;

    @Override
    public LoginPage load() {
        DriverManager.getDriver().get(ENV_URL + "?controller=authentication");
        return this;
    }

    @Step("Typed into email field {email}")
    public LoginPage typeIntoEmailTextField(String email) {
        WaitUntil.elementIsVisible(emailTextField);
        emailTextField.clear();
        emailTextField.sendKeys(email);
        logger.info("Typed into email field {}", email);
        return this;
    }

    @Step("Typed into password field {password}")
    public LoginPage typeIntoPasswordTextField(String password) {
        WaitUntil.elementIsVisible(passwordTextField);
        passwordTextField.clear();
        passwordTextField.sendKeys(password);
        logger.info("Typed into password field {}", password);
        return this;
    }

    public LoginPage makeLoginPageScreenShot() {
        makeScreenShot(LoginPage.class.getSimpleName());
        return this;
    }

    @Step("Click on login button")
    public LoginPage clickOnLoginButton() {
        submitButton.click();
        logger.info("Clicked on login button");
        return this;
    }

    @Step("Asserted that warning message was displayed")
    public LoginPage assertThatWarningMessageWasDisplayed(String warning) {
        WaitUntil.elementIsVisible(warningMessageLabel);
        assertEquals(warningMessageLabel.getText(), warning);
        logger.info("Asserted that warning message {} was displayed", warning);
        return this;
    }

}
