package otus.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

public abstract class BasePage {
    @Value("${base.url}")
    protected String baseUrl;
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract BasePage open();

//    protected void waitElementToBeVisible(WebElement webElement) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(webElement));
//    }
//
//    protected void waitElementToBeClickable(WebElement webElement) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(webElement));
//    }
}
