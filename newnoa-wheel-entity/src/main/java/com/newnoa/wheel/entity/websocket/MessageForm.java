package com.newnoa.wheel.entity.websocket;

import lombok.Data;
import org.joda.time.DateTime;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/15 0:31
 */
@Data
public class MessageForm {
    private String action;
    private String body;
    private DateTime dateTime;
}
