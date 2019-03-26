package com.example.mycommunity.JsonEntity;

public class Data {

    /*
     * id : 社区id
     * name : 社区名称
     * address : 社区地址
     * admin : 社区管理员
     * nickname : Leona
     * signUp : 1552879612505
     * error : 用户已存在,注册失败
     * */

    private int id;
    private String name;
    private String address;
    private String admin;
    private String username;
    private String ExceptionMsg;
    private String message;
    private String gender;
    private String profileImg;
    private String motto;
    private String email;
    private String integral;
    private String token;
    private String nickname;
    private long signUp;
    private String error;
    private String Authorization;

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExceptionMsg() {
        return ExceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        ExceptionMsg = exceptionMsg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getSignUp() {
        return signUp;
    }

    public void setSignUp(long signUp) {
        this.signUp = signUp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}