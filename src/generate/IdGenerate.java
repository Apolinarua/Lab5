package generate;

import java.util.Random;

public class IdGenerate {
    private static final Random random = new Random();

    public static long generateId() {
        long id = random.nextLong();
        return (id <= 0 ? generateId() : id);
    }
}
