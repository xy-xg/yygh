package com.xja.yygh.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xja.yygh.model.order.OrderInfo;
import com.xja.yygh.model.order.PaymentInfo;

import java.util.Map;

public interface PaymentService extends IService<PaymentInfo> {
    /**
     * 保存交易记录
     * @param order
     * @param paymentType 支付类型（1：微信 2：支付宝）
     */
    void savePaymentInfo(OrderInfo order, Integer paymentType);

    /**
     *
     * 支付状态
     */
    void paySuccess(String outTradeNo, Integer status, Map<String, String> resultMap);

    PaymentInfo getPaymentInfo(Long orderId, Integer payment_type);
}
