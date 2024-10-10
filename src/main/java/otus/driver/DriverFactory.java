package otus.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import otus.exceptions.DriverNotSupportedException;

@Configuration
public class DriverFactory {

    @Value("${browser}")
    private String browser;

    @Bean
    public WebDriver webDriver() throws DriverNotSupportedException {
        if (browser.equals("CHROME")) {
            WebDriverManager.chromedriver().setup();
            return ChromeWebDriver.createDriver();
        } else {
            throw new DriverNotSupportedException(browser);
        }
    }
}