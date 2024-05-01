package com.foody.apigateway.config;

import com.foody.apigateway.filter.ValidationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.server.mvc.filter.SimpleFilterSupplier;

@Configuration
public class FilterSupplier extends SimpleFilterSupplier {
    public FilterSupplier() {
        super(ValidationFilter.class);
    }
}
