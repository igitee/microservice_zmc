package com.zmc.springcloud.feignclient.express;

import com.zmc.springcloud.entity.SpecialtySpecification;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xyy on 2019/1/19.
 *
 * @author xyy
 */
@FeignClient(name = "microservicecloud-express")
public interface SpecialtySpecificationFeignClient {
    @RequestMapping(value = "/product/specification/{id}")
    SpecialtySpecification getSpecialtySpecificationById(@PathVariable("id") Long id);
}