import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("""
                ¡Bienvenido a la Batalla Épica!
                Elige tu héroe:
                1. Rey
                2. Exorcista
                """);
        int opcion = Integer.parseInt(sc.nextLine().trim());

        Batalla batalla = new Batalla();

        Heroe heroe = (opcion == 1) ? new Rey("Galio"): (opcion == 2) ? new Exorcista("Herga") : null;
        System.out.println("Has elegido: " + heroe.getNombre() + "\n");
        System.out.println(heroe.mensajeInicio());
        batalla.agregarHeroe(heroe);

        heroe.getInventario().agregarItem(new PocionCuracion("Poción de Curación", "Restaura 50 puntos de vida."));
        heroe.getInventario().agregarItem(new PocionFuerza("Poción de Fuerza", "Aumenta el ataque por 50 puntos", 50));

        Enemigo HombreLobo = new HombreLobo("Hombre Lobo", 110, 100);
        Enemigo Vampiro = new Vampiro("Vampiro", 120, 70);
        Enemigo HombreLoboJefe = new HombreLoboJefe("Wawik", 150, 90);
        Enemigo VampiroJefe = new VampiroJefe("Drácula", 140, 80);

        Enemigo[] posibles = {
            new HombreLobo("Hombre Lobo", 110, 100),
            new Vampiro("Vampiro", 120, 70),
            new HombreLoboJefe("Wawik", 150, 90),
            new VampiroJefe("Drácula", 140, 80)
        };

        int cantidad = 1 + new java.util.Random().nextInt(3);
        java.util.List<Integer> indicesUsados = new java.util.ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            int indice;
            do {
                indice = new java.util.Random().nextInt(posibles.length);
            } while (indicesUsados.contains(indice));
            indicesUsados.add(indice);
            batalla.agregarEnemigo(posibles[indice]);
        }

        batalla.iniciar();

        while (batalla.hayVivos()){
            System.out.println("\n--- Estado Actual ---");
            System.out.println(heroe.getNombre() + ": " + (heroe.estaVivo() ? heroe.getPuntosVida() + " HP" : "Derrotado"));
            for (Enemigo enemigo : batalla.getEnemigos()) {
                System.out.println(enemigo.getNombre() + ": " + (enemigo.estaVivo() ? enemigo.getPuntosVida() + " HP" : "Derrotado"));
            }

            System.out.println("\nÚltimas acciones:");
            for (String accion: batalla.getRegistroAcciones()){
                System.out.println("- " + accion);
            }
        

            System.out.println("""
                --- Menú de Acciones ---
                1. Atacar
                2. Usar Item
                3. Ver inventario
                """);
            int accion = Integer.parseInt(sc.nextLine().trim());

            Enemigo objetivo = batalla.obtenerEnemigoVivo();

            if (accion == 1 && objetivo != null){
            heroe.atacar(objetivo);
            batalla.registrarAccion(heroe.getNombre() + " ataca a " + objetivo.getNombre());
            if (!objetivo.estaVivo()){
                batalla.registrarAccion(objetivo.getNombre() + " ha sido derrotado!");
                batalla.registrarAccion(objetivo.mensajeMuerte());
            }
            } else if (accion == 2){
            if (heroe.obtenerInventario().isEmpty()){
                System.out.println("El combatiente tiene el inventario vacío.");
            } else {
                System.out.println("Elige un item para usar:");
                for (int i = 0; i < heroe.obtenerInventario().size(); i++){
                    Item item = heroe.obtenerInventario().get(i);
                    System.out.println((i + 1) + ". " + item.getNombre() + " - " + item.getDescripcion());
                }

                int idx = Integer.parseInt(sc.nextLine().trim()) - 1;
                if (idx >= 0 && idx < heroe.obtenerInventario().size()){
                    Item item = heroe.obtenerInventario().get(idx);
                    heroe.usarItem(idx, heroe);
                    batalla.registrarAccion(heroe.getNombre() + " usa " + item.getNombre());
                }
            }
            } else if (accion == 3){
            System.out.println("Inventario actual:");
            for (int i = 0; i < heroe.obtenerInventario().size(); i++){
                Item item = heroe.obtenerInventario().get(i);
                System.out.println((i + 1) + ". " + item.getNombre() + " - " + item.getDescripcion());
            }
            }

            if (batalla.hayVivos()){
            batalla.ejecutarTurnoEnemigo(objetivo);
            }
        }   
        System.out.println(heroe.estaVivo() ? heroe.mensajeVictoria() : "El héroe ha sido derrotado. ¡Fin de la batalla!");
        sc.close();
    }
}
