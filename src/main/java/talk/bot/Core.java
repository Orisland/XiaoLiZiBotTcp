package talk.bot;

import com.alibaba.fastjson.JSONObject;

/**
 * 核心操作类
 * @author zhaoqk
 *
 * 2020年8月10日 下午5:07:20
 */
public class Core {
	
	
	/**
	 * 发送私聊消息
	 * @param selfQQ	框架QQ
	 * @param fromQQ	好友QQ
	 * @param msg		发送的内容
	 * @param random	撤回消息用
	 * @param req		撤回消息用
	 */
	public static void sendPrivateMessages(long selfQQ,long fromQQ,String msg,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 101);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 发送私聊Json消息
	 * @param selfQQ	框架QQ
	 * @param fromQQ	好友QQ
	 * @param msg		发送的Json内容
	 * @param random	撤回消息用
	 * @param req		撤回消息用
	 */
	public static void sendPrivateMessagesJson(long selfQQ,long fromQQ,String msg,long random,int req){
		JSONObject json = new JSONObject();
		json.put("type", 102);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 发送私聊图文消息
	 * @param selfQQ
	 * @param fromQQ
	 * @param msg
	 * @param random
	 * @param req
	 */
	public static void sendPrivateMessagesPicText(long selfQQ,long fromQQ,String msg,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 103);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("req", req);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 处理好友验证事件
	 * @param selfQQ	框架QQ
	 * @param fromQQ	好友QQ
	 * @param seq		请求附带的seq
	 * @param status	是否同意 1同意 2拒绝
	 */
	public static void handlePrivateEvent(long selfQQ,long fromQQ,long seq,int status){
		JSONObject json = new JSONObject();
		json.put("type", 104);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("seq", seq);
		json.put("status", status);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * QQ点赞
	 * @param selfQQ	框架QQ
	 * @param fromQQ	好友QQ
	 */
	public static void callpPraise(long selfQQ,long fromQQ,long number){
		JSONObject json = new JSONObject();
		json.put("type", 105);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("number", number);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 发送好友红包
	 * @param selfQQ	框架QQ
	 * @param fromQQ	对方QQ
	 * @param number	红包数量
	 * @param balance	红包金额 分
	 * @param msg		祝福语
	 * @param payPwd	支付密码
	 */
	public static void pushRedPacket(long selfQQ,long fromQQ,long number,long balance,String msg,String payPwd){
		JSONObject json = new JSONObject();
		json.put("type", 106);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("number", number);
		json.put("balance", balance);
		json.put("payPwd", payPwd);
		json.put("msg", msg);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 获取好友列表
	 * @param selfQQ
	 */
	public static void friendsList(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 107);
		json.put("selfQQ", selfQQ);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 撤回私聊消息
	 * @param selfQQ
	 * @param fromQQ
	 * @param random
	 * @param req
	 * @param time
	 */
	public static void withdrawPrivateMessages(long selfQQ,long fromQQ,long random,long req,long time){
		JSONObject json = new JSONObject();
		json.put("type", 108);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		json.put("random", random);
		json.put("req", req);
		json.put("time", time);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 查询好友信息
	 * @param selfQQ
	 * @param fromQQ
	 */
	public static void selectFriendsInfo(long selfQQ,long fromQQ){
		JSONObject json = new JSONObject();
		json.put("type", 109);
		json.put("selfQQ", selfQQ);
		json.put("fromQQ", fromQQ);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}






	/**
	 * 发送群聊消息
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param msg		发送的内容
	 * @param anonymous	是否匿名 0否 1是
	 */
	public static void sendGroupMessages(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 201);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("msg", msg);
		json.put("anonymous", anonymous);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 发送群聊消息
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param msg		发送的Json内容
	 * @param anonymous	是否匿名 0否 1是
	 */
	public static void sendGroupMessagesJson(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 202);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("anonymous", anonymous);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 发送群图文消息
	 * @param selfQQ
	 * @param fromGroup
	 * @param msg
	 * @param anonymous
	 */
	public static void sendGroupMessagesPicText(long selfQQ,long fromGroup,String msg,int anonymous){
		JSONObject json = new JSONObject();
		json.put("type", 203);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("msg", msg);
		json.put("anonymous", anonymous);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 处理群验证事件
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param fromQQ	申请人QQ
	 * @param seq		请求附带的seq
	 * @param status	11同意 12拒绝  14忽略
	 * @param fromType	3某人申请加群 1我被邀请加入群
	 */
	public static void handleGroupEvent(long selfQQ,long fromGroup,long fromQQ,long seq,int status,int fromType){
		JSONObject json = new JSONObject();
		json.put("type", 204);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("seq", seq);
		json.put("status", status);
		json.put("fromType", fromType);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 设置群名片
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param fromQQ	对方QQ
	 * @param cardName	群名片
	 */
	public static void setGroupCardName(long selfQQ,long fromGroup,long fromQQ,String cardName){
		JSONObject json = new JSONObject();
		json.put("type", 205);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("cardName", cardName);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 删除群成员
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param fromQQ	对方QQ
	 * @param refuse	拒绝加群申请 0否 1是
	 */
	public static void delGroupMember(long selfQQ,long fromGroup,long fromQQ,int refuse){
		JSONObject json = new JSONObject();
		json.put("type", 206);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("refuse", refuse);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 群禁言
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param fromQQ	对方QQ
	 * @param second	时间 秒
	 */
	public static void prohibitSpeak(long selfQQ,long fromGroup,long fromQQ,int second){
		JSONObject json = new JSONObject();
		json.put("type", 207);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("second", second);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 撤回群消息
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param random	消息附带的random
	 * @param req		消息附带的req
	 */
	public static void withdrawGroupMessages(long selfQQ,long fromGroup,long random,long req){
		JSONObject json = new JSONObject();
		json.put("type", 208);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("random", random);
		json.put("req", req);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 发送群临时消息
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param fromQQ	对方QQ
	 * @param msg		发送的内容
	 * @param random	撤回消息用
	 * @param seq		撤回消息用
	 */
	public static void sendGroupTempMessages(long selfQQ,long fromGroup,long fromQQ,String msg,long random,long seq){
		JSONObject json = new JSONObject();
		json.put("type", 209);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("fromQQ", fromQQ);
		json.put("msg", msg);
		json.put("random", random);
		json.put("seq", seq);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 发送群聊红包
	 * @param selfQQ	框架QQ
	 * @param fromGroup	群号
	 * @param number	红包数量
	 * @param balance	红包金额  分
	 * @param msg		祝福语
	 * @param payPwd	支付密码
	 */
	public static void pushRedPacketGroup(long selfQQ,long fromGroup,long number,long balance,String msg,String payPwd){
		JSONObject json = new JSONObject();
		json.put("type", 210);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("number", number);
		json.put("balance", balance);
		json.put("payPwd", payPwd);
		json.put("msg", msg);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	/**
	 * 全员禁言
	 * @param selfQQ
	 * @param fromGroup
	 * @param isOpen 0关闭 1开启
	 */
	public static void prohibitSpeakAll(long selfQQ,long fromGroup,long isOpen){
		JSONObject json = new JSONObject();
		json.put("type", 211);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		json.put("isOpen", isOpen);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 获取群列表
	 * @param selfQQ
	 */
	public static void groupList(long selfQQ){
		JSONObject json = new JSONObject();
		json.put("type", 212);
		json.put("selfQQ", selfQQ);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 查询群信息
	 * @param selfQQ
	 * @param fromGroup
	 */
	public static void selectGroupInfo(long selfQQ,long fromGroup){
		JSONObject json = new JSONObject();
		json.put("type", 213);
		json.put("selfQQ", selfQQ);
		json.put("fromGroup", fromGroup);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 输出日志
	 * @param msg		日志内容
	 * @param fontColor	字体颜色
	 * @param bgColor	背景颜色
	 */
	public static void outputLog(String log,int fontColor,int bgColor){
		JSONObject json = new JSONObject();
		json.put("type", 301);
		json.put("log", log);
		json.put("fontColor", fontColor);
		json.put("bgColor", bgColor);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 查询插件数据目录
	 */
	public static void selectPluginPath(){
		JSONObject json = new JSONObject();
		json.put("type", 302);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}

	/**
	 * 上传图片
	 * @param selfQQ	框架QQ
	 * @param msgType	消息类型  1好友图片 2群聊图片
	 * @param fromGroup	上传好友图片时为好友QQ 上传群图片时为群号
	 * @param flash		是否闪照 0否 1是
	 * @param pic		图片Base64
	 */
	public static void uploadPic(long selfQQ,int msgType,long fromQQ,int flash,String pic){
		JSONObject json = new JSONObject();
		json.put("type", 303);
		json.put("selfQQ", selfQQ);
		json.put("msgType", msgType);
		json.put("fromQQ", fromQQ);
		json.put("flash", flash);
		json.put("pic", pic);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}


	/**
	 * 上传语音
	 * @param selfQQ	框架QQ
	 * @param msgType	消息类型  1好友语音 2群聊语音
	 * @param fromQQ	上传好友语音时为好友QQ 上传群语音时为群号
	 * @param path		语音路径
	 */
	public static void uploadAudioSync(long selfQQ,int msgType,long fromQQ,String path){
		JSONObject json = new JSONObject();
		json.put("type", 304);
		json.put("selfQQ", selfQQ);
		json.put("msgType", msgType);
		json.put("fromQQ", fromQQ);
		json.put("path", path);
		long t = StringUtils.getNum();
		json.put("t", t);
		json.put("sync", true);
		StringUtils.queue.put(t, json);
		talkMain.clientTest.sendMsg(json.toJSONString());
	}
	

}
