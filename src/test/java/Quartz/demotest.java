package Quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

public class demotest {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(demo.class).withIdentity("job1", "groups1").build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1").startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();

        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("==========start=========");
        scheduler.start();

        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("======shut down======");
    }
}
