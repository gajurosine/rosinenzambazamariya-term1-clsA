import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathApplicationE2ETest {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Set up WebDriver (assuming you have ChromeDriver installed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testDoMathOperation_E2E() {
        // Given
        driver.get("http://localhost:" + port + "/");  // Assuming your application is running at the root context

        // Find input fields and submit button
        WebElement operand1Input = driver.findElement(By.id("operand1"));
        WebElement operand2Input = driver.findElement(By.id("operand2"));
        WebElement operationInput = driver.findElement(By.id("operation"));
        WebElement calculateButton = driver.findElement(By.id("calculateButton"));

        // When
        operand1Input.sendKeys("2");
        operand2Input.sendKeys("5");
        operationInput.sendKeys("+");
        calculateButton.click();

        // Then
        WebElement resultElement = driver.findElement(By.id("result"));
        String resultText = resultElement.getText();
        assertEquals("7.0", resultText);
    }
}