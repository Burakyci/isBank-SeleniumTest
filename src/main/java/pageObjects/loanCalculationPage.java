package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.BasePage;


public class loanCalculationPage extends BasePage {
    public WebDriver driver;
    public By loanAmountInput = By.id("ihtiyacTaksitTutari");
    public By termInput = By.id("ihtiyacVadeTutari");
    public By loanRateText = By.id("totalIntrestField");
    public By monthlyTermAmount = By.id("totalAmountField");





    public loanCalculationPage() throws IOException {
        super();
    }

    public WebElement getLoanAmountInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loanAmountInput);
    }
    public WebElement getTermInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(termInput);
    }
    public WebElement getLoanRateText() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loanRateText);
    }
    public WebElement getMonthlyTermAmount() throws IOException {
        this.driver = getDriver();
        return driver.findElement(monthlyTermAmount);
    }
}

