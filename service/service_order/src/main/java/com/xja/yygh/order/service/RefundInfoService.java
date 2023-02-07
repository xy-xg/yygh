package com.xja.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.yygh.model.order.PaymentInfo;
import com.xja.yygh.model.order.RefundInfo;

public interface RefundInfoService extends IService<RefundInfo> {
    /**
     * 保存退款记录
     * @param paymentInfo
     */
    RefundInfo saveRefundInfo(PaymentInfo paymentInfo);
}

