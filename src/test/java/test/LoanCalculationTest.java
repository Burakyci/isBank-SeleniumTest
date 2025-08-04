package test;

import Base.ExtentManager;
import Base.Hooks;
import helpers.ConfigReader;
import helpers.LoanCalculator;
import helpers.ScrollHelper;
import helpers.WaitHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.loanCalculationPage;

import java.io.IOException;
import java.util.ArrayList;


@Listeners(resources.Listeners.class)
public class LoanCalculationTest extends Hooks {

    public LoanCalculationTest() throws IOException {
        super(); // Hooks constructor'u IOException fırlattığı için burada da belirtmen gerek
    }

    @Test
    public void testDepositCalculation() throws IOException, InterruptedException {
        ExtentManager.log("Starting DepositCalculationTest...");
        Homepage homepage = new Homepage();
        loanCalculationPage loanCalculationPage = new loanCalculationPage();
        int loanAmount = ConfigReader.getIntProperty("loanAmount");
        int loanTerm = ConfigReader.getIntProperty("loanTerm");

        WaitHelper waitHelper = new WaitHelper();
        ScrollHelper scrollHelper = new ScrollHelper();
        LoanCalculator calculator = new LoanCalculator();

        scrollHelper.scrollOnElement(homepage.getLoanButton());
        Thread.sleep(2000);
        homepage.getLoanButton().click();
        waitHelper.waitForElementVisibility(homepage.loanCalculationButton, 4);
        homepage.getLoanCalculationButton().click();

        ArrayList<String> tabs = new ArrayList<>(Hooks.getDriver().getWindowHandles());
        Hooks.getDriver().switchTo().window(tabs.get(tabs.size() - 1));

        waitHelper.waitForElementVisibility(loanCalculationPage.loanRateText, 4);


        JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver();

        js.executeScript("arguments[0].value = '';", loanCalculationPage.getLoanAmountInput());
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
                loanCalculationPage.getLoanAmountInput(), String.valueOf(loanAmount));

        js.executeScript("arguments[0].value = '';", loanCalculationPage.getTermInput());
        js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
                loanCalculationPage.getTermInput(), String.valueOf(loanTerm));

        Thread.sleep(2000);
        double rate = Double.parseDouble(
                loanCalculationPage
                        .getLoanRateText()
                        .getText()
                        .replaceAll("[^0-9,]", "")
                        .replace(",", ".")
        );


        double  actualResult = Double.parseDouble(
                loanCalculationPage.getMonthlyTermAmount().getText()
                        .replace(".", "")
                        .replace(",", ".")
                        .replaceAll("[^\\d.]", "")
        );

        double expectedResult = calculator.loanCalculator(rate);


        try {
            Assert.assertEquals(actualResult, expectedResult, "Net faiz değerleri eşit değil!");
            ExtentManager.pass("Net faiz değeri beklendiği gibi: " + expectedResult);
        } catch (AssertionError e) {
            ExtentManager.fail("Net faiz değeri beklenenden farklı. Beklenen: " + expectedResult + ", Bulunan: " + actualResult);
            Assert.fail("Net faiz değerleri eşit değil! Hata: " + e.getMessage());
        }



        Thread.sleep(2000);

    }
}