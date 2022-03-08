package com.xuan.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;
import com.xuan.pay.pojo.PayInfo;

import java.math.BigDecimal;

public interface IPayService {
    /*创建支付*/
    PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);
    /*异步通知*/
    String asyncNotify(String notifyData);

    /*通过订单号查询支付记录*/
    PayInfo queryByOrderId(String orderId);
}
