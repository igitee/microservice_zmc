package com.zmc.springcloud.feignclient.product;

import com.zmc.springcloud.entity.HyGroupitemPromotion;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xyy on 2019/1/19.
 *
 * @author xyy
 */
@FeignClient(name = "microservicecloud-product")
public interface HyGroupitemPromotionFeignClient {
    @RequestMapping(value = "/group/item/promotion/{id}")
    HyGroupitemPromotion getHyGroupitemPromotionById(@PathVariable("id") Long id);

    @RequestMapping(value = "/group/item/promotion/update")
    void updateGroupitemPromotion(HyGroupitemPromotion hyGroupitemPromotion);
}
