package com.xja.yygh.hosp.repository;import com.xja.yygh.model.hosp.Hospital;import org.springframework.data.mongodb.repository.MongoRepository;import org.springframework.stereotype.Repository;import java.util.List;/** * @Author xiaoYan * @Data 2022/12/10 11:20 * 时间不早了  注意休息 */@Repositorypublic interface HospitalRepository extends MongoRepository<Hospital, String> {    //判断是否存在数据    Hospital getHospitalByHoscode(String hoscode);    //根据医院名称模糊查询    List<Hospital> findHospitalByHosnameLike(String hosname);}