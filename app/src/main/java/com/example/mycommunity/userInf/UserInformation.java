package com.example.mycommunity.userInf;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

import java.util.Objects;

public class UserInformation extends LitePalSupport {

    /**
     * id : 45
     * username : 黄翔
     * nickname : Hans20
     * idcard : 372330199706111111
     * integral : 0
     * gender :
     * avatar : http://www.baidu.com
     * motto : 解决一个计算机问题的方法就是恰好的不解决
     * email : beautifulsoup@163.com
     * phone : 17864195000
     * communityId : 1
     * signUp : 1553928538000
     */

    @SerializedName("id")
    private long idx;
    private String username;
    private String nickname;
    private String idcard;
    private long integral;
    private String gender;
    private String avatar;
    private String motto;
    private String email;
    private String phone;
    private long communityId;
    private long signUp;

    public long getIdx() {
        return idx;
    }

    public void setIdx(long idx) {
        this.idx = idx;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public long getIntegral() {
        return integral;
    }

    public void setIntegral(long integral) {
        this.integral = integral;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(long communityId) {
        this.communityId = communityId;
    }

    public long getSignUp() {
        return signUp;
    }

    public void setSignUp(long signUp) {
        this.signUp = signUp;
    }

    public void updateTo(UserInformation information) {
        this.idx = information.idx;
        this.username = information.username;
        this.nickname = information.nickname;
        this.idcard = information.idcard;
        this.integral = information.integral;
        this.gender = information.gender;
        this.avatar = information.avatar;
        this.motto = information.motto;
        this.email = information.email;
        this.phone = information.phone;
        this.communityId = information.communityId;
        this.signUp = information.signUp;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInformation that = (UserInformation) o;
        return idx == that.idx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx);
    }
}
