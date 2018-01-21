package com.sc.reconcile.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReconcileRequest {
    private List<TransactionRecord> x;
    private List<TransactionRecord> y;
}
