public abstract class Item {
    protected String nombre;
    protected String descripcion;

    public Item(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract void usarItem(Combatiente objetivo);

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }
}
