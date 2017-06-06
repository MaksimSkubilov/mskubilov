package mskubilov.synch;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * //курс Петра Арсентьева job4j.ru.
 *
 * @author Maksim Skubilov skubilov89@yandex.ru
 * @version 1.0
 * @since 05.06.17
 */
public class StartSearcher {

    /**
     * Scanner for directory and text.
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * If true then process stops when found first match.
     */
    private AtomicBoolean stop;

    /**
     * @param dir some directory.
     * @return true of dir exists else false.
     */
    public boolean checkDir(String dir) {
        return new File(dir).isDirectory();
    }

    /**
     * Start searcher.
     */
    public void start() {
        System.out.print("Enter search directory or \"0\" for global search: ");
        String dir = scanner.nextLine();
        if (!dir.equals("0")) {
            while (!checkDir(dir) & !dir.equals("0")) {
                System.out.print("Such dir does not exist! Please re-enter: ");
                dir = scanner.nextLine();
            }
        }
        Searcher searcher = new Searcher(dir);
        Thread t = searcher.startSearching();
        System.out.print("Choose search type. For stop searching if one match found type \"0\": ");
        String toStop = scanner.nextLine();
        if (toStop.equals("0")) {
            searcher.setStopperTrue();
        }
        System.out.print("Type search text:");
        String text = scanner.nextLine();
        searcher.setText(text);
        searcher.awaitResults(t);

    }

    /**
     * Main method.
     * @param args args.
     */
    public static void main(String[] args) {
        StartSearcher searcher = new StartSearcher();
        searcher.start();
    }
}
