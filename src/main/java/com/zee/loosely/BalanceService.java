package com.zee.loosely;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BalanceService {

    private Balance balance;

    public BalanceService(Balance balance) {
        this.balance = balance;
    }

    public boolean checkout(BigDecimal checkoutAmount){

        BigDecimal balance = this.balance.getAmount();

        if (balance.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) >= 0){
            this.balance.setAmount(balance.subtract(checkoutAmount));
            return true;
        }

        return false;
        }


    }


