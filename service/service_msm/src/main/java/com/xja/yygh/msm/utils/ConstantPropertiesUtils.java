package com.xja.yygh.msm.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoYan
 * @Data 2022/12/26 15:20
 * 时间不早了  注意休息
 */
@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun.sms.regionId}")
    private String regionId;

    @Value("${aliyun.sms.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.sms.secret}")
    private String secret;


    @Value("${aliyun.sms.signName}")
    private String signName;

    @Value("${aliyun.sms.TemplateCode}")
    private String templateCode;

    public static String REGION_Id;
    public static String ACCESS_KEY_ID;
    public static String SECRECT;

    public static String SIGN_NAME;

    public static String TEMPLATE_CODE;
    @Override
    public void afterPropertiesSet() throws Exception {
        REGION_Id=regionId;
        ACCESS_KEY_ID=accessKeyId;
        SECRECT=secret;
        SIGN_NAME=signName;
        TEMPLATE_CODE=templateCode;
    }
}
