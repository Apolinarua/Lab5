package data.make;

import data.Coordinates;
import inter.Printor;
import inter.Scannie;

import java.io.IOException;

public class makeCoordinates {
    private final Coordinates coordinates;
    private final boolean isConsole;

    public makeCoordinates(Coordinates coordinates, boolean isConsole) {
        this.coordinates = coordinates;
        this.isConsole = isConsole;
    }
    public Coordinates make(Scannie scannie, Printor printor) throws Exception {
        makeX(scannie,printor);
        makeY(scannie,printor);
        return coordinates;
    }

    private void makeY(Scannie scannie, Printor printor) throws Exception {
        if(isConsole){
            printor.println("Введите координату y");
            String y = scannie.scanString();
            try {
                coordinates.setY(Long.valueOf(y));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeY(scannie, printor);
            }
        } else {
            String y = scannie.scanString();
            coordinates.setY(Long.valueOf(y));
        }
        }


    private void makeX(Scannie scannie, Printor printor) throws Exception {
        if(isConsole){
            printor.println("Введите координату x");
            String x = scannie.scanString();
            try {
                coordinates.setX(Float.valueOf(x));
            } catch (Exception e) {
                printor.println("Что-то не так: " + e.getMessage());
                makeY(scannie, printor);
            }
        } else {
            String x = scannie.scanString();
            coordinates.setX(Float.valueOf(x));
        }

    }
}
