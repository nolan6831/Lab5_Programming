package client;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import java.io.IOException;

public class ConsoleReader {

    private LineReader reader;
    private Terminal terminal;

    public ConsoleReader() {
        try {
            terminal = TerminalBuilder.terminal();
            reader = LineReaderBuilder.builder().terminal(terminal).build();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    terminal.close();
                } catch (Exception e) {}
            }));
        } catch (IOException e) {
            throw new RuntimeException("Не удалось инициализировать терминал", e);
        }
    }

    public String readLine(String prompt) {
        try {
            String line = reader.readLine(prompt);
            if (line == null) {
                return "";
            }
            return line;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}