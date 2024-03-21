package com.zee.tightly;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.UUID;

@Getter
@Setter
public class GiftCardBalance {

    private UUID userId;
    private BigDecimal amount;

    public GiftCardBalance(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public void addBalance(BigDecimal amount) {

        BigDecimal bonusAmount = amount.multiply(BigDecimal.TEN)
                .divide(new BigDecimal(100), MathContext.DECIMAL64);

        setAmount(this.amount.add(amount).add(bonusAmount));

    }
}
