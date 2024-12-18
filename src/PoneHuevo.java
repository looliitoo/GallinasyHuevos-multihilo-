public class PoneHuevo {
    String nombre;
    int pesoHuevoMax;
    int pesoHuevoMin;
    int tiempoEspera;

    public PoneHuevo(String nombre) {
        this.nombre = nombre;
    }

    public void ponerHuevo() throws InterruptedException {
        Huevo huevo = null;
        Granjero.lock.lock();
        while (Granjero.estaDormido){
            Granjero.lock.unlock();
            if (huevo == null) {
                int peso = (int) (Math.random() * pesoHuevoMin + pesoHuevoMax);
                huevo = new Huevo(nombre, peso);
            }
            if (Huevera.meterHuevo(huevo)){
             huevo = null;
             Thread.sleep(tiempoEspera);
            }else {
                Thread.sleep(500);
            }
            Granjero.lock.lock();
        }
        Granjero.lock.unlock();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PoneHuevo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
