package com.newnoa.wheel.config;

import com.newnoa.wheel.interceptor.WebsocketAuthInterceptor;
import com.newnoa.wheel.service.WebsocketServerService;
import com.newnoa.wheel.websocket.NewnoaWebsocketServerHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/15 19:57
 */

@Configuration
public class WebsocketHandlerConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(512 * 1024);
        container.setMaxBinaryMessageBufferSize(512 * 1024);
        container.setMaxSessionIdleTimeout(3600 * 1000L);
        return container;
    }

    @Bean(name = "wheelWebSocketServerHandler")
    public NewnoaWebsocketServerHandler wheelWebSocketServerHandler(
            @Qualifier("wheelWebsocketService") WebsocketServerService websocketServerService) {
        return new NewnoaWebsocketServerHandler(websocketServerService);
    }

    @Bean(name = "gearWebSocketServerHandler")
    public NewnoaWebsocketServerHandler gearWebSocketServerHandler(
            @Qualifier("gearWebsocketService") WebsocketServerService websocketServerService) {
        return new NewnoaWebsocketServerHandler(websocketServerService);
    }


    @Bean(name = "powerWebSocketServerHandler")
    public NewnoaWebsocketServerHandler powerWebSocketServerHandler(
            @Qualifier("powerWebsocketService") WebsocketServerService websocketServerService) {
        return new NewnoaWebsocketServerHandler(websocketServerService);
    }

    @Bean(name = "websocketAuthInterceptor")
    public WebsocketAuthInterceptor websocketAuthInterceptor() {
        return new WebsocketAuthInterceptor();
    }

}
