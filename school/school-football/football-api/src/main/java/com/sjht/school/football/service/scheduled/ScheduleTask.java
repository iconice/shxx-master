package com.sjht.school.football.service.scheduled;

import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.football.entity.football.event.EventEntity;
import com.sjht.school.football.resp.football.student.GradeResp;
import com.sjht.school.football.service.football.event.EventService;
import com.sjht.school.football.service.football.site.SiteService;
import com.sjht.school.football.service.football.team.TeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 *
 * @ClassName ScheduleTask
 * @Description 描述
 * @Author 张弛
 * @Date 2019/10/22 8:34
 * @Version V1.0
 * ****************************************************
 **/
@Component
@EnableScheduling
public class ScheduleTask {
    @Autowired
    private EventService eventService;

    @Autowired
    private TeamService teamService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    //private

//    @Scheduled(fixedRate = 5000) //通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行
//    public void reportCurrentTime(){
//        System.out.println("每隔5秒执行一次 "+dateFormat.format(new Date()));
//    }

    @Scheduled(cron = "0 27 11 * * ?" ) //每天晚上7点执行；[秒] [分] [小时] [日] [月] [周] [年]
    //cron是UNIX和类UNIX(Linux)系统下的定时任务
    public void teamTodayScore(){
        //System.out.println("在指定时间 "+dateFormat.format(new Date())+" 执行");
        //查找当天所有比赛 已结束的球队。球队1积分大于球队2积分 球队1加3   平1  负0
        List<EventEntity> datas= eventService.showTodayEvent();
        for(EventEntity entity: datas){
            //先判断是否有轮空队伍，
            //如果球队1为空，为球队2加3分，进入下个循环
            if(StringUtils.isNotBlank(entity.getTeam1Id()) || StringUtils.isNotBlank(entity.getTeam2Id())){
                //continue;
                if(entity.getTeam1Score() > entity.getTeam2Score()){
                    teamService.win(entity.getTeam1Id());
                }
                if(entity.getTeam1Score() < entity.getTeam2Score()){
                    teamService.win(entity.getTeam2Id());
                }
                if(entity.getTeam1Score() == entity.getTeam2Score()){
                    teamService.flat(entity.getTeam1Id());
                    //teamService.flat(entity.getTeam2Id());
                }
            }

          /*  else{
                return ResultUtil.error("未知错误");
            }*/

        }
//        int count = getEventCount();
//        List<EventEntity> data = gradeDao.getEventList();
//        for(int i=0;i<count;i++){
//            if (data[i]){
//                win();
//            }
//            if (){
//                flat();
//                flat();
//            }
//            if (){
//
//            }
//
//            }
//
   }
}
