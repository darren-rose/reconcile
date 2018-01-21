package com.sc.reconcile.service.service;

import com.sc.reconcile.service.domain.ReconcileRequest;
import com.sc.reconcile.service.domain.ReconcileResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class ReconcileServiceImpl implements  ReconcileService {

    @Override
    public ReconcileResponse reconcile(ReconcileRequest reconcileRequest) {
        // TODO calculate report
        return new ReconcileResponse(Stream.of("x0", "x1").collect(Collectors.toList()), null, null, null);
    }

}
