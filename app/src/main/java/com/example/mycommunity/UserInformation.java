package com.example.mycommunity;

import org.litepal.crud.LitePalSupport;

public class UserInformation  extends LitePalSupport {
    private String userName;
    private String passWord;
    private String phone;//手机号
    private String email;
    private String gender;
    private String idCard;
    private String birthday;
    private String profileImg;//头像地址
    private String motto;//个性签名

    public UserInformation(String userName, String passWord, String phone, String email, String gender, String idCard) {
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.idCard = idCard;
    }

    public UserInformation(String userName, String passWord,String phone){
        this.userName = userName;
        this.passWord = passWord;
        this.phone = phone;
    }
    public UserInformation(String userName, String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getMotto() {
        return motto;
    }
}

