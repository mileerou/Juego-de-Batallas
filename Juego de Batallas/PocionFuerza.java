public class PocionFuerza extends Item {
    private final int bonus;

    public PocionFuerza(String nombre, String descripcion, int bonus) {
        super("Poción de Fuerza", "Aumenta el poder de ataque en " + bonus + " puntos durante 3 turnos");
        this.bonus = 30;
    }

    @Override
    public void usarItem(Combatiente objetivo){
        objetivo.modificarPoderAtaque(bonus);
    }
}
