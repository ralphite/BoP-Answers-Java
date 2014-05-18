//bop 1.1

public class Main extends Thread{
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        for(int i = 0; i < processors; i++) {
            new Main().start();
        }
    }

    public void run() {
        this.sinCpu(30);
    }

    private void sinCpu(int len) {
        while (true) {
            for (int i = 0; i < 2 * len; i++) {
                int percent = (int) (50 * Math.sin(Math.PI * i / len) + 50);
                occupy(percent);
            }
        }
    }

    private void occupy(int percent) {
        for (int i = 0; i < 10; i++) {
            sleep(100 - percent);
            stress(percent);
        }
    }

    private void sleep(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            ;
        }
    }

    private void stress(int n) {
        long t = System.currentTimeMillis();
        int v = 37;
        while (System.currentTimeMillis() < t + n) {
            v *= 17;
        }
    }
}
