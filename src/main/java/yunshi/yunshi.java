package yunshi;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Random;

import yunshi.bot.*;

public class yunshi implements Job {
    public static String rand(long qq, long[] qqnum){
        String jili;
        int xingxing;
        int flag =0;
        for (long qqfind : qqnum){
            if (qqfind == qq){
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            for (int i=0; i<qqnum.length; i++){
                if (qqnum[i] == 0){
                    qqnum[i] = qq;
                }
            }
        }else {
            return "EOF";
        }

        Random random = new Random();
        int ran = random.nextInt(101);
        //设置星星？
        if (ran>0 && ran<10){
            jili = "下下签";
            xingxing = 1;
        }else if (ran == 0){
            jili = "非酋签";
            xingxing = 0;
        }
        else if (ran>=10 && ran<20){
            jili = "下下签";
            xingxing = 2;
        }else if (ran>=20 && ran<30){
            jili = "下签";
            xingxing =3;
        }else if (ran>=30 && ran<40){
            jili = "下签";
            xingxing = 4;
        }else if (ran>=40 && ran<50){
            jili = "中签";
            xingxing = 5;
        }else if (ran>=50 && ran<60){
            jili = "中签";
            xingxing = 6;
        }else if (ran>=60 && ran<70){
            jili = "中签";
            xingxing = 7;
        }else if (ran>=70 && ran<80){
            jili = "上签";
            xingxing = 8;
        }else if (ran>=80 && ran<90){
            jili = "上签";
            xingxing = 9;
        }else if (ran>=90 && ran<100){
            jili = "上上签";
            xingxing = 10;
        }else { //ran == 100
            jili = "欧皇签";
            xingxing = 20;
        }
        String pack = "运气值:"+ ran + "\r" + point(jili, xingxing);


        return pack;
    }

    public static String point(String jili, int xingxing){
        String pack = "";
        String XING ="";
        String shi = "★";
        String kong = "☆";
        if (xingxing <20){
            for (int i=0; i<xingxing; i++){
                XING += shi;
            }
            for (int i=0; i<(10-xingxing); i++){
                XING += kong;
            }
        }else {
            XING = "★★★★★★★★★★★★★★★★★★★★";
        }
        pack = jili + "\r" + XING;
        return pack;
    }

    public static void main(String[] args) {
        long[] i1 = new long[10];
        System.out.println(i1[7]);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        yunshiMain.qqnum = new long[100];
        Core.sendGroupMessages(yunshiMain.selfQQ,yunshiMain.fromGroup,"运势已刷新!",0);
    }
}
