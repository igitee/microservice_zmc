package com.zmc.springcloud.feignclient.product;

import com.zmc.springcloud.entity.SpecialtyPrice;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xyy on 2019/1/19.
 *
 * @author xyy
 */
@FeignClient(name = "microservicecloud-product")
public interface SpecialtyPriceFeignClient {
    @RequestMapping(value = "/product/price")
    SpecialtyPrice getSpecialtyPriceList(@PathVariable("specialtySpecificationId") Long specialtySpecificationId, @PathVariable("isActive") Boolean isActive);
}
