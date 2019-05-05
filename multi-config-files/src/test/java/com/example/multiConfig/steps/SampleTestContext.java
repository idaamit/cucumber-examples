package com.example.multiConfig.steps;

import com.example.multiConfig.SampleService;

public class SampleTestContext {
    private SampleService sampleService;

    public SampleTestContext(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    public SampleService getSampleService() {
        return sampleService;
    }
}
