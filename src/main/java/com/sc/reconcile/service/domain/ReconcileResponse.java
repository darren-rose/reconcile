package com.sc.reconcile.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReconcileResponse {
    private List<String> exact;
    private List<String> weak;
    private List<String> x;
    private List<String> y;
}
