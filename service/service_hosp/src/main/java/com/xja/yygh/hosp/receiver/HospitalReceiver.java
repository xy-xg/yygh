package com.xja.yygh.hosp.receiver;import com.rabbitmq.client.Channel;import com.xja.yygh.hosp.service.ScheduleService;import com.xja.yygh.model.hosp.Schedule;import com.xja.yygh.rabbit.common.constant.MqConst;import com.xja.yygh.rabbit.common.service.RabbitService;import com.xja.yygh.vo.msm.MsmVo;import com.xja.yygh.vo.order.OrderMqVo;import org.springframework.amqp.core.Message;import org.springframework.amqp.rabbit.annotation.Exchange;import org.springframework.amqp.rabbit.annotation.Queue;import org.springframework.amqp.rabbit.annotation.QueueBinding;import org.springframework.amqp.rabbit.annotation.RabbitListener;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Component;import java.io.IOException;/** * @Author xiaoYan * @Data 2022/12/22 16:37 * 时间不早了  注意休息 */@Componentpublic class HospitalReceiver {    @Autowired    private ScheduleService scheduleService;    @Autowired    private RabbitService rabbitService;    @RabbitListener(bindings = @QueueBinding(            value = @Queue(value = MqConst.QUEUE_ORDER, durable = "true"),            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_ORDER),            key = {MqConst.ROUTING_ORDER}    ))    public void receiver(OrderMqVo orderMqVo, Message message, Channel channel) throws IOException {        if (null != orderMqVo.getAvailableNumber()) {            //下单成功更新预约数            Schedule schedule = scheduleService.getById(orderMqVo.getScheduleId());            schedule.setReservedNumber(orderMqVo.getReservedNumber());            schedule.setAvailableNumber(orderMqVo.getAvailableNumber());            scheduleService.update(schedule);        }else {            //取消预约挂号            Schedule schedule = scheduleService.getScheduleId(orderMqVo.getScheduleId());            int availableNumber = schedule.getAvailableNumber() + 1;            schedule.setAvailableNumber(availableNumber);            scheduleService.update(schedule);        }        //发送短信        MsmVo msmVo = orderMqVo.getMsmVo();        if(null != msmVo) {            rabbitService.sendMessage(MqConst.EXCHANGE_DIRECT_MSM, MqConst.ROUTING_MSM_ITEM, msmVo);        }    }}