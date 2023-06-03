package com.chatgpt.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class SelectTextAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        Editor editor = event.getData(CommonDataKeys.EDITOR);
        String text = editor.getSelectionModel().getSelectedText();
        System.out.println("actionPerformed>>>:" + text);

    }
}
