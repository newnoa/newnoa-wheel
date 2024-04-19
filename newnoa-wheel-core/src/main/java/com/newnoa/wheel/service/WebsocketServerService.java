package com.newnoa.wheel.service;

import org.springframework.web.socket.WebSocketSession;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 22:55
 */
public interface WebsocketServerService {
    void handleOpen(WebSocketSession session);

    void handleClose(WebSocketSession session);

    void handleMessage(WebSocketSession session, String message);

    void handleError(WebSocketSession session, Throwable error);
}
