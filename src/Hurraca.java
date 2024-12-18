public class Hurraca extends RobaHuevos implements Runnable{


    public Hurraca(String nombre) {
        super(nombre);
        pesoMximo = 1;
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
