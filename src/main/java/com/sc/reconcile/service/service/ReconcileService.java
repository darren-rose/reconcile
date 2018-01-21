package com.sc.reconcile.service.service;

import com.sc.reconcile.service.domain.ReconcileRequest;
import com.sc.reconcile.service.domain.ReconcileResponse;

public interface ReconcileService {
    public ReconcileResponse reconcile(final ReconcileRequest reconcileRequest);
}
