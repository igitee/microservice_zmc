package com.zmc.springcloud.mapper;

import com.zmc.springcloud.entity.Ship;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xyy on 2018/12/5.
 *
 * @author xyy
 */
@Mapper
public interface ShipMapper {
    @Select("SELECT * FROM hy_ship WHERE id = #{shipId}")
    Ship findById(Long shipId);

    @Select("SELECT * FROM hy_ship WHERE order_id = #{orderId}")
    List<Ship> getShipListByOrderId(Long orderId);
}
