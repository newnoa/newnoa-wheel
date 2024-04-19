package com.newnoa.wheel.config;

import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/15 20:24
 */
public class UndertowPoolCustomizer implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
//        factory.addDeploymentInfoCustomizers(deploymentInfo -> {
//            WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
//            webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(true, 16364));
//            deploymentInfo.addServletContextAttribute("io.undertow.websockets.jsr.WebSocketDeploymentInfo",
//                    webSocketDeploymentInfo);
//        });
    }
}
