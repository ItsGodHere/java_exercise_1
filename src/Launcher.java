import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Launcher {
    public static void main(String[] args) {
        Scanner entree =   new Scanner(System.in);
        System.out.println("Welcome!!");
        System.out.println("Enter a command...");
        int nb;
        int fibo;
        String phrase = "";
        String u_path;
        while(!phrase.equals("quit")) {
            if (!phrase.equals("")) {
                if (phrase.equals("fibo")) {
                    System.out.println("Enter a number:");
                    nb = entree.nextInt();
                    entree.nextLine();
                    fibo = fib(nb);
                    System.out.println("result : " + fibo);
                    System.out.println("Enter a command...");
                } else {
                    if (phrase.equals("freq")) {
                        System.out.println("Enter a file path:");
                        u_path = entree.nextLine();
                        Path path = Paths.get(u_path);
                        try {
                            int i = 0;
                            String file = Files.readString(path);
                            file = file.toLowerCase();
                            file = file.replaceAll("[^a-z]", " ");
                            String[] word = file.split(" ");

                            Map<String, Long> result = Arrays.stream(word)
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                            Map<String, Long> finalMap = new LinkedHashMap<>();

                            result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                    .forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

                            for (Map.Entry mapentry : finalMap.entrySet()) {
                                if (!mapentry.getKey().equals("") && (i < 3)) {
                                    System.out.println(mapentry.getKey() + ":" + mapentry.getValue());
                                    i++;
                                }
                            }
                        } catch (IOException e) {
                            System.out.println("Unreadable file: ");
                            e.printStackTrace();
                        }
                        System.out.println("Enter a command...");
                    } else {
                        System.out.println("Unknown command");
                        System.out.println("Enter a new command...");
                    }
                }
            }
            phrase = entree.nextLine();
        }
    }
    private static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
