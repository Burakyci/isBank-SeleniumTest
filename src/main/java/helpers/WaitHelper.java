package helpers;
import Base.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;

public class WaitHelper {


    public WebElement waitForElementVisibility(By locater, int timeoutInSeconds) throws IOException {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(timeoutInSeconds));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
    }
}