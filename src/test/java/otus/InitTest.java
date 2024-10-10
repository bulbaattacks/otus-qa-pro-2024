package otus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import otus.exceptions.CourseDoesNotExistException;
import otus.pages.CourseCatalogPage;

import java.time.Duration;

@SpringBootTest
class InitTest {

    private final String COURSE_NAME = "Java QA Engineer. Professional";
    private final String LINK_TO_COURSE = "https://otus.ru/lessons/java-qa-pro";

    @Autowired
    private WebDriver driver;
    @Autowired
    private CourseCatalogPage page;

    @BeforeEach
    void setUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterEach
//    public void close() {
//        if (this.driver != null) {
//            this.driver.close();
//            this.driver.quit();
//        }
//    }

    @Test
    void findCourseByName() throws CourseDoesNotExistException {
        page.open().verifyPage();
        page.showAllCoursesInCatalog();
        var targetCourse = page.findCourseByName(COURSE_NAME);
        var targetCourseName = targetCourse.getText();
        Assertions.assertTrue(targetCourseName.contains(COURSE_NAME), "Course page %s is not found".formatted(COURSE_NAME));
    }
}
