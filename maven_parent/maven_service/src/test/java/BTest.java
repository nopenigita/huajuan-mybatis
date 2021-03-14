import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

/**
 * @author : Hiccup
 * create at : 2021/1/5 11:10 下午
 * description :
 * remark :
 **/
public class BTest {

    @Test
    public void test2(){
        String s = "{\n" +
                "    \"status\": 0,\n" +
                "    \"result\": {\n" +
                "        \"location\": {\n" +
                "            \"areacode\": \"101091107\",\n" +
                "            \"name\": \"海港区\",\n" +
                "            \"country\": \"中国\",\n" +
                "            \"path\": \"海港区,秦皇岛市,河北省,中国\"\n" +
                "        },\n" +
                "        \"realtime\": {\n" +
                "            \"text\": \"晴\",\n" +
                "            \"code\": \"00\",\n" +
                "            \"temp\": 29.1,\n" +
                "            \"wind_class\": \"2级\",\n" +
                "            \"wind_dir\": \"西南风\"\n" +
                "        },\n" +
                "        \"last_update\": \"2020-06-19 11:26\"\n" +
                "    }\n" +
                "}\n";
        byte[] bytes = s.getBytes();
        System.out.println(bytes);
        System.out.println("---------------------------");
        String s1 = null;
        try {
            s1 = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println("---------------------------");
        JSONObject jsonObject1 = JSONObject.parseObject(s1);
        System.out.println(jsonObject1);
        System.out.println("---------------------------");
        System.out.println("---------------------------");
        JSONObject result = jsonObject1.getJSONObject("result");
        Set<Map.Entry<String, Object>> entries = result.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println("+++++++++++++++");
            System.out.println(entry.getValue());
            JSONObject json2 = new JSONObject();
            System.out.println("+++++++++++++++");
            String s2 = JSONObject.toJSONString(json2);
            System.out.println("正在解析:" + s2);
        }
        System.out.println(entries);

    }
}
