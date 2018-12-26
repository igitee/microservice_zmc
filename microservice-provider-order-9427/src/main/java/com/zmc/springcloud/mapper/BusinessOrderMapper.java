package com.zmc.springcloud.mapper;

import com.zmc.springcloud.entity.BusinessOrder;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;

import java.util.List;

import static com.zmc.springcloud.utils.CommonAttributes.BUSINESS_ORDER_STATUS_CANCELED;
import static com.zmc.springcloud.utils.CommonAttributes.BUSINESS_ORDER_STATUS_WAIT_FOR_PAY;
import static com.zmc.springcloud.utils.CommonAttributes.BUSINESS_ORDER_STATUS_WAIT_FOR_REVIEW;

/**
 * Created by xyy on 2018/12/5.
 *
 * @author xyy
 */
@Mapper
public interface BusinessOrderMapper {
    @Select("SELECT * FROM hy_business_order WHERE ID = #{id}")
    BusinessOrder findById(Long id);

    @SelectProvider(type = Provider.class, method = "findListOrder")
    List<BusinessOrder> findListOrder(Integer orderState, String orderCode, String orderPhone);
    class Provider {
        public String findListOrder(Integer orderState, String orderCode, String orderPhone) {
            StringBuilder stringBuilder = new StringBuilder("SELECT * FROM hy_business_order WHERE 1=1");
            if (orderState == -1) {
                stringBuilder.append(" AND order_state > ");
                stringBuilder.append(BUSINESS_ORDER_STATUS_WAIT_FOR_PAY);
            } else if (orderState == -2) {
                stringBuilder.append(" AND order_state > ");
                stringBuilder.append(BUSINESS_ORDER_STATUS_WAIT_FOR_REVIEW);
            } else if (orderState == -8) {
                stringBuilder.append(" AND order_state > ");
                stringBuilder.append(BUSINESS_ORDER_STATUS_CANCELED);
            } else {
                stringBuilder.append(" AND order_state = ");
                stringBuilder.append(orderState);
            }
            if (StringUtils.isNotBlank(orderCode)) {
                stringBuilder.append(" AND order_code LIKE '%");
                stringBuilder.append(orderCode);
                stringBuilder.append("%'");
            }
            if (StringUtils.isNotBlank(orderPhone)) {
                stringBuilder.append(" AND order_phone LIKE '%");
                stringBuilder.append(orderPhone);
                stringBuilder.append("%'");
            }
            stringBuilder.append(" ORDER BY id DESC");
            return stringBuilder.toString();
        }
    }

    @Insert("INSERT INTO hy_business_order(order_code, order_phone, order_wechat_id, webusiness_id, total_money, promotion_amount, ship_fee, shouldpay_money, coupon_money, balance_money, pay_money, order_state, order_time, review_time, pay_time, receiver_name, receiver_phone, receiver_address, receiver_remark, receiver_type, coupon_id, is_balanced, is_divided, parent_order_id, is_show, is_appraised, is_balance, reviewer, is_valid)  VALUES(#{orderCode},#{orderPhone},#{orderWechatId},#{weBusinessId},#{totalMoney},#{promotionAmount},#{shipFee},#{shouldpayMoney},#{couponMoney},#{balanceMoney},#{payMoney},#{orderState},#{orderTime},#{reviewTime},#{payTime},#{receiverName},#{receiverPhone},#{receiverAddress},#{receiverRemark},#{receiveType},#{couponId},#{isBalanced},#{isDivided},#{parentOrderId},#{isShow},#{isAppraised},#{isBalance},#{reviewer},#{isValid})" )
    void saveBusinessOrder(BusinessOrder order);

    @Update("UPDATE hy_business_order SET  = ,  = ,  = ,   WHERE id = #{id}")
    void updateBusinessOrder(BusinessOrder order);
}
