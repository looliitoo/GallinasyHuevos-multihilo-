import com.sun.source.tree.WhileLoopTree;

public class RobaHuevos {
    String nombre;
    int pesoHuevoComido;
    public int pesoMximo;



    public RobaHuevos(String nombre) {
        this.nombre = nombre;
    }
    public void robarHuevos() throws InterruptedException {
        Granjero.lock.lock();
        while(Granjero.estaDormido&&pesoHuevoComido < pesoMximo){
            Granjero.lock.unlock();
            Huevo huevo = Huevera.sacarHuevo();
            if (huevo != null){
                pesoHuevoComido += huevo.getPeso();
                System.out.println("$Soy "+nombre+" y he robado un huevo con peso "+huevo.peso+"gr");
                Thread.sleep(1000);
            }else{
                Thread.sleep(500);
            }
            Granjero.lock.lock();
        }
        System.out.println("Me piro careverga soy " + nombre + " he comido " + pesoHuevoComido);
        Granjero.lock.unlock();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPesoHuevoComido() {
        return pesoHuevoComido;
    }

    public void setPesoHuevoComido(int pesoHuevoComido) {
        this.pesoHuevoComido = pesoHuevoComido;
    }
}
