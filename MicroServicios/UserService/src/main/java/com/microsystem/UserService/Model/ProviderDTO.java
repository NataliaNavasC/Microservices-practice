package com.microsystem.UserService.Model;

public class ProviderDTO {
    private String username;
    private String name;
    private int age;
    private String photo;
    private String phoneNumber;
    private String webPage;
    private String socialNetwork;
    private String description;

    public ProviderDTO() {
    }


    public ProviderDTO(String username, String name, int age, String photo, String phoneNumber, String webPage,
            String socialNetwork, String description) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.phoneNumber = phoneNumber;
        this.webPage = webPage;
        this.socialNetwork = socialNetwork;
        this.description = description;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    
}
