package com.zmc.springcloud.service;

import com.zmc.springcloud.utils.Json;

import java.util.HashMap;

/**
 * Created by xyy on 2019/1/20.
 *
 * @author xyy
 */
public interface BusinessOrderService {
    /** 手机端 商贸订单列表*/
    HashMap<String,Object> getOrderListByAccount(Integer page, Integer rows, Long wechatId, Integer status, Boolean isValid, Boolean isShow) throws Exception;
    /** 手机端 商贸订单详情*/
    HashMap<String,Object> getOrderDetailById(Long orderId) throws Exception;
    /** 退款订单详情*/
    Json getRefundOrderDetail(Long orderId) throws Exception;
}
