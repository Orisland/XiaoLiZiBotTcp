package wows.bot;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pic.Getpic;
import pic.pic;
import wows.Playerpackage;
import wows.Chart;

import java.util.Base64;
import java.util.concurrent.TimeUnit;


/**
 * 主要类
 * @author zhaoqk
 *
 * 2020年8月10日 下午5:07:37
 */
public class sbMain {
	public static long selfQQ=0L;
	public static long fromGroup=0L;
	public static long fromQQ=0L;

	/**
	 * 程序简介
	 * 1.如果我需要的事件下面没有怎么办？
	 * 答：作者是采集了一些常用的如果你需要其他事件 比如 好友更改签名
	 * 	     那你就启动项目 用机器人号的好友改一下签名 就会收到改签名的消息 看看msgType是对多少然后下面加个判断就行了。
	 * 2.如果我需要的API操作Core中没有怎么办？
	 * 答：如果你具备易语言开发能力请下载TcpAPI的源码然后按照格式增加一个API然后在Core中也增加一个对应的就可以了
	 *    如果你不具备易语言开发能力请加群742830386向我反映你需要的API 我会在更新时一块加上
	 * 3.你的插件不收费还开源为了什么？
	 * 答：这个东西对于我来说很简单，本来打算做一个自己玩玩然后越做越完善于是就开源大家一起玩
	 *    开源是因为我的维护时间不多你需要的可能我无法帮你完善，所以我开个头 你们 尽情发挥^_^
	 */

	static ChatClient clientTest;

	public static void main(String[] args) {
		clientTest = new ChatClient("127.0.0.1", 8404);
		clientTest.start();
	}

	/**
	 * 收到好友消息与事件
	 * @param data
	 */
	public static void receivePrivateMessages(String data){
		System.out.println("[收到好友消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			long random = json.getInteger("random");//撤回消息用
			long req = json.getInteger("req");//撤回消息用
			String msg = json.getString("msg");//消息内容
			long msgType = json.getInteger("msgType");//消息类型
			//long msgType2 = json.getInteger("msgType2");//消息类型
			if(msgType == 141){//公众号消息

			}else if(msgType == 87){//好友邀请入群

			}else if(msgType == 528){//申请加为好友

			}else if(msgType == 529){//好友文件消息

			}else if(msgType == 208){//好友语音消息
				req = 0L;
				random = 0L;
				Core.sendPrivateMessages(selfQQ, fromQQ, msg, random, req);
			}else if(msgType == 87){//好友邀请入群

			}else if(msgType == 166){//普通好友消息
				if (msg.indexOf("查水表") == 0) {
					if (msg.split(" ").length != 2) {
						Core.sendPrivateMessages(selfQQ, fromQQ, "命令格式错误，请修正。", random, req);
						Core.sendPrivateMessages(selfQQ, fromGroup, "别忘了空格哦~", random, req);
						return;
					}
					Core.sendPrivateMessages(selfQQ, fromGroup, "正在尝试获取数据~请稍后~", random, req);
					//Playerpackage playerpackage = new Playerpackage(msg);
					String atqq = "[@" + fromQQ + "]来了来了~" + "\r";
					//Core.sendPrivateMessages(selfQQ, fromGroup, playerpackage.getSpackage(), random, req);
				}
				else {
					msg += "~";
					Core.sendPrivateMessages(selfQQ, fromQQ, msg, random, req);
				}
			}
		}catch (Exception e) {
			System.out.println("[好友数据异常]");
		}

		//红包发送成功  "msgType":141,"msgType2":134,"msgTempType":129
		//87	好友邀请入群
		//528	申请加为好友
		//166	收到好友红包
	}
	/**
	 * 收到群聊消息
	 * @param data
	 */
	public static void receiveGroupMessages(String data){
		System.out.println("[收到群聊消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			selfQQ = json.getLong("selfQQ");//框架QQ
			fromQQ = json.getLong("fromQQ");//对方QQ
			fromGroup = json.getLong("fromGroup");//群号
			String msg = json.getString("msg");//消息内容
			//这里我写了一些常用指令
			if (msg.indexOf("欧服水表") == 0){
				if(msg.split( " ").length != 2){
					Core.sendGroupMessages(selfQQ,fromGroup,"命令格式错误，请修正。",0);
					Core.sendGroupMessages(selfQQ,fromGroup,"别忘了空格哦~",0);
					return;
				}
				Core.sendGroupMessages(selfQQ,fromGroup,"正在尝试获取数据~请稍后~",0);
				Playerpackage playerpackage = new Playerpackage(msg,0);
				String atqq = "[@"+fromQQ+"]来了来了~" + "\r";
				Core.sendGroupMessages(selfQQ,fromGroup,atqq + playerpackage.getSpackage(),0);
				Core.sendGroupMessages(selfQQ,fromGroup,"最后的图片显示需要手动开启~",0);
				System.out.println(playerpackage.getPic());
				Core.sendGroupMessagesPicText(selfQQ, fromGroup, playerpackage.getPic(), 0);
			}else if(msg.indexOf("亚服水表") == 0){
				if(msg.split( " ").length != 2){
					Core.sendGroupMessages(selfQQ,fromGroup,"命令格式错误，请修正。",0);
					Core.sendGroupMessages(selfQQ,fromGroup,"别忘了空格哦~",0);
					return;
				}
				Core.sendGroupMessages(selfQQ,fromGroup,"正在尝试获取数据~请稍后~",0);
				Playerpackage playerpackage = new Playerpackage(msg,1);
				String atqq = "[@"+fromQQ+"]来了来了~" + "\r";
				Core.sendGroupMessages(selfQQ,fromGroup,atqq + playerpackage.getSpackage(),0);
				Core.sendGroupMessages(selfQQ,fromGroup,"最后的图片显示需要手动开启~",0);
				System.out.println(playerpackage.getPic());
				Core.sendGroupMessagesPicText(selfQQ, fromGroup, playerpackage.getPic(), 0);
			}else if (msg.indexOf("欧服表单")==0){
				if (msg.split(" ").length < 2){
					Core.sendGroupMessages(selfQQ,fromGroup,"命令格式错误，请修正。",0);
					Core.sendGroupMessages(selfQQ,fromGroup,"0：全图模式  1：区域模式",0);
					return;
				}
				Core.sendGroupMessages(selfQQ,fromGroup,"正在尝试获取数据~请稍后~",0);
				String base64 = Chart.chart(msg,0);
				if (base64.equals("?")){
					return;
				}
				String atqq = "[@"+fromQQ+"]来了来了~" + "\r";
				Core.sendGroupMessagesPicText(selfQQ,fromGroup,atqq + "[pic:"+base64+"]",0);
			}else if (msg.indexOf("亚服表单")==0){
				if (msg.split(" ").length < 2){
					Core.sendGroupMessages(selfQQ,fromGroup,"命令格式错误，请修正。",0);
					Core.sendGroupMessages(selfQQ,fromGroup,"0：全图模式  1：区域模式",0);
					return;
				}
				Core.sendGroupMessages(selfQQ,fromGroup,"正在尝试获取数据~请稍后~",0);
				String base64 = Chart.chart(msg,1);
				if (base64.equals("?")){
					return;
				}
				String atqq = "[@"+fromQQ+"]来了来了~" + "\r";
				Core.sendGroupMessagesPicText(selfQQ,fromGroup,atqq + "[pic:"+base64+"]",0);
			}else if (msg.equals("水表功能")){
				Core.sendGroupMessages(selfQQ,fromGroup,"[pic,hash=B9433B085F1C592C29137BDE4FEAD556]",0);
			}else if (msg.equals("表单功能")){
				Core.sendGroupMessages(selfQQ,fromGroup,"[pic,hash=9640C8A87A25B56B6F0BC0C354BD3944]",0);
			}else if (msg.equals("wows功能")){
				Core.sendGroupMessages(selfQQ,fromGroup,"输入“水表功能”获取水表功能帮助！\r输入“表单功能”获取水表功能帮助！",0);
			}

		}catch (Exception e) {
			Core.sendGroupMessages(selfQQ,fromGroup,"查询用户不存在或网络超时，请重试。",0);
			Core.sendGroupMessages(selfQQ,fromGroup,"请选择正确的区服信息，具体格式请发送“wows功能”指令",0);
			System.out.println("[群聊数据异常]");
		}
		//134	上传群文件

	}

	/**
	 * 收到事件消息
	 * @param data
	 */
	public static void receiveEventMessages(String data){
		System.out.println("[收到事件消息]" + data);
		try{
			JSONObject json = JSONObject.parseObject(data);
			selfQQ = json.getInteger("selfQQ");//框架QQ
			fromGroup = json.getInteger("fromGroup");//群号
			int msgType = json.getInteger("msgType");//类型
			long triggerQQ = json.getInteger("triggerQQ");//对方QQ
			//String triggerQQName = json.getString("triggerQQName");//对方昵称
			long seq = json.getLongValue("seq");//操作用

			//32表示QQ上线
			//17表示好友更改昵称
			//25表示邀请加入了群聊
			if(msgType == 3){//群验证事件 申请入群
				Core.handleGroupEvent(selfQQ, fromGroup, triggerQQ, seq, 11, 3);
			}else if(msgType == 20){//申请加为好友
				Core.handlePrivateEvent(selfQQ, triggerQQ, seq, 1);
			}else if(msgType == 19){//有新好友
				Core.sendPrivateMessages(selfQQ, triggerQQ, "哈喽", 0, 0);
			}else if(msgType == 23){
				Core.callpPraise(selfQQ,triggerQQ,10);
			}
		}catch (Exception e) {
			System.out.println("[事件数据异常]");
		}

	}

	/**
	 * 收到查询返回
	 * @param data
	 */
	public static void selectResult(String data){
		System.out.println("[收到查询返回]" + data);
		JSONObject json = JSONObject.parseObject(data);
		//long selfQQ = json.getInteger("selfQQ");//框架QQ
		int msgType = json.getInteger("msgType");//类型
		if(msgType == 107){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[好友列表返回]" + list.size());
		}else if(msgType == 109){
			JSONObject userInfo = json.getJSONObject("info");
			System.out.println("[好友信息返回]" + JSONObject.toJSONString(userInfo));
		}else if(msgType == 212){
			JSONArray list = json.getJSONArray("list");
			System.out.println("[群聊列表返回]" + list.size());
		}else if(msgType == 213){
			JSONObject groupInfo = json.getJSONObject("info");
			System.out.println("[群聊信息返回]" + JSONObject.toJSONString(groupInfo));
		}else if(msgType == 302){
			String path = json.getString("path");
			System.out.println("[插件路径返回]" + path);
		}else if(msgType == 303){
			String picCode = json.getString("picCode");
			System.out.println("[上传图片返回]" + picCode);
		}else if(msgType == 304){
			String audioCode = json.getString("audioCode");
			System.out.println("[上传语音返回]" + audioCode);
			//处理异步
			long t = json.getLongValue("t");
			JSONObject jsonRes = StringUtils.queue.get(t);
			if(jsonRes.getBooleanValue("sync")){//同步发送
				long selfQQ = jsonRes.getLongValue("selfQQ");
				long fromQQ = jsonRes.getLongValue("fromQQ");
				if(jsonRes.getIntValue("msgType") == 1){//好友
					audioCode = audioCode.replace("voice_codec=0", "voice_codec=1");
					Core.sendPrivateMessages(selfQQ, fromQQ, audioCode, 0, 0);
				}else{//群聊

				}
			}


		}
	}
}
