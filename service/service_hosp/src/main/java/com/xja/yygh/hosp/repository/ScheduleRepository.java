package com.xja.yygh.hosp.repository;import com.xja.yygh.model.hosp.Schedule;import org.springframework.data.mongodb.repository.MongoRepository;import org.springframework.stereotype.Repository;import java.util.Date;import java.util.List;@Repositorypublic interface ScheduleRepository extends MongoRepository<Schedule,String> {    Schedule getScheduleByHoscodeAndHosScheduleId(String hoscode, String hosScheduleId);    /**    * @return    * @author xiaoYan    * @params    * @date 2022/12/17 17:09     * 根据医院编号 、科室编号和工作日期，查询排班详细信息    */    List<Schedule> findScheduleByHoscodeAndDepcodeAndWorkDate(String hoscode, String depcode, Date toDate);    Schedule getScheduleByhosScheduleId(String hosScheduleId);}