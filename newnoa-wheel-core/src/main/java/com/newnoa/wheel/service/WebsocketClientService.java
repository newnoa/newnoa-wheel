package com.newnoa.wheel.service;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/14 22:50
 */


public interface WebsocketClientService {

    void sendMessage(String id, String message);

    void broadCast(String message);
}
