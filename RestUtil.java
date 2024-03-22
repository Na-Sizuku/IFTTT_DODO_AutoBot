import java.io.*;
import java.net.*;
import java.util.Date;

public class RestUtil {
    // post
    public void postMethod(String url, String query) throws IOException {
        URL restURL = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bot <BOT ID>.<Bot Token>");
        conn.setDoOutput(true);
        PrintStream ps = new PrintStream(conn.getOutputStream());
        ps.print(query);
        ps.close();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public static void main(String[] args) {
        RestUtil restUtil = new RestUtil();
        try {
            String url = "https://botopen.imdodo.com/api/v2/channel/message/send";// V2 API 
            //String url = "https://botopen.imdodo.com/api/v1/channel/message/send";// V1 API
            String query = "{\"channelId\":\"135061\",\"messageType\":\"6\",\"messageBody\":{\"card\":{\"type\":\"card\",\"theme\":\"blue\",\"title\":\"标题\",\"components\":[{\"type\":\"section\",\"text\":{\"type\":\"dodo-md\",\"content\":\"第一条内容\"}},{\"type\":\"section\",\"text\":{\"type\":\"dodo-md\",\"content\":\"第二条内容\"}},]}}}"; // json格式
            restUtil.postMethod(url, query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
