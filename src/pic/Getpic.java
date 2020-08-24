package pic;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.*;

public class Getpic {
    
    public static pic[] doGet(int num) {
        String path = "https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true&num=";
        path = path+num;
        OutputStream out = null;
        BufferedReader br = null;
        String result = "";
        pic[] pic = new pic[num];
        JSONObject obj1 = null;
        try {
            System.out.println("准备开始");
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            System.out.println("来了来了");

            InputStream is = conn.getInputStream();
            System.out.println("获取输入流完成");
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            System.out.println("开始写入json");
            JSONObject obj = JSON.parseObject(br.readLine());
            JSONArray jsonArray = JSONArray.parseArray(obj.getString("data"));
            for (int i=0; i<pic.length; i++){
                obj1 = jsonArray.getJSONObject(i);
                pic[i] = JSONObject.parseObject(String.valueOf(obj1),pic.class);
            }

//            for (Map.Entry<String, Object> entry : json.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pic;
    }
    public static pic doGet(String path, String date){
        OutputStream out = null;
        BufferedReader br = null;
        String result = "";
        pic pic = null;
        try {
            System.out.println("准备开始1");
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10*1000);
            conn.setReadTimeout(10*1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            System.out.println("来了来了2");

            InputStream is = conn.getInputStream();
            System.out.println("获取输入流完成3");
            br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            System.out.println("开始写入json4");
            JSONObject obj = JSON.parseObject(br.readLine());
            JSONArray jsonArray = JSONArray.parseArray(obj.getString("data"));
            JSONObject obj1 = jsonArray.getJSONObject(0);
            pic = JSONObject.parseObject(String.valueOf(obj1),pic.class);
            System.out.println("完成5");

//            System.out.println("开始转换base64");
//            result = URLbase64.image2Base64(new URL(pic.getUrl()));
//            System.out.println("base64转化完成");
//            pic.base64 = result;

//            for (Map.Entry<String, Object> entry : json.entrySet()) {
//                System.out.println(entry.getKey() + ":" + entry.getValue());
//            }
            is.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (out != null){
                    out.close();
                }
                if (br != null){
                    br.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return pic;
    }

    public static void main(String[] args) {
            //pic pic = doGet("https://api.lolicon.app/setu/?apikey=232368045f2bc262c4e5e4&size1200=true&num=10", "");
            //pic[] pic = test(2);
        //System.out.println(pic);
            //System.out.println(pic);
//        //JSONObject jsonObject = JSON.parseObject("{\"p\":0,\"uid\":19880053,\"author\":\"れいなま\",\"r18\":false,\"width\":1068,\"pid\":77607987,\"title\":\"少女\",\"url\":\"https://i.pixiv.cat/img-original/img/2019/11/02/11/18/06/77607987_p0.png\",\"height\":1500,\"tags\":[\"オリジナル\",\"原创\",\"女の子\",\"女孩子\",\"金髪碧眼\",\"金发碧眼\",\"おへそ\",\"肚脐\",\"黒下着\",\"黑色内衣\",\"仰臥\",\"仰卧\",\"はだけ\",\"barely clothed\",\"おっぱい\",\"欧派\",\"半脱ぎ\",\"脱到一半\"]}");
//        String string = "{\"msg\":\"\",\"code\":0,\"data\":[{\"p\":0,\"uid\":3115085,\"author\":\"夏奈なつ?\",\"r18\":false,\"width\":1118,\"pid\":68146809,\"title\":\"ビーストバージョン☆イリヤ\",\"url\":\"https://i.pixiv.cat/img-original/img/2018/04/09/00/31/37/68146809_p0.jpg\",\"height\":1500,\"tags\":[\"プリズマ☆イリヤ\",\"魔法少女☆伊莉雅\",\"イリヤスフィール?フォン?アインツベルン\",\"伊莉雅丝菲尔?冯?爱因兹贝伦\",\"Fate/GrandOrder\",\"FGO\",\"リボン縛り\",\"開脚\",\"开腿\",\"魅惑のふともも\",\"魅惑的大腿\"]}],\"quota\":277,\"count\":1,\"quota_min_ttl\":76540}";
//        JSONObject obj = JSON.parseObject(string);
    }


}
