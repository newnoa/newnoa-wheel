package com.newnoa.wheel.config;

import com.newnoa.wheel.interceptor.WebsocketAuthInterceptor;
import com.newnoa.wheel.websocket.NewnoaWebsocketServerHandler;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 21:18
 */

@Configuration
public class WebsocketConfig implements WebSocketConfigurer {

    @Resource(name = "wheelWebSocketServerHandler")
    private NewnoaWebsocketServerHandler wheelWebSocketServerHandler;

    @Resource(name = "gearWebSocketServerHandler")
    private NewnoaWebsocketServerHandler gearWebSocketServerHandler;

    @Resource(name = "powerWebSocketServerHandler")
    private NewnoaWebsocketServerHandler powerWebSocketServerHandler;
    @Resource(name = "websocketAuthInterceptor")
    private WebsocketAuthInterceptor websocketAuthInterceptor;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(this.wheelWebSocketServerHandler, "/ws/wheel")
                .addHandler(this.gearWebSocketServerHandler, "/ws/gear")
                .addHandler(this.powerWebSocketServerHandler, "/ws/power")
                .addInterceptors(this.websocketAuthInterceptor).setAllowedOrigins("*");
    }
}
