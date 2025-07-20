package pageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.BasePage;

public class DepositCalculationPage extends BasePage {
    public DepositCalculationPage() throws IOException {
        super();
    }

    public WebDriver driver;
    public By amountInput = By.id("ctl00_ctl18_g_080ca8ad_1797_4c29_91d3_b1d909f46720_ctl00_DepositCalcAmount");
    public By interestRateInput = By.id("ctl00_ctl18_g_080ca8ad_1797_4c29_91d3_b1d909f46720_ctl00_DepositCalcInterest");
    public By dayInput = By.id("ctl00_ctl18_g_080ca8ad_1797_4c29_91d3_b1d909f46720_ctl00_DepositCalcTerm");
    public By calculateButton = By.id("ctl00_ctl18_g_080ca8ad_1797_4c29_91d3_b1d909f46720_ctl00_btncalculateHide");
    public By amountCalculated =(By.xpath("//table/tbody/tr[3]/td[@class='align_right' and contains(text(),'TL')]\n"));

    public WebElement getAmountInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(amountInput);
    }

    public WebElement getInterestRateInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(interestRateInput);
    }

    public WebElement getCalculateButton() throws IOException {
        this.driver = getDriver();
        return driver.findElement(calculateButton);
    }

    public WebElement getAmountCalculated() throws IOException {
        this.driver = getDriver();
        return driver.findElement(amountCalculated);
    }

    public WebElement getDayInput() throws IOException {
        this.driver = getDriver();
        return driver.findElement(dayInput);
    }
}
