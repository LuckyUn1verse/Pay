package com.xuan.pay.config;


import com.lly835.bestpay.config.AliPayConfig;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BestPayConfig {

    @Autowired
    private WxAccountConfig wxAccountConfig;

    @Autowired
    private AlipayAccountConfig alipayAccountConfig;

    @Bean
    public BestPayService bestPayService() {
        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId(alipayAccountConfig.getAppId());
        aliPayConfig.setPrivateKey(alipayAccountConfig.getPrivateKey());
        aliPayConfig.setAliPayPublicKey(alipayAccountConfig.getPublicKey());
        aliPayConfig.setNotifyUrl(alipayAccountConfig.getNotifyUrl());
        aliPayConfig.setReturnUrl(alipayAccountConfig.getReturnUrl());

        WxPayConfig wxPayConfig=new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getAppId());
//        微信支付交易发起依赖于公众号、小程序、移动应用（即APPID）与商户号（即MCHID）的绑定关系，因此商户在完成签约后，需要确认当前商户号同appid的绑定关系，方可使用。
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
//        商户ID
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
//        商户密钥
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
        /*异步接收支付结果通知的回调地址*/
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
//        支付结果跳转地址

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);
        bestPayService.setAliPayConfig(aliPayConfig);
        return bestPayService;
    }

//    @Bean
//    public WxPayConfig wxPayConfig(){
//        WxPayConfig wxPayConfig=new WxPayConfig();
//        wxPayConfig.setAppId(wxAccountConfig.getAppId());
////        微信支付交易发起依赖于公众号、小程序、移动应用（即APPID）与商户号（即MCHID）的绑定关系，因此商户在完成签约后，需要确认当前商户号同appid的绑定关系，方可使用。
//        wxPayConfig.setMchId(wxAccountConfig.getMchId());
////        商户ID
//        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
////        商户密钥
//        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
//        /*异步接收支付结果通知的回调地址*/
//        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
////        支付结果跳转地址
//        return wxPayConfig;
//    }
}
