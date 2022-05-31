package data.make;

import data.Person;
import inter.Printor;
import inter.Scannie;

import java.io.IOException;
import java.time.ZonedDateTime;

public class makePerson {
    private final Person director;
    private final boolean isConsole;

    public makePerson(boolean isConsole) {
        this.director = new Person();
        this.isConsole = isConsole;
    }

    public Person make(Scannie scannie, Printor printor) throws Exception {
        makeName(scannie, printor);
        makeBirthday(scannie,printor);
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
}
