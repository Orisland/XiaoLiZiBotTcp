package Bot_test.impl;

import Bot_test.HttpUtil;
import Bot_test.WowsInfos;
import Bot_test.pojo.WowsApiConfig;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class WowsInfosImpl implements WowsInfos {

    /**
     *
     * @param args
     * 测试方法
     * 个人是传参数打断点看看回参就ok了
     *
     */
    public static void main(String[] args){

        WowsInfosImpl tst = new WowsInfosImpl();

            String msg = "查水表 Orisland_EX";
        String[] msgSplit = msg.split( " ");

        String uid = tst.getUserId(msgSplit[1]);
        String res = tst.getUserBasicInfo(uid);

        System.out.println(res);
    }

    /**
     * GET
     * 通过用户名获取用户id
     * wows所有用户相关的api都是通过uid调用的，所以这一步是基础的一步
     * template url : https://api.worldofwarships.eu/wows/account/list/?application_id=21a433ec77510c77b44a3047937b4bb1&search=lsahi
     * {
     *      "status": "ok",
     *      "meta": {
     *          "count": 1
     *      },
     *      "data": [
     *      {
     *             "nickname": "lsahi",
     *             "account_id": 567190085
     *      }
     *      ]
     * }
     */
    @Override
    public String getUserId(String username) {

        // get user uid from WG
        String getUrl = WowsApiConfig.GET_PLAYER_ID
                + "?application_id=" + WowsApiConfig.APPID
                + "&search=" + username;
        JSONObject resp = JSONObject.parseObject(HttpUtil.Get(getUrl,""));

        List<Object> data = resp.getJSONArray("data");
        String status = resp.getString("status");

        if(!"ok".equals(status)){
            return "EOF";
        }

        JSONObject curUser = JSONObject.parseObject(data.get(0).toString());

        String name = curUser.getString("nickname");
        String id = curUser.getString("account_id");

        if(!name.equals(username)){
            return "EOF";
        }

        return id;
    }

    /**
     * GET
     * 通过uid获取用户基本信息(水表总表)
     * template url : https://api.worldofwarships.eu/wows/account/info/?application_id=21a433ec77510c77b44a3047937b4bb1&account_id=567190085
     *
     * 返回太麻烦了，去WG的api文档看吧
     * https://developers.wargaming.net/reference/eu/wows/account/info/
     */
    @Override
    public String getUserBasicInfo(String uid) {

        // get user info from WG
        String getUrl = WowsApiConfig.GET_PLAYER_BASIC_INFO
                + "?application_id=" + WowsApiConfig.APPID
                + "&account_id=" + uid;
        JSONObject resp = JSONObject.parseObject(HttpUtil.Get(getUrl,""));

        JSONObject userinfo = resp.getJSONObject("data").getJSONObject(uid);

        if (userinfo == null){
            return "EOF";
        }

        String nickname = userinfo.getString("nickname");
        JSONObject pvpStatus = userinfo.getJSONObject("statistics").getJSONObject("pvp");

        Long battles = pvpStatus.getLongValue("battles");
        Long survivedBattles = pvpStatus.getLongValue("survived_battles");
        Long max_xp = pvpStatus.getLongValue("max_xp");

        String res =
                "查询玩家信息" + nickname + "\n"
                + "总场数" + battles +"\n"
                + "存活场数" + survivedBattles + "\n"
                + "单场最大经验数"+max_xp + "\n";

        return res;
    }

}
