import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

public class Huevera {

    public static Stack<Huevo> huevera = new Stack<Huevo>();

    public static ReentrantLock lock = new ReentrantLock();

    public static boolean meterHuevo(Huevo huevo){
        boolean entraHuevo = false;
        lock.lock();
        if (huevera.size()<12){
            huevera.push(huevo);
            System.out.println("$Soy la "+huevo.getNombre()+" con peso "+huevo.getPeso()+" gr");
            entraHuevo = true;
        }
        lock.unlock();
       return entraHuevo;
    }

    public static Huevo sacarHuevo(){
        lock.lock();
        Huevo huevo = null;
        if (!huevera.isEmpty()){
            huevo = huevera.pop();
        }
        lock.unlock();
        return huevo;
    }

}
