package talk;

import com.alibaba.fastjson.*;
import talk.DAO.manage;

import java.sql.SQLException;
import java.util.List;

public class Data {
    JSONArray jsonArray;
    public Data() throws SQLException {
        List<talk> talks = manage.all();
        jsonArray = new JSONArray();
        for (talk talk:talks){
            JSONObject object = new JSONObject();
            object.put("id", talk.getId());
            object.put("key", talk.getKey());
            object.put("value", talk.getValue());
            object.put("power", talk.getPower());
            object.put("from", talk.getFrom());

            jsonArray.add(object);
        }
    }

    public static void main(String[] args) throws SQLException {
        Data data = new Data();
        System.out.println(data.jsonArray.toString());
    }
}
