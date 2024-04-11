package com.newnoa.wheel.common;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 19:14
 */
public final class SocketUtil {
    public static long getLatency(String host, int port) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(host);
        Socket socket = null;
        try {
            long startTime = System.nanoTime();
            socket = new Socket(address, port);
            return System.nanoTime() - startTime;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (socket != null && !socket.isClosed()) {
                try {
                    socket.close();
                } catch (IOException _) {
                }
            }
        }
    }
}
