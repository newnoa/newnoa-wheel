package com.newnoa.wheel.dao.neo4j;

import com.newnoa.wheel.WheelBootstrap;
import com.newnoa.wheel.entity.po.PowerClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/12 19:26
 */
@SpringBootTest(classes = {WheelBootstrap.class})
public class PowerClientRepositoryTest {
    @Autowired
    private PowerClientRepository powerClientRepository;
    @Autowired
    private PowerGearRelationShipRepository powerGearRelationShipRepository;
    @Autowired
    private PowerWheelRelationShipRepository powerWheelRelationShipRepository;
    @Autowired
    private WheelGearRelationShipRepository wheelGearRelationShipRepository;


    @Autowired
    private GearServerRepository gearServerRepository;
    @Autowired
    private WheelServerRepository wheelServerRepository;


    @Test
    public void testRepository() {
//        powerClientRepository.deleteById("79ae8f72-bc9b-45d9-9389-2e72b8289d88");
//        wheelServerRepository.deleteById("dcdcee9e-b3f7-4fd9-b748-6b98f7471525");
//        Optional<PowerClient> powerClientOptional = powerClientRepository.findById
//        ("79ae8f72-bc9b-45d9-9389-2e72b8289d88");
//        PowerClient powerClient = powerClientOptional.get();
//        Optional<WheelServer> wheelServerOptional = wheelServerRepository.findById
//        ("dcdcee9e-b3f7-4fd9-b748-6b98f7471525");
//        WheelServer wheelServer = wheelServerOptional.get();
//        PowerWheelRelationShip powerWheelRelationShip = new PowerWheelRelationShip();
//        powerWheelRelationShip.setRelation("powerClient-wheelServer");
//        powerWheelRelationShip.setIndexName("101-102");
//        powerWheelRelationShip.setWheelServer(wheelServer);
//        powerWheelRelationShip.setPowerClient(powerClient);
//        powerWheelRelationShipRepository.save(powerWheelRelationShip);
        powerClientRepository.deleteAll();
        PowerClient powerClient = new PowerClient();
        powerClient.setPowerId("power-101");
        powerClient.setName("power-101");
        powerClient.setHost("192.168.210.101");
        powerClient.setIp("192.168.210.101");
        powerClient.setIsOnline(1);
        powerClientRepository.save(powerClient);
        System.out.println(powerClient.getId());
//        Optional<PowerClient> powerClientOptional = powerClientRepository.findById(powerClient.getPowerId());
//        PowerClient powerClient = powerClientOptional.get();
//        WheelServer wheelServer = new WheelServer
//                .wheelId("wheel-102").name("wheel-102").host("192.168.210.102").ip("192.168.210.102").port(8080)
//                .isOnline(1).os("centos").build();
//        wheelServerRepository.save(wheelServer);
//        GearServer gearServer = GearServer.builder().gearId("gear-103").name("gear-103").host("192.168.210.103")
//        .realIp("192.168.210.103").port(8090).deviceType("pc").computeType("gpu").isOnline(1)
//                .serverResource("4c8g-p4").build();
//        gearServerRepository.save(gearServer);

    }

    @Test
    public void testRelationRepository() {

    }

}
