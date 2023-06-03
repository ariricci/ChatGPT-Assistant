package com.chatgpt.listener;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chatgpt.toolwindow.ChatGPTWindow;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class ChatGPTButtonActionListener extends AbstractAction {

    /**
     * 使用的模型
     */
    private String model = "gpt-3.5-turbo";
    /**
     * 对应的请求接口
     */
    private String url = "http://49.235.247.108/v1/chat/completions";
    /**
     * 默认编码
     */
    private Charset charset = StandardCharsets.UTF_8;
    /**
     * 相应超时时间，毫秒
     */
    private int responseTimeout = 1000;

    public void setResponseTimeout(int responseTimeout) {
        this.responseTimeout = responseTimeout;
    }

    private final ChatGPTWindow window;

    public ChatGPTButtonActionListener(ChatGPTWindow window) {
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取输入框内容
        String originalText = window.getOriginalTextArea().getText();
        String url = "http://49.235.247.108/v1/chat/completions";
        String requestBody = "";
        try {
            // 创建URL对象
            URL obj = new URL(url);
            // 创建HttpURLConnection对象
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setConnectTimeout(5000); // 设置连接超时时间为 5 秒
            con.setReadTimeout(60000); // 设置读取超时时间为 30 秒
            // 设置请求方法为POST
            con.setRequestMethod("POST");

            // 设置请求头
            con.setRequestProperty("Content-Type", "application/json;utf-8");
            // 设置登录凭证
            //con.setRequestProperty("Authorization", "");
            // 构造请求体
            String model = "gpt-3.5-turbo"; // 模型名称
            String messages = "[{\"role\":\"user\",\"content\":\"" + StringEscapeUtils.escapeJson(originalText) + "\"}]"; // 问题信息
            requestBody = "{\"model\": \"" + model + "\", \"messages\": " + messages + "}";

            // 启用输出流
            con.setDoOutput(true);
            // 获取输出流
            OutputStream os = con.getOutputStream();
            // 发送请求数据
            try (DataOutputStream writer = new DataOutputStream(con.getOutputStream())) {
                writer.write(requestBody.getBytes(StandardCharsets.UTF_8));
                writer.flush();
            }
            os.close();

            // 获取响应码
            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            // 读取响应内容
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.printf(response.toString());
            JSONObject json = JSON.parseObject(response.toString());
            JSONArray choicesArray = json.getJSONArray("choices");
            String content = null;
            if (choicesArray.size() > 0) {
                JSONObject messageObj = choicesArray.getJSONObject(0).getJSONObject("message");
                content = messageObj.getString("content");
                System.out.println(content);
            }
            // 返回信息
            window.getAnwserTextArea().setText(content);
        } catch (IOException exception) {
            exception.printStackTrace();
            window.getAnwserTextArea().setText(exception.getMessage() + "/n请求参数" + requestBody);
        }
        // window.getAnwserTextArea().setText("您当前的网络无法访问");
    }


    private static String unicodeToChinese(String unicode) {
        StringBuffer chinese = new StringBuffer();
        String[] unicodeArray = unicode.split("\\\\u");

        for (int i = 1; i < unicodeArray.length; i++) {
            int value = Integer.parseInt(unicodeArray[i], 16);
            chinese.append((char) value);
        }

        return chinese.toString();
    }

}
