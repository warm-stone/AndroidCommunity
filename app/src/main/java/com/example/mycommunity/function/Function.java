package com.example.mycommunity.function;

public class Function {
    private int functionImgId;
    private String functionText;

    public Function(int imgId, String functionText) {
        this.functionImgId = imgId;
        this.functionText = functionText;
    }

    public int getImgId() {
        return functionImgId;
    }

    public String getFunctionText() {
        return functionText;
    }

}
