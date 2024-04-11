package com.newnoa.wheel.entity.po;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/10 12:02
 */
@Data
@Builder
public class GearServerLog {
    private String id;
    private String codeId;
    private String codeAliasName;
    private Object inputParameter;
    private Object outputResult;
    private Date inputTime;
    private Date outputTime;
    private Date logTime;
}
