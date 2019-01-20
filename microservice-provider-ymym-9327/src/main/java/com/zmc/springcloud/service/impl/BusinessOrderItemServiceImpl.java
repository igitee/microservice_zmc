package com.zmc.springcloud.service.impl;

import com.zmc.springcloud.entity.BusinessOrderItem;
import com.zmc.springcloud.mapper.BusinessOrderItemMapper;
import com.zmc.springcloud.service.BusinessOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xyy on 2019/1/20.
 *
 * @author xyy
 */
@Service
public class BusinessOrderItemServiceImpl implements BusinessOrderItemService {
    @Autowired
    private BusinessOrderItemMapper businessOrderItemMapper;

    @Override
    public List<BusinessOrderItem> getBusinessOrderItemListByOrderId(Long orderId) {
        return businessOrderItemMapper.findListByOrderId(orderId);
    }
}
