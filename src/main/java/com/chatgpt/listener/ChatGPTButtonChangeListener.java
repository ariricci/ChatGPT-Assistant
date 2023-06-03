package com.chatgpt.listener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.chatgpt.toolwindow.ChatGPTWindow;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class ChatGPTButtonChangeListener implements ChangeListener {

    private final ChatGPTWindow window;

    public ChatGPTButtonChangeListener(ChatGPTWindow window) {
        this.window = window;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (StringUtils.isBlank(window.getAnwserTextArea().getText())) {
            window.getAnwserTextArea().setText("等待应答中...");
            return;
        }
    }
}
