package com.capgemini.page.objects;

import com.capgemini.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T> {

    protected Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public abstract T load();

}
