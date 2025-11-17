package Main;

public class BelajarLooping {
    
    static void For() {
        int i = 1;
        for (; i <= 5; i++) {
            System.out.println("A");
        }
    }    
    
    static void While() {
        int i = 1;
        while (i <= 5) {
            System.out.print("A");
            i++;
        }
    }
    
    static void DoWhile() {
        int i = 1;
        do {
            System.out.println("A");
            i++;
        } while (i <= 5);
    }
        
    public static void main(String[] args) {
        For();
        While();
        DoWhile();
    }
}