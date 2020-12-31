import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.openqa.selenium.json.Json;

public class jsontest {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();
        jsonObject.put("fromgroup",123456789);
        jsonObject.put("mode",1);
        jsonObject.put("onff",true);

        jsonObject1.put("fromgroup",123456789);
        jsonObject1.put("mode",1);
        jsonObject1.put("onff",true);

        jsonObject2.put("fromgroup",123456789);
        jsonObject2.put("mode",1);
        jsonObject2.put("onff",true);

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject2);

        System.out.println(jsonArray.toString());
    }
}
