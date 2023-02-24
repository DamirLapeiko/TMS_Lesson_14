package by.teachmeskills.lapeiko.homework14.exchange;

import java.math.BigDecimal;

public class ExchangeRate {
    private Currency currency;
    private BigDecimal bynRate;

    public ExchangeRate(Currency currency, BigDecimal bynRate){
        if (bynRate.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
        this.currency = currency;
        this.bynRate = bynRate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBynRate() {
        return bynRate;
    }
}
