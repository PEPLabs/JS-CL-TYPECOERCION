import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        File file = new File("TypeCoersion.html");
        // Open the HTML file
        driver.get(file.getAbsolutePath());
    }

    @Test
    public void testPageElements() {
        List<WebElement> resultElements = driver.findElements(By.xpath("//p[@id]"));
        // Verify the number of elements with id attributes
        assertEquals(12, resultElements.size());
    }



    @After
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}