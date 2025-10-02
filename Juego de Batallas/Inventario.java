import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<Item> items = new ArrayList<>();

    public void agregarItem(Item item){
        items.add(item);
    }

    public void usarItem(int indice, Combatiente objetivo){
        if (indice >= 0 && indice < items.size()) {
            Item item = items.get(indice);
            item.usarItem(objetivo);
            items.remove(indice);
        }
    }

    public List<Item> getItems() { return items; }
}
