package com.github.atomfrede.applicationinsightsdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SampleWebController {

    @Autowired
    private ApplicationInsightsService applicationInsightsService;

    @GetMapping("business-unit-a")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void businessUnitA() {
        applicationInsightsService.trackEvent(BusinessUnit.BU_A, "aCustomEvent");
    }

    @GetMapping("business-unit-b")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void businessUnitB() {
        applicationInsightsService.trackEvent(BusinessUnit.BU_B, "anotherCustomEvent");
    }
}
