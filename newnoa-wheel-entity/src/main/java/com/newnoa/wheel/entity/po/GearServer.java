package com.newnoa.wheel.entity.po;

import com.newnoa.wheel.entity.dto.GearServerDto;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
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
 * @since 2024/4/8 16:46
 */
@Data
@Node("Gear")
public class GearServer implements Serializable {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    @Property
    private String gearId;
    private String name;
    private String host;
    private String realIp;
    private String proxyIp;
    private Integer port;

    private String os;


    private Integer deviceType;
    private Integer computeType;


    private Integer isOnline;
    private Date lastOnlineDate;
    private String serverResource;


    public GearServer(GearServerDto gearServerDto) {

    }
}
