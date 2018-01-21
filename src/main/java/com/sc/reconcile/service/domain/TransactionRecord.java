package com.sc.reconcile.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRecord {
    private String transactionId;
    private String accountId;
    private LocalDate postingDate;
    private BigDecimal amount;
    private static final BigDecimal allowableDifference = BigDecimal.valueOf(0.01);

    public BigDecimal getAmount() {
        return this.amount.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

    public boolean isMatch(final TransactionRecord transactionRecord){
        if (!accountId.equalsIgnoreCase(transactionRecord.accountId)) return false;

        BigDecimal difference = getAmount().subtract(transactionRecord.getAmount()).abs();
        if (difference.compareTo(allowableDifference) == 1) return false;

        // TODO handle weekend spans
        return DAYS.between(getPostingDate(), transactionRecord.getPostingDate()) < 2;

    }

}
