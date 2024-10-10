package otus.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import otus.exceptions.CourseDoesNotExistException;
import otus.exceptions.NotRightPageException;

import java.util.List;

@Component
public class CourseCatalogPage extends BasePage {

    @Value("${path.to.all.courses}")
    public String pathToCourses;

    @Autowired
    public CourseCatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section[.//div[text()='Каталог']]//descendant::a")
    List<WebElement> coursesCatalog;

    @FindBy(xpath = "descendant::button[contains(text(), 'Показать')]")
    private WebElement showMoreCoursesButton;


    @Override
    public CourseCatalogPage open() {
        driver.get(super.baseUrl + pathToCourses);
        return this;
    }

    public CourseCatalogPage verifyPage() {
        String currentUrl = driver.getCurrentUrl();
        String targetUrl = baseUrl + pathToCourses;
        if (!(targetUrl).equals(currentUrl)) {
            throw new NotRightPageException(currentUrl);
        }
        return this;
    }

    public void showAllCoursesInCatalog() {
        try {
            while (showMoreCoursesButton.isDisplayed()) {
                showMoreCoursesButton.click();
            }
        } catch (Exception e) {
        }
    }

    public WebElement findCourseByName(String courseName) throws CourseDoesNotExistException {
        return coursesCatalog.stream()
                .filter(element -> element.getText().contains(courseName))
                .findFirst()
                .orElseThrow(() -> new CourseDoesNotExistException(courseName));
    }

}
