import java.util.Random;

public class IdGenerate {
    private static final Random random = new Random();

    public static Integer generateId() {
        Integer id = random.nextInt();
        return (id <= 0 ? generateId() : id);
    }
}
