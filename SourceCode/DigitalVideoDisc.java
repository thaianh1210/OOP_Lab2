/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class DigitalVideoDisc {
    // Class attribute (biến thành viên lớp) (Lab03 Bài 5)
    private static int nbDigitalVideoDiscs = 0;

<<<<<<< HEAD
=======
    // Instance attributes (biến thành viên đối tượng)
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id; // Instance attribute to hold unique ID

    // Constructor method
>>>>>>> topic/class-member
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
<<<<<<< HEAD
=======
        assignId(); // Assign a unique ID
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        assignId(); // Assign a unique ID
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        assignId(); // Assign a unique ID
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        assignId(); // Assign a unique ID
    }

    // Method to assign a unique ID to the DVD
    private void assignId() {
        nbDigitalVideoDiscs++; // Increment the static counter
        this.id = nbDigitalVideoDiscs; // Assign the current count as the ID
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
>>>>>>> topic/class-member
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
    }


public String getTitle() {
    return title;
}

public String getCategory() {
    return category;
}

public String getDirector() {
    return director;
}

public int getLength() {
    return length;
}

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(double cost) {
        this.cost = (float) cost;
    }
}