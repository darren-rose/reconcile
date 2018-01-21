package com.sc.reconcile.service.domain;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TransactionRecordTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void should_match_when_account_id_are_equal_date_difference_is_one_working_day_amount_difference_is_one_cent() {
        // Given
        final String txId = "x0";
        final String txId2 = "x1";
        final String accountId = "000000001";
        final TransactionRecord x = new TransactionRecord(txId, accountId, LocalDate.of(2018,1, 18), BigDecimal.valueOf(1.00f));
        final TransactionRecord y = new TransactionRecord(txId2, accountId, LocalDate.of(2018,1,19), BigDecimal.valueOf(1.01f));

        // When
        boolean actual = x.isMatch(y);

        // Then
        assertThat(actual, is(true));

    }

    @Test
    public void should_not_match_when_account_id_are_equal_date_difference_is_more_than_one_working_day_amount_difference_is_one_cent() {
        // Given
        final String txId = "x0";
        final String txId2 = "x1";
        final String accountId = "000000001";
        final TransactionRecord x = new TransactionRecord(txId, accountId, LocalDate.of(2018,1, 17), BigDecimal.valueOf(1.00f));
        final TransactionRecord y = new TransactionRecord(txId2, accountId, LocalDate.of(2018,1,19), BigDecimal.valueOf(1.01f));

        // When
        boolean actual = x.isMatch(y);

        // Then
        assertThat(actual, is(false));

    }

}