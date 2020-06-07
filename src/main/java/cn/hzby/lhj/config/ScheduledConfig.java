package cn.hzby.lhj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
 
/**
 * @version: V2.0
 * @author: LHJ
 * @className: ScheduledConfig
 * @packageName: config
 * @description: 多线程执行定时任务
 * @data: 2020-05-25 13:20
 **/
@Configuration
//所有的定时任务都放在一个线程池中，定时任务启动时使用不同都线程。
//线程池应该交给容器管理，可以不用实现SchedulingConfigurer接口
public class ScheduledConfig{
	@Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        return scheduler;
    }
	
}


/**
 * @version: V1.0
 * @author: LHJ
 * @className: ScheduledConfig
 * @packageName: config
 * @description: 多线程执行定时任务
 * @data: 2020-05-25 11:00
 **/
//@Configuration
////所有的定时任务都放在一个线程池中，定时任务启动时使用不同都线程。
//public class ScheduleConfig implements SchedulingConfigurer {
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        //设定一个长度10的定时任务线程池
//        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
//    }
//}