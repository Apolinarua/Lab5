package commands;

import inter.Printor;

public class ExitCommand implements Command{
    private final Printor printor;

    public ExitCommand(Printor printor) {
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        printor.println("Программа того этого ");
        System.exit(0);
    }
}
