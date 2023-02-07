package com.xja.yygh.order.util;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoYan
 * @Data 2022/12/26 16:13
 * 时间不早了  注意休息
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${weixin.pay.appid}")
    private String appid;

    @Value("${weixin.pay.partner}")
    private String partner;

    @Value("${weixin.pay.partnerkey}")
    private String partnerkey;
    @Value("${D:\\IDE\\Util\\apiclient_cert.p12}")
    private String cert;
    public static String APPID;
    public static String PARTNER;
    public static String PARTNERKEY;

    public static String CERT;
    @Override
    public void afterPropertiesSet() throws Exception {
        APPID = appid;
        PARTNER = partner;
        PARTNERKEY = partnerkey;
        CERT = cert;
    }
}
