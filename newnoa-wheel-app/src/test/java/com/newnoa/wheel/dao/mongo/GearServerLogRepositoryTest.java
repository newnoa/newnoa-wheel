package com.newnoa.wheel.dao.mongo;

import com.newnoa.wheel.WheelBootstrap;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/11 14:05
 */
@SpringBootTest(classes = {WheelBootstrap.class})
public class GearServerLogRepositoryTest {

    @Resource
    private GearServerLogRepository gearServerLogRepository;

    @Test
    public void testSave() {
//        GearServerLog gearServerLog =
//                GearServerLog.builder().codeAliasName("test").codeId("1234567890").inputParameter("input")
//                .outputResult("result")
//                        .inputTime(new Date()).outputTime(new Date()).logTime(new Date())
//                        .build();
//        this.gearServerLogRepository.save(gearServerLog);
    }

}
