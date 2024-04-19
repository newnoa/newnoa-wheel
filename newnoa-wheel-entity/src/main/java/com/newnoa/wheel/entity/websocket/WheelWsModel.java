package com.newnoa.wheel.entity.websocket;


import com.newnoa.wheel.entity.po.WheelServer;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 22:07
 */
@Data
public class WheelWsModel {
    private String token;
    private String id;
    private WebSocketSession webSocketSession;
    private WheelServer wheelServer;
}
