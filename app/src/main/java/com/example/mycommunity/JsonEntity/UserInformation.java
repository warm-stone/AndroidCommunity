package com.example.mycommunity.JsonEntity;

import org.litepal.crud.LitePalSupport;

public class UserInformation  extends LitePalSupport {

    /*
    * nickname : 昵称（不可重复）
    * communityId : 社区id
    * username : 用户名（可重复）
    * avatar : 头像地址
    * motto : 个性签名
    * */
    private String nickname;
    private String password;
    private String phone;
    private int communityId;
    private String communityName;
    private String username;
    private String avatar;
    private String gender;
    private String idCard;
    private long birthday;
    private String motto;
    private String email;
    private String Authorization;

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

    public UserInformation() {
    }

    public UserInformation(String nickname, String passWord, String phone, String email, String gender, String idCard) {
        this.nickname = nickname;
        this.password = passWord;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.idCard = idCard;
    }

    public UserInformation(String nickname, String passWord,String phone){
        this.nickname = nickname;
        this.password = passWord;
        this.phone = phone;
    }
    public UserInformation(String nickname, String passWord){
        this.nickname = nickname;
        this.password = passWord;
    }
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

}

