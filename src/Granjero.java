import java.util.concurrent.locks.ReentrantLock;

public class Granjero extends Thread{

    public static boolean estaDormido;

    public static ReentrantLock lock;

    public Granjero(){
        lock  = new ReentrantLock();
        estaDormido = true;
    }

    public void run(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock.lock();

        estaDormido = false;
        System.out.println("Fuera de aqui bicharracos");
        lock.unlock();
    }
}
