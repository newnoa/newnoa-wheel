package com.newnoa.wheel.entity.po;

import java.util.Date;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 16:51
 */

@Data
@Node("powerClient")
public class PowerClient {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String powerId;
    private String name;
    private String host;
    private String ip;
    private Integer isOnline;
    private Date lastOnlineDate;
}
