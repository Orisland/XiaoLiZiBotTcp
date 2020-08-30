package NvZhuang;

public class Jiaoge {
    public static void main(String[] args) {
        final long time = 14400;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("start");
                    try {
                        Thread.sleep(time);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.run();
    }
}
