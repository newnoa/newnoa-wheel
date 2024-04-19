package com.newnoa.wheel.websocket;

import com.newnoa.wheel.service.WebsocketServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 21:42
 */


@Slf4j
public class NewnoaWebsocketServerHandler implements WebSocketHandler {

    private final WebsocketServerService websocketServerService;

    public NewnoaWebsocketServerHandler(WebsocketServerService websocketServerService) {
        this.websocketServerService = websocketServerService;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        this.websocketServerService.handleOpen(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
        if (message instanceof TextMessage textMessage) {
            this.websocketServerService.handleMessage(session, textMessage.getPayload());
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        this.websocketServerService.handleError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        this.websocketServerService.handleClose(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
