public class Gallina extends PoneHuevo implements Runnable{

    public Gallina(String nombre) {
        super(nombre);
        pesoHuevoMax = 50;
        pesoHuevoMin = 25;
        tiempoEspera = 1000;

    }
    @Override
    public void run() {
        try {
            ponerHuevo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
