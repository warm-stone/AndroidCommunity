package com.example.mycommunity.JsonEntity;

import org.litepal.crud.LitePalSupport;

public class UserInformation  extends LitePalSupport {
    private String username;
    private String password;
    private String phone;//手机号
    private String email;
    private String gender;
    private String idCard;
    private String birthday;
    private String profileImg;//头像地址
    private String motto;//个性签名

    public UserInformation(String userName, String passWord, String phone, String email, String gender, String idCard) {
        this.username = userName;
        this.password = passWord;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.idCard = idCard;
    }

    public UserInformation(String userName, String passWord,String phone){
        this.username = userName;
        this.password = passWord;
        this.phone = phone;
    }
    public UserInformation(String userName, String passWord){
        this.username = userName;
        this.password = passWord;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

}

