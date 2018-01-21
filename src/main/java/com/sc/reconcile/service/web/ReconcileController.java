package com.sc.reconcile.service.web;

import com.sc.reconcile.service.domain.ReconcileRequest;
import com.sc.reconcile.service.domain.ReconcileResponse;
import com.sc.reconcile.service.service.ReconcileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ReconcileController {

    @Autowired
    private ReconcileService reconcileService;

    @PostMapping("/reconcile")
    public ReconcileResponse reconcile(@RequestBody final ReconcileRequest reconcileRequest){
        return reconcileService.reconcile(reconcileRequest);
    }

}
