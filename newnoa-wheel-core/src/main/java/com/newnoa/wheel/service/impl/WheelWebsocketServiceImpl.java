package com.newnoa.wheel.service.impl;

import com.newnoa.wheel.entity.websocket.WheelWsModel;
import com.newnoa.wheel.service.WebsocketClientService;
import com.newnoa.wheel.service.WebsocketServerService;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 23:00
 */

@Service("wheelWebsocketService")
@Slf4j
public class WheelWebsocketServiceImpl implements WebsocketClientService, WebsocketServerService {

    private final ConcurrentMap<String, WheelWsModel> WHEEL_SERVER = new ConcurrentHashMap<>();

    @Override
    public void handleOpen(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        String token = attributes.get("token").toString();
        WheelWsModel wheelWsModel = new WheelWsModel();
        wheelWsModel.setToken(token);
        wheelWsModel.setWebSocketSession(session);
        WHEEL_SERVER.put(token, wheelWsModel);
        log.info("wheel login：{}, online count: {}", token, WHEEL_SERVER.size());
    }

    @Override
    public void handleClose(WebSocketSession session) {
        Map<String, Object> attributes = session.getAttributes();
        String token = attributes.get("token").toString();
        WHEEL_SERVER.remove(token);
        log.info("wheel logout：{}, online count: {}", token, WHEEL_SERVER.size());
    }

    @Override
    public void handleError(WebSocketSession session, Throwable error) {
        Map<String, Object> attributes = session.getAttributes();
        String token = attributes.get("token").toString();
        log.error("session id：{} websocket error：", session.getId(), error);
    }

    @Override
    public void sendMessage(String id, String message) {
        WebSocketSession webSocketSession = WHEEL_SERVER.get(id).getWebSocketSession();
        if (webSocketSession.isOpen()) {
            try {
                webSocketSession.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void broadCast(String message) {
        WHEEL_SERVER.values().forEach(wheelWsModel -> {
            WebSocketSession session = wheelWsModel.getWebSocketSession();
            if (session != null && session.isOpen()) {
                try {
                    session.sendMessage(new TextMessage(message));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }


    @Override
    public void handleMessage(WebSocketSession session, String message) {

    }
}
