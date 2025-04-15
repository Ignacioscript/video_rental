package model;

import interfaces.DataTransferObject;
import util.ConsoleColor;

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
        StringBuilder sb = new StringBuilder();
        return sb.append("TITLE:")
                .append("\n \t\t")
                .append(ConsoleColor.BLUE_BOLD)
                .append("TITLE ID: ").append(getId())
                .append(" -TITLE: ").append(getTitle().toString())
                .append(" -YEAR: ").append(getYear())
                .append(" -PRICE: ").append(getPrice())
                .append(" -URL: ").append(getURL())
                .append("\033[0m")
                .append("\n")
                .toString();
    }


}
