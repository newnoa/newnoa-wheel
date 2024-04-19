package com.newnoa.wheel.entity.po;

import java.io.Serializable;
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
 * @since 2024/4/8 16:46
 */
@Data
@Node("gearServer")
public class GearServer implements Serializable {
    @Id
    @GeneratedValue(UUIDStringGenerator.class)
    private String id;
    private String account;
    private String password;
    private String salt;
    private String nickname;

    private String osName;
    private String osArch;
    private String osVersion;
    private String javaVendorVersion;
    private String javaVersion;
    private String javaVendor;
    private String timezone;


    private String gearId;
    private String host;
    private Integer port;


    private String deviceType;
    private String computeType;

    private Integer isOnline;
    private Date lastOnlineDate;
    private String serverResource;
}
