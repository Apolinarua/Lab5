package data.make;

import data.Color;
import data.Person;
import IO.Printor;
import IO.Scannie;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Locale;

public class MakePerson {
    private final Person director;
    private final boolean isConsole;

    public MakePerson(boolean isConsole) {
        this.director = new Person();
        this.isConsole = isConsole;
    }

    public Person make(Scannie scannie, Printor printor) throws Exception {
        makeName(scannie, printor);
        makeBirthday(scannie, printor);
        makeHeight(scannie, printor);
        makePassportID(scannie, printor);
        makeEyeColour(scannie, printor);
        return director;
    }

    private void makeBirthday(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите день рождения режиссера (yyyy-mm-dd): ");
            String birthday = scannie.scanString();
            if (birthday.isEmpty()) {
                director.setBirthday(null);
            }
            try {
                director.setBirthday(ZonedDateTime.parse(birthday));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeBirthday(scannie, printor);
            }
        } else {
            String birthday = scannie.scanString();
            if (birthday.isEmpty()) {
                director.setBirthday(null);
            }
            director.setBirthday(ZonedDateTime.parse(birthday));
        }
    }

    private void makeName(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите имя режиссера: ");
            String name = scannie.scanString();
            try {
                director.setName(name);
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeName(scannie, printor);
            }
        } else {
            String name = scannie.scanString();
            if (name.equals("")) {
                throw new Exception();
            }
            director.setName(name);
        }

    }

    private void makeHeight(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите рост режиссера: ");
            double height = Double.parseDouble(scannie.scanString());
            try {
                director.setHeight(height);
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeHeight(scannie, printor);
            }
        } else {
            String height = scannie.scanString();
            director.setHeight(Double.parseDouble(height));
        }
    }

    private void makePassportID(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите id пасспорта: ");
            String passportid = scannie.scanString();
            try {
                director.setPassportID(passportid);
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makePassportID(scannie, printor);
            }
        } else {
            String passportid = scannie.scanString();
            director.setPassportID(passportid);
        }
    }

    private void makeEyeColour(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите цвет глаз: " + Arrays.toString(Color.values()));
            String eyecolour = scannie.scanString();
            try {
                director.setEyeColor(Color.valueOf(eyecolour.trim().toUpperCase(Locale.ROOT)));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeEyeColour(scannie, printor);
            }
        } else {
            String eyecolour = scannie.scanString();
            director.setEyeColor(Color.valueOf(eyecolour.trim().toUpperCase(Locale.ROOT)));
        }
    }


}
