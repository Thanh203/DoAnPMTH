package com.example.doanpmth;

public class Book {
    private int id;
    private int categoryId;
    private String name;
    private String author;
    private String description;
    private int price;
    private String image1;
    private String image2;
    private String image3;

    public Book() {
    }

    public Book(int id, int categoryId, String name, String author, String description, int price, String image1, String image2, String image3) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
}
