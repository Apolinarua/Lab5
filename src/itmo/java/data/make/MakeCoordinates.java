package itmo.java.data.make;

import itmo.java.IO.Printor;
import itmo.java.IO.Scannie;
import itmo.java.data.Coordinates;

public class MakeCoordinates {
    private final Coordinates coordinates;
    private final boolean isConsole;

    public MakeCoordinates(boolean isConsole) {
        this.coordinates = new Coordinates();
        this.isConsole = isConsole;
    }

    public Coordinates make(Scannie scannie, Printor printor) throws Exception {
        makeX(scannie, printor);
        makeY(scannie, printor);
        return coordinates;
    }

    private void makeY(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите координату y");
            String y = scannie.scanString();
            try {
                coordinates.setY(Long.parseLong(y));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeY(scannie, printor);
            }
        } else {
            String y = scannie.scanString();
            coordinates.setY(Long.parseLong(y));
        }
    }


    private void makeX(Scannie scannie, Printor printor) throws Exception {
        if (isConsole) {
            printor.println("Введите координату x");
            String x = scannie.scanString();
            try {
                coordinates.setX(Float.parseFloat(x));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeX(scannie, printor);
            }
        } else {
            String x = scannie.scanString();
            coordinates.setX(Float.parseFloat(x));
        }

    }
}
