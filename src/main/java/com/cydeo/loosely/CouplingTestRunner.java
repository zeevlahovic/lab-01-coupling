package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class CouplingTestRunner {

    public static void main(String[] args) {

        UUID user = UUID.randomUUID();

        Balance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        Balance giftCardBalance = new GiftCardBalance(user,BigDecimal.ZERO);

        BalanceService balanceService = new BalanceService(customerBalance);
        BalanceService balanceService1 = new BalanceService(giftCardBalance);

        customerBalance.addBalance(BigDecimal.valueOf(100));
        giftCardBalance.addBalance(BigDecimal.valueOf(100));

        System.out.println("CUSTOMER BALANCE:");
        System.out.println(customerBalance.getAmount()); // 100

        System.out.println(balanceService.checkout(BigDecimal.valueOf(50)));
        System.out.println(customerBalance.getAmount());//50

        System.out.println("====================================================");
        System.out.println("====================================================");

        System.out.println("GIFT CARD BALANCE:");
        System.out.println(giftCardBalance.getAmount()); //110
        System.out.println(balanceService1.checkout(BigDecimal.valueOf(50)));
        System.out.println(giftCardBalance.getAmount()); //60

    }
}
