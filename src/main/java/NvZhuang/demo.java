package NvZhuang;

import NvZhuang.bot.Core;
import NvZhuang.bot.NvMain;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class demo implements Job {
    static int flag=1;
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(flag);
        Core.sendGroupMessages(NvMain.selfQQ,1007248323,"[@1378580689]来自bot的第"+flag+"次催促:\r今天焦哥女装了吗？",0);
        //[@1378580689]来自bot的第"+flag+"次催促\r今天焦哥女装了吗？
        flag++;
    }
}
