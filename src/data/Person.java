package data;

import java.time.ZonedDateTime;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.ZonedDateTime birthday; //Поле может быть null
    private double height; //Значение поля должно быть больше 0
    private String passportID; //Значение этого поля должно быть уникальным, Поле не может быть null
    private Color eyeColor; //Поле не может быть null

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null) {
            throw new Exception("Поле name не может быть null");
        } else if (name.isEmpty()) {
            throw new Exception("Поле name должно быть заполнено");
        }
        this.name = name;
    }

    public java.time.ZonedDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(ZonedDateTime birthday) throws Exception {
        if (birthday == null) {
            throw new Exception("Поле birthday не может быть null");
        }
        this.birthday = birthday;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws Exception {
        if (height <= 0) {
            throw new Exception("Поле height должно быть больше нуля");
        }
        this.height = height;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) throws Exception {
        if (passportID == null) {
            throw new Exception("Поле passportID не может быть null");
        }
        this.passportID = passportID;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) throws Exception {
        if (eyeColor == null) {
            throw new Exception("Поле eyeColor не может быть null");
        }
        this.eyeColor = eyeColor;
    }

    public Person(String name, java.time.ZonedDateTime birthday, double height, String passportID, Color eyeColor) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", height=" + height +
                ", passportID='" + passportID + '\'' +
                ", eyeColor=" + eyeColor +
                '}';
    }


}
