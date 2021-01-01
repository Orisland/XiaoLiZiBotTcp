import anke.bot.Core;

import java.util.List;

public class chartest {
    public static void main(String[] args) {
        String res = "";
        res += "简易安科插件功能:\n";
        res += "发送指令：安科启动，以启动安科插件。\n";
        res += "输入以下指令即可触发安科:xdy: (x为任意整数字,要求y>=x,否则请求会被终止)\n";
        res += "举例：10d20:  bot将会发送10到20之间的随机一个数字\n";
        res += "输入以下指令即可触发安科:xdy+z: (加号可改为减号,x为任意整数字,要求y>=x,否则请求会被终止)\n";
        res += "举例：10d20-100:   bot将会发送10到20之间并减100的数字";
        System.out.println(res);

    }
}
