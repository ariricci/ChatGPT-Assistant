package com.chatgpt.model;

/**
 * @Author: lifan
 * @Description:
 * @CreateTime: 2023/6/1
 */
public class SettingsRowModel {

    /**
     * 命令项
     **/
    private String label;

    /**
     * 命令值
     **/
    private String value;

    /**
     * 按钮名称
     **/
    private String btn;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }

    public SettingsRowModel() {

    }

    public SettingsRowModel(String item) {
        String[] split = item.split(",");
        this.label = split[0];
        this.value = split[1];
        this.btn = split[2];
    }
}
