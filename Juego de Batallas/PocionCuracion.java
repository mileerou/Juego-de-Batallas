public class PocionCuracion extends Item {
    public PocionCuracion(String nombre, String descripcion) {
        super("Poción de Curación", "Restaura 40 puntos de vida");
    }

    @Override
    public void usarItem(Combatiente objetivo) {
        int puntosCuracion = 40;
        objetivo.curar(puntosCuracion);
        System.out.println(objetivo.getNombre() + " ha usado una " + nombre + " y ha recuperado " + puntosCuracion + " puntos de vida.");
    }
}

