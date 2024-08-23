package model;

import interfaces.DataTransferObject;

import java.sql.Blob;

public class Title implements DataTransferObject {

    private int titleId;
    private String title;
    private int year;
    private double price;
    private String URL;
    private String image;

    public Title(int titleId, String title, int year, double price, String URL, String image) {
        this.titleId = titleId;
        this.title = title;
        this.year = year;
        this.price = price;
        this.URL = URL;
        this.image = image;
    }

    public Title() {
    }



    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getURL() {
        return URL;
    }

    public String getImage() {
        return image;
    }

    @Override
    public int getId() {
        return this.titleId;
    }

    @Override
    public String toString() {
        return "Title{" +
                "titleId=" + titleId +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", URL='" + URL + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
