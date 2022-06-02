package itmo.java.commands;


import itmo.java.IO.Printor;

public class ExitCommand implements Command {
    private final Printor printor;

    public ExitCommand(Printor printor) {
        this.printor = printor;
    }

    @Override
    public void execute() throws Exception {
        printor.println("Выполнение программы закончено ");
        System.exit(0);
    }
}
