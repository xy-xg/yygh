package com.xja.yygh.task.scheduled;

import com.xja.yygh.rabbit.common.constant.MqConst;
import com.xja.yygh.rabbit.common.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author xiaoYan
 * @Data 2022/12/27 11:03
 * 时间不早了  注意休息
 */
@Component
@EnableScheduling
public class ScheduledTask {

    @Autowired
    private RabbitService rabbitService;

    /**
     * 每天8点执行 提醒就诊
     */
    @Scheduled(cron = "0 0 8 * * ?")
    public void task1() {
        rabbitService.sendMessage(MqConst.EXCHANGE_DIRECT_TASK, MqConst.ROUTING_TASK_8, "测试消息");
    }
}
