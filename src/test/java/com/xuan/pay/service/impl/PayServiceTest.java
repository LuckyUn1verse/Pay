package com.xuan.pay.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.xuan.pay.PayApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class PayServiceTest extends PayApplicationTests {
    @Autowired
    private PayServiceImpl payService;
    @Autowired
    private AmqpTemplate amqpTemplate;//rabbitMQ
    @Test
    public void create() {
    payService.create("54673354656", BigDecimal.valueOf(0.01), BestPayTypeEnum.valueOf("WX"));
    }
    @Test
    public void sendMQMsg(){
        //rabbitMQ
        amqpTemplate.convertAndSend("payNotify","hello");
    }
}