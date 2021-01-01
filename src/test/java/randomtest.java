import java.util.Random;

public class randomtest {
    public static void main(String[] args) {
        int first =1;
        int second =2;
        Random random = new Random();
        for (int i=0; i<10; i++){
            System.out.println(random.nextInt(1));
//            System.out.println(random.nextInt((second-first))+first);
        }
    }
}
