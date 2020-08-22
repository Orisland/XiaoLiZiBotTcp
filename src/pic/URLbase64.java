package pic;

import com.sun.jndi.toolkit.url.Uri;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class URLbase64 {
    public static String image2Base64(URL url) throws Exception{            //url图片转base64
        System.out.println("图片路径:"+url.toString());
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5*1000);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            InputStream inputStream = conn.getInputStream();
            System.out.println(1);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len =0;
            while ((len = inputStream.read(buffer))!=-1){
                outputStream.write(buffer, 0,len);
            }
            System.out.println(2);
            inputStream.close();
            byte[] date = outputStream.toByteArray();
            Base64.Encoder encoder = Base64.getEncoder();
            String base64 = encoder.encodeToString(date);
            System.out.println(3);
            return base64;
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new Exception("没找到文件");
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("图片上传失败");
        }
    }

    public static void main(String[] args) throws Exception {

        //String str = image2Base64(new URL("https://i.pixiv.cat/img-original/img/2016/11/03/10/18/38/59774743_p0.jpg"));
        //System.out.println(str);
    }
}
