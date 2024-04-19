package com.newnoa.wheel.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/16 12:49
 */
@Configuration
@ConditionalOnProperty(prefix = "opentelemetry", name = "enable", havingValue = "true")
public class OpenTelemetryProviderConfig {
    @Value("${spring.application.name}")
    private String serviceName;

    @Value("${opentelemetry.endpoint}")
    private String endpoint;

    private SdkTracerProvider tracerProvider;

    @PostConstruct
    public void init() {
        Resource serviceNameResource =
                Resource.create(Attributes.of(AttributeKey.stringKey("service.name"), serviceName));
        SpanExporter spanExporter = OtlpGrpcSpanExporter.builder().setEndpoint(endpoint).build();
        BatchSpanProcessor spanProcessor =
                BatchSpanProcessor.builder(spanExporter).setScheduleDelay(10L, TimeUnit.SECONDS)
                        .setMaxExportBatchSize(2000).build();
        tracerProvider = SdkTracerProvider.builder().addSpanProcessor(spanProcessor)
                .setResource(Resource.getDefault().merge(serviceNameResource)).build();
    }

    @PreDestroy
    public void shutdown() {
        if (tracerProvider != null) {
            tracerProvider.shutdown();
        }
    }
    
    @Bean
    public OpenTelemetry openTelemetry() {
        return OpenTelemetrySdk.builder().setTracerProvider(tracerProvider)
                .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance())).build();
    }

}
