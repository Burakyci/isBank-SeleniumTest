package helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LoanCalculator {

    public double loanCalculator(double loanRate) {
        double loanAmount = ConfigReader.getDoubleProperty("loanAmount");
        int loanTerm = ConfigReader.getIntProperty("loanTerm");
        double kkdfRate = ConfigReader.getDoubleProperty("kkdfRate");
        double bsmvRate = ConfigReader.getDoubleProperty("bsmvRate");

        double totalRate = new BigDecimal(((loanRate * (1 + kkdfRate + bsmvRate)) / 100) + 1)
                .setScale(11, RoundingMode.HALF_UP)
                .doubleValue();

        double rawResult = (Math.pow(totalRate, loanTerm) * (totalRate - 1) / (Math.pow(totalRate, loanTerm) - 1)) * loanAmount;

        // Ondalık kısmı sil (ör: 11577.13 → 11577.0)
        double result = new BigDecimal(rawResult)
                .setScale(2, RoundingMode.HALF_UP)  // aşağı yuvarlama (truncate)
                .doubleValue();

        return result;
    }
}
