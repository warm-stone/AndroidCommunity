package com.example.mycommunity.jsonEntity;

public class PostMsg {

    /**
     * nickname : Leona 用户昵称(昵称不可重复)
     * password : 62952019 密码
     * phone : 17864195000 电话号码
     * communityId : 1 社区id
     */

    private String nickname;
    private String password;
    private String phone;
    private int communityId;

    public PostMsg(String nickname, String password, String phone, int communityId) {
        this.nickname = nickname;
        this.password = password;
        this.phone = phone;
        this.communityId = communityId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }
}
