package com.newnoa.wheel.service.impl;

import com.newnoa.wheel.service.WebsocketClientService;
import com.newnoa.wheel.service.WebsocketServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 23:47
 */

@Service("gearWebsocketService")
@Slf4j
public class GearWebsocketServiceImpl implements WebsocketClientService, WebsocketServerService {
    @Override
    public void sendMessage(String id, String message) {
    }

    @Override
    public void broadCast(String message) {

    }

    @Override
    public void handleOpen(WebSocketSession session) {

    }

    @Override
    public void handleClose(WebSocketSession session) {
    }

    @Override
    public void handleMessage(WebSocketSession session, String message) {

    }

    @Override
    public void handleError(WebSocketSession session, Throwable error) {

    }
}
