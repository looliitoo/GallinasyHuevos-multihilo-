public class Buitre extends RobaHuevos implements Runnable{

    public Buitre(String nombre) {
        super(nombre);
        pesoMximo = 200;
    }

    @Override
    public void run() {
        try {
            robarHuevos();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
