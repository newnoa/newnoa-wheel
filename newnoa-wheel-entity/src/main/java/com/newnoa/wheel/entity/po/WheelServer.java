package com.newnoa.wheel.entity.po;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/8 17:24
 */

@Data
@Node("wheelServer")
public class WheelServer {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    @Property
    private String wheelId;
    private String name;
    private String host;
    private String ip;
    private Integer port;
    private String os;
    private Integer isOnline;
}
