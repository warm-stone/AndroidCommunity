package com.example.mycommunity.jsonEntity;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

public class UserInformation  extends LitePalSupport implements Serializable {

    /*
    * nickname : 昵称（不可重复）
    * communityId : 社区id
    * username : 用户名（可重复）
    * avatar : 头像地址
    * motto : 个性签名
    * */
    private boolean me = false;
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
    /**
     * id : 51
     * idcard : 就是恰好的不解决
     * integral : 0
     * birthday : -28800000
     * signUp : 1553937229000
     */
    @SerializedName("id")
    private long idx;
    private long integral;
    private long signUp;

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

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public long getSignUp() {
        return signUp;
    }

    public void setSignUp(long signUp) {
        this.signUp = signUp;
    }

    public boolean isMe() {
        return me;
    }

    public void setMe(boolean me) {
        this.me = me;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }
}

