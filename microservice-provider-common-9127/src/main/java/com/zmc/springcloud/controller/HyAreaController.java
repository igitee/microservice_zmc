package com.zmc.springcloud.controller;

import com.zmc.springcloud.entity.HyArea;
import com.zmc.springcloud.service.HyAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xyy on 2019/1/4.
 *
 * @author xyy
 */
@RestController()
public class HyAreaController {
    @Autowired
    private HyAreaService hyAreaService;

    @RequestMapping("/area/{id}")
    public HyArea getHyAreaById(@PathVariable Long id) throws Exception {
        return hyAreaService.getHyAreaById(id);
    }
}
