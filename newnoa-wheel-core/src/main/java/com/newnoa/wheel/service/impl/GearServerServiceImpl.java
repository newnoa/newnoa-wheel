package com.newnoa.wheel.service.impl;

import com.newnoa.wheel.dao.neo4j.GearServerRepository;
import com.newnoa.wheel.entity.dto.GearServerDto;
import com.newnoa.wheel.entity.po.GearServer;
import com.newnoa.wheel.service.GearServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * newnoa-wheel.
 *
 * @author Neowei
 * @since 2024/4/8 17:11
 */
@Service
public class GearServerServiceImpl implements GearServerService {
    @Autowired
    private GearServerRepository gearServerRepository;

    public GearServer create(GearServerDto gearServerDto) {
//        GearServer gearServer = new GearServer(gearServerDto);
//        return gearServerRepository.save(gearServer);
        return null;
    }
}
