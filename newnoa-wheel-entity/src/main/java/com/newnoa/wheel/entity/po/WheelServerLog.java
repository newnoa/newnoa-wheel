package com.newnoa.wheel.entity.po;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 12:02
 */
@Data
@Builder
public class WheelServerLog {
    private String id;
    private String registerType;
    private String registerHost;
    private String registerPort;
    private String registerName;
    private Date registerTime;
}
