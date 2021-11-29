public class Launcher {
    public static void main(String[] args) {
        java.util.Scanner entree =   new java.util.Scanner(System.in);
        System.out.println("Welcome!!");
        int nb = 0;
        int fibo = 0;
        String phrase = "";
        while(!phrase.equals("quit")) {
            if (phrase.equals("")){
                phrase = entree.nextLine();
            }else {
                if (phrase.equals("fibo")) {
                    System.out.println("Enter a number:");
                    nb = entree.nextInt();
                    entree.nextLine();
                    fibo = fib(nb);
                    System.out.println(fibo);
                    phrase = entree.nextLine();
                }else {
                    System.out.println("Unknown command");
                    phrase = entree.nextLine();
                }
            }
        }
    }
    private static int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
