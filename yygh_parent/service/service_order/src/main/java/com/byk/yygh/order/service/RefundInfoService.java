package com.byk.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.byk.yygh.model.order.PaymentInfo;
import com.byk.yygh.model.order.RefundInfo;

/**
 * @author byk
 */
public interface RefundInfoService extends IService<RefundInfo> {

    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);

}
