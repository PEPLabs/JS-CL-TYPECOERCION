import java.io.File;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        File file = new File("TypeCoercion.html");
        driver.get("file:///" + file.getAbsolutePath());
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void testPageElements() {
        List<WebElement> resultElements = driver.findElements(By.xpath("//p[@id]"));
        // Verify the number of elements with id attributes
        assertEquals(12, resultElements.size());
    }

    @Test
    public void testDoubleEqualsOperator_a1() {
        WebElement a1 = driver.findElement(By.id("a1"));
        assertEquals("false", a1.getText());
    }

    @Test
    public void testDoubleEqualsOperator_a2() {
        WebElement a2 = driver.findElement(By.id("a2"));
        assertEquals("true", a2.getText());
    }

    @Test
    public void testDoubleEqualsOperator_a3() {
        WebElement a3 = driver.findElement(By.id("a3"));
        assertEquals("true", a3.getText());
    }

    @Test
    public void testDoubleEqualsOperator_a4() {
        WebElement a4 = driver.findElement(By.id("a4"));
        assertEquals("true", a4.getText());
    }

    @Test
    public void testTripleEqualsOperator_a5() {
        WebElement a5 = driver.findElement(By.id("a5"));
        assertEquals("false", a5.getText());
    }

    @Test
    public void testTripleEqualsOperator_a6() {
        WebElement a6 = driver.findElement(By.id("a6"));
        assertEquals("true", a6.getText());
    }

    @Test
    public void testTripleEqualsOperator_a7() {
        WebElement a7 = driver.findElement(By.id("a7"));
        assertEquals("false", a7.getText());
    }

    @Test
    public void testTripleEqualsOperator_a8() {
        WebElement a8 = driver.findElement(By.id("a8"));
        assertEquals("true", a8.getText());
    }

    @Test
    public void testExplicitTypeCoercion_a9() {
        WebElement a9 = driver.findElement(By.id("a9"));
        assertEquals("56", a9.getText());  // "5" + 6 = "56"
    }

    @Test
    public void testExplicitTypeCoercion_a10() {
        WebElement a10 = driver.findElement(By.id("a10"));
        assertEquals("11", a10.getText());  // Number("5") + 6 = 11
    }

    @Test
    public void testExplicitTypeCoercion_a11() {
        WebElement a11 = driver.findElement(By.id("a11"));
        assertEquals("7", a11.getText());  // Boolean(5) + 6 = 7
    }

    @Test
    public void testExplicitTypeCoercion_a12() {
        WebElement a12 = driver.findElement(By.id("a12"));
        assertEquals("6", a12.getText());  // Boolean(null) + 6 = 6
    }

}