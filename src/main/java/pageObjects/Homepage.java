package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Base.BasePage;

public class Homepage extends BasePage {

    public WebDriver driver;
    public By depositCalculation = By.id("ctl00_IsbankDVPlaceHolderBody_IsbankDVPlaceHolderFooter_IsbankMainFooter_RepeaterHelperPages_ctl10_helperPageAnchor");
    public By loanButton = By.id("ctl00_ctl18_g_9e073400_eb81_4bd4_8ec9_8840c8aa5705_ctl00_repeaterQuickTransactions_ctl03_anchorQuick");
    public By loanCalculationButton = By.xpath("//a[text()='Hesapla']");


    public Homepage() throws IOException {
        super();
    }

    public WebElement getDepositCalculation() throws IOException {
        this.driver = getDriver();
        return driver.findElement(depositCalculation);
    }

    public WebElement getLoanButton() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loanButton);
    }

    public WebElement getLoanCalculationButton() throws IOException {
        this.driver = getDriver();
        return driver.findElement(loanCalculationButton);
    }

}
