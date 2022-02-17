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
        conn.setRequestProperty("Authorization", "Bot <你的BOTID>.<你的BOT Token>");
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
            String url = "https://botopen.imdodo.com/api/v1/channel/message/send";// 你需要测试的API地址
            String query = "{channelId:135061,messageType:1,messageBody:{content:'test'}}"; // json格式
            restUtil.postMethod(url, query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
