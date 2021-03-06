package com.zmc.springcloud.service;

import com.zmc.springcloud.entity.HyGroupitemPromotion;

/**
 * Created by xyy on 2018/12/5.
 *
 * @author xyy
 */
public interface HyGroupitemPromotionService {
    HyGroupitemPromotion getHyGroupitemPromotionById(Long specialtyId) throws Exception;

    /** 更新promotionNum和havePromoted*/
    void updateHyGroupitemPromotion(HyGroupitemPromotion groupitemPromotion);
}
