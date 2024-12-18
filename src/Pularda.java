public class Pularda extends PoneHuevo implements Runnable{

    public Pularda(String nombre) {
        super(nombre);
        pesoHuevoMax = 80;
        pesoHuevoMin = 40;
        tiempoEspera = 2000;
    }
    int peso;

    @Override
    public void run() {
        try {
            ponerHuevo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

