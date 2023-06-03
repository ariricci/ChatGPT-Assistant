package com.chatgpt.toolwindow;

import javax.swing.*;

import com.chatgpt.listener.ChatGPTButtonActionListener;
import com.chatgpt.listener.ChatGPTButtonChangeListener;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class ChatGPTWindow {
    private JTabbedPane tabbedPane1;
    private JPanel mainPanel;
    private JPanel translatorPanel;
    private JComboBox<String> comboBox1;
    private JTextArea originalTextArea;
    private JComboBox<String> comboBox2;
    private JButton submitButton;
    private JTextArea anwserTextArea;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JLabel ask;
    private JLabel anwser;

    public ChatGPTWindow() {
        // 添加按钮监听器
        submitButton.addActionListener(new ChatGPTButtonActionListener(this));
        submitButton.addChangeListener(new ChatGPTButtonChangeListener(this));
    }

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getTranslatorPanel() {
        return translatorPanel;
    }

    public JComboBox<String> getComboBox1() {
        return comboBox1;
    }

    public JTextArea getOriginalTextArea() {
        return originalTextArea;
    }

    public JComboBox<String> getComboBox2() {
        return comboBox2;
    }

    public JButton getTranslateButton() {
        return submitButton;
    }

    public JTextArea getAnwserTextArea() {
        return anwserTextArea;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

}
