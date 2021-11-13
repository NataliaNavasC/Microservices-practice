package com.microsystem.ProviderService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Provider {
    @Id
    @GeneratedValue
    private int id_Provider;
    private String name;
    @Column(unique = true)
    private String username;
    private int age;
    private String photo;
    private String description;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String webPage;
    private String socialNetwork;

    public Provider(){

    }

    public Provider(String name, String username, int age, String photo,
                    String description,
                    String phoneNumber, String webPage, String socialNetwork) throws Exception {
        if(name.length()<1 | name.length()>50){
            throw  new Exception("Name is empty or it's length is more than 50 characters");
        }
        if(username.length()<1 || username.length()>20){
            throw  new Exception("UserName is empty or it's length is more than 20 characters");
        }
        if(photo == null){
            throw  new Exception("There is no photo");
        }
        if(description.length()<1 || description.length()>50){
            throw  new Exception("Description is empty or it's length is more than 50 characters");
        }
        if(phoneNumber.length()<1||phoneNumber.length()>10){
            throw  new Exception("Phone number is empty or it's length is more than 10 characters");
        }
        this.name = name;
        this.username = username;
        this.age = age;
        this.photo = photo;
        this.description =description;
        this.phoneNumber = phoneNumber;
        this.webPage = webPage;
        this.socialNetwork = socialNetwork;
    }

    public void updateProvider(String name, int age, String photo,
                               String description,
                               String phoneNumber, String webPage, String socialNetwork){
        if(!this.name.equals(name) && name!=null){
            this.name = name;
        }
        if(this.age!=age && age!=0){
            this.age = age;
        }
        if(!this.photo.equals(photo) && photo!=null){
            this.photo =  photo;
        }
        if(!this.description.equals(description) && description!=null){
            this.description = description;
        }
        if(!this.phoneNumber.equals(phoneNumber) && phoneNumber!=null){
            this.phoneNumber = phoneNumber;
        }
        if(!this.webPage.equals(webPage) && webPage!=null){
            this.webPage = webPage;
        }
        if(!this.socialNetwork.equals(socialNetwork) && webPage!=null){
            this.socialNetwork = socialNetwork;
        }
    }
    public int getID() {
        return id_Provider;
    }

    public void setID(int ID) {
        this.id_Provider = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
