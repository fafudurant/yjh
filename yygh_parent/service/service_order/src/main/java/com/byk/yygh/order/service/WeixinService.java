package com.byk.yygh.order.service;

import java.util.Map;

/**
 * @author byk
 */
public interface WeixinService {

    //生成微信支付扫描二维码
    Map createNative(Long orderId);

    //调用微信接口实现支付状态查询
    Map<String, String> queryPayStatus(Long orderId);

    /***
     * 退款
     * @param orderId
     * @return
     */
    Boolean refund(Long orderId);

}
