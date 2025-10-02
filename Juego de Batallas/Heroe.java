import java.util.List;

public class Heroe extends Combatiente {
    private final Inventario inventario;

    public Heroe(String nombre, int puntosVida, int poderAtaque) {
        super(nombre, puntosVida, poderAtaque);
        this.inventario = new Inventario();
    }

    public List<Item> obtenerInventario(){
        return inventario.getItems();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void usarItem(int indice, Combatiente objetivo){
        inventario.usarItem(indice, objetivo);
    }

    @Override
    public void tomarTurno(Combatiente objetivo) {
        atacar(objetivo);
    }

    @Override
    public String mensajeInicio(){
        return "";
    }

    @Override
    public String mensajeVictoria(){
        return "";
    }

    @Override
    public String mensajeMuerte(){
        return "";
    }
}
