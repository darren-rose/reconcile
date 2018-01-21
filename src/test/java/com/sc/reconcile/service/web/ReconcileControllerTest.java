package com.sc.reconcile.service.web;

import com.sc.reconcile.service.domain.ReconcileRequest;
import com.sc.reconcile.service.domain.ReconcileResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReconcileControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void reconcile_endpoint_should_return_success_code_and_response_body() {
        // Given
        ReconcileRequest reconcileRequest = new ReconcileRequest();

        // When
        ResponseEntity<ReconcileResponse> responseEntity = restTemplate.postForEntity("/reconcile", reconcileRequest, ReconcileResponse.class);

        // Then
        assertThat(responseEntity, is(notNullValue()));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is(notNullValue()));
    }

    @Test
    public void reconcile_endpoint_should_response_with_exact_matches() {
        // Given
        ReconcileRequest reconcileRequest = new ReconcileRequest();

        // When
        ResponseEntity<ReconcileResponse> responseEntity = restTemplate.postForEntity("/reconcile", reconcileRequest, ReconcileResponse.class);

        // Then
        assertThat(responseEntity, is(notNullValue()));
        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), is(notNullValue()));
        assertThat(responseEntity.getBody().getExact(), is(Stream.of("x0", "x1").collect(Collectors.toList())));
    }

}