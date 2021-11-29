public class Launcher {
    public static void main(String[] args) {
        java.util.Scanner entree =   new java.util.Scanner(System.in);
        System.out.println("Welcome!!");
        String phrase = entree.nextLine();
        while(!phrase.equals("quit")) {
            System.out.println("Unknown command");
            phrase = entree.nextLine();
        }
    }
}
