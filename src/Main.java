public class Main {
    public static void main(String[] args) {
        Granjero granjero = new Granjero();
        Thread thread = new Thread(granjero);
        granjero.start();

        for (int i = 0; i < 10;i++){
            Gallina gallina = new Gallina("Galllina "+i);
            Thread threadG = new Thread(gallina);
            threadG.start();
        }

        for(int i = 0; i< 5;i++){
            Pularda pularda = new Pularda("Pularda "+i);
            Thread threadP = new Thread(pularda);
            threadP.start();
        }

        for(int i = 0; i < 2;i++){
            Buitre buitre = new Buitre("Buitre "+i);
            Thread threadB = new Thread(buitre);
            threadB.start();
        }

        for(int i = 0; i < 3;i++){
            Hurraca hurraca = new Hurraca("Hurraca "+i);
            Thread threadH = new Thread(hurraca);
            threadH.start();
        }
    }
}
