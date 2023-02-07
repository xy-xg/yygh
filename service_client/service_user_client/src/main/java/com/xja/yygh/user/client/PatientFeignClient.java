package com.xja.yygh.user.client;import com.xja.yygh.model.user.Patient;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.stereotype.Repository;import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.PathVariable;/** * @Author xiaoYan * @Data 2022/12/22 15:17 * 时间不早了  注意休息 */@FeignClient(value = "service-user")@Repositorypublic interface PatientFeignClient {    //获取就诊人    @GetMapping("/api/user/patient/inner/get/{id}")    Patient getPatient(@PathVariable("id") Long id);}