package test;

import java.io.IOException;

import Base.ExtentManager;
import helpers.ConfigReader;
import helpers.ScrollHelper;
import helpers.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.Hooks;
import pageObjects.DepositCalculationPage;
import pageObjects.Homepage;

@Listeners(resources.Listeners.class)
public class DepositCalculationTest extends Hooks {

    public DepositCalculationTest() throws IOException {
        super(); // Hooks constructor'u IOException fırlattığı için burada da belirtmen gerek
    }
    @Test
    public void testDepositCalculation() throws IOException, InterruptedException {

        int depositAmount = ConfigReader.getIntProperty("depositAmount");
        int depositDays = ConfigReader.getIntProperty("depositDays");
        int depositInterestRate = ConfigReader.getIntProperty("depositInterestRate");
        double taxRate = ConfigReader.getDoubleProperty("taxRate");



        Homepage homepage = new Homepage();
        DepositCalculationPage depositCalculationPage = new DepositCalculationPage();
        ScrollHelper scrollHelper = new ScrollHelper();
        WaitHelper waitHelper = new WaitHelper();
        Thread.sleep(2000);


        scrollHelper.scrollOnElement(homepage.getDepositCalculation());
        Thread.sleep(2000);

        homepage.getDepositCalculation().click();
        Thread.sleep(2000);

        waitHelper.waitForElementVisibility(depositCalculationPage.calculateButton,10);
        Thread.sleep(2000);
        scrollHelper.scrollOnElement(depositCalculationPage.getCalculateButton());
        depositCalculationPage.getAmountInput().sendKeys(String.valueOf(depositAmount));
        depositCalculationPage.getDayInput().sendKeys(String.valueOf(depositDays));
        depositCalculationPage.getInterestRateInput().sendKeys(String.valueOf(depositInterestRate));
        depositCalculationPage.getCalculateButton().click();
        Thread.sleep(2000);
        waitHelper.waitForElementVisibility(depositCalculationPage.amountCalculated,10);
        scrollHelper.scrollOnElement(depositCalculationPage.getAmountCalculated());
        String text = depositCalculationPage.getAmountCalculated().getText();

        double expectedResult = ((double) (depositAmount * depositInterestRate) / 365) * depositDays * taxRate/100;
        String onlyNumber = text.replaceAll("[^0-9,]", "");
        onlyNumber = onlyNumber.replace(".", "").replace(",", ".");
        double actualResult = Double.parseDouble(onlyNumber);

        double expectedRounded = Math.round(expectedResult * 1020.0) / 100.0;
        double actualRounded = Math.round(actualResult * 100.0) / 100.0;

        System.out.println(expectedRounded);
        System.out.println(actualRounded);

        try {
            Assert.assertEquals(actualRounded, expectedRounded, "Net faiz değerleri eşit değil!");
            ExtentManager.pass("Net faiz değeri beklendiği gibi: " + expectedRounded);
        } catch (AssertionError e) {
            ExtentManager.fail("Net faiz değeri beklenenden farklı. Beklenen: " + expectedRounded + ", Bulunan: " + actualRounded);
            Assert.fail("Net faiz değerleri eşit değil! Hata: " + e.getMessage());
        }

    }
}