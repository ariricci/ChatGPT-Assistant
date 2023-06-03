package com.chatgpt.listener;

import java.awt.event.ActionEvent;

import javax.swing.*;

import com.chatgpt.config.ChatGPTConfig;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class ToolsSettingActionListener extends AbstractAction {

    private final JTextField textField;

    private final ChatGPTConfig config;

    public ToolsSettingActionListener(JTextField textField, ChatGPTConfig config) {
        this.textField = textField;
        this.config = config;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // btn name
        String actionCommand = e.getActionCommand();
        textField.setText("");
        this.config.apply();
    }
}
