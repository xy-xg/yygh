package com.xja.yygh.sta.controller;

import com.xja.yygh.common.result.Result;
import com.xja.yygh.order.client.OrderFeignClient;
import com.xja.yygh.vo.order.OrderCountQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author xiaoYan
 * @Data 2022/12/27 12:23
 * 时间不早了  注意休息
 */
@Api(tags = "统计管理接口")
@RestController
@RequestMapping("/admin/statistics")
public class StatisticsController {

    @Autowired
    private OrderFeignClient orderFeignClient;

    @ApiOperation(value = "获取订单统计数据")
    @GetMapping("getCountMap")
    public Result getCountMap(@ApiParam(name = "orderCountQueryVo", value = "查询对象", required = false) OrderCountQueryVo orderCountQueryVo) {
        System.out.println("orderCountQueryVo = " + orderFeignClient.getCountMap(orderCountQueryVo));
        return Result.ok(orderFeignClient.getCountMap(orderCountQueryVo));
    }



}

