package com.newnoa.wheel.entity.dto;

import javax.crypto.SecretKey;
import lombok.Data;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/8 17:12
 */
@Data
public class GearServerDto {
    private SecretKey secretKey;
    private String host;
    private String port;
}
