package com.newnoa.wheel.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/15 23:45
 */
@Configuration
@Slf4j
public class OpenTelemetryConfig {
    @Bean
    @ConditionalOnBean(OpenTelemetry.class)
    public Tracer tracer(@Autowired OpenTelemetry openTelemetry) {
        log.info("opentelemetry otel tracer");
        return openTelemetry.getTracer("wheel");
    }

    @Bean
    @ConditionalOnMissingBean(OpenTelemetry.class)
    public Tracer noopTracer() {
        log.info("opentelemetry noop tracer");
        return OpenTelemetry.noop().getTracer("noop");
    }

}
