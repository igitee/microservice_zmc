package com.zmc.springcloud.service.impl;

import com.zmc.springcloud.entity.HyVinbound;
import com.zmc.springcloud.entity.SpecialtySpecification;
import com.zmc.springcloud.mapper.HyVinboundMapper;
import com.zmc.springcloud.service.HyVinboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xyy on 2018/12/7.
 *
 * @author xyy
 */
@Service
public class HyVinboundServiceImpl implements HyVinboundService{
    @Autowired
    private HyVinboundMapper hyVinboundMapper;

    @Override
    public HyVinbound findBySpecification(Long specificationId) {
        return hyVinboundMapper.findBySpcification(specificationId);
    }

    @Override
    public void saveHyVinbound(HyVinbound hyVinbound)throws Exception {
        hyVinboundMapper.insert(hyVinbound);
    }

    @Override
    public void updateHyVinbound(HyVinbound hyVinbound)throws Exception {
        hyVinboundMapper.update(hyVinbound);
    }

    @Override
    public List<HyVinbound> getHyVinboundListBySpecificationId(Long id) throws Exception {
        return hyVinboundMapper.findListBySpecificationId(id);
    }
}
