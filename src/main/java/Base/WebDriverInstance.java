package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverInstance {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            try {
                driver.set(createDriver());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return driver.get();
    }

    public static WebDriver createDriver() throws IOException {
        WebDriver driver = null;

        Properties prop = new Properties();
        FileInputStream data = new FileInputStream(
                Paths.get(System.getProperty("user.dir"), "src", "main", "java", "resources", "config.properties").toFile()
        );
        prop.load(data);

        String browser = prop.getProperty("browser").toLowerCase();

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    Paths.get(System.getProperty("user.dir"), "src", "main", "java", "drivers", "chromedriver").toString());
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    Paths.get(System.getProperty("user.dir"), "src", "main", "java", "drivers", "geckodriver").toString());
            driver = new FirefoxDriver();
        }

        assert driver != null;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }

    public static void cleanupDriver() throws InterruptedException {
        Thread.sleep(1000);
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
