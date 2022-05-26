package sandipchitale.selenoid;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelenoidTest {

    @Test
    public void execute() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--headless");
        chromeOptions.setCapability("enableVNC", true);
        // Selenoid HUB started with cm selenoid start;cm selenoid-ui start
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.get("https://todomvc.com/examples/angular2/");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.new-todo")));
        element.sendKeys("Get Milk");
        element.sendKeys(Keys.ENTER);

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".view input+label")));
        assertThat(element.getText(), is("Get Milk"));

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("getmilk.png"));
        } catch (IOException e) {
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
        }
        driver.quit();
    }
}
