package com.byk.yygh.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.byk.yygh.model.order.OrderInfo;
import com.byk.yygh.vo.order.OrderCountQueryVo;
import com.byk.yygh.vo.order.OrderCountVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author byk
 */
public interface OrderMapper extends BaseMapper<OrderInfo> {

    //查询预约统计数据的方法
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}
