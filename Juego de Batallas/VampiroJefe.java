public class VampiroJefe extends Vampiro {
    private int efectoTurnosRestantes = 0;
    private int efectoDanoPendiente = 0;

    public VampiroJefe(String nombre, int puntosVida, int poderAtaque) {
        super("Drácula", 140, 80);
    }
    

    public void habilidadEspecial(Combatiente objetivo){
        int cantidad = poderAtaque + 5;
        objetivo.recibirDano(cantidad);
        curar(cantidad / 2);

        efectoTurnosRestantes = 2;
        efectoDanoPendiente = (int)(cantidad * 0.75);
    }

    public void aplicarEfectoTurno(Combatiente objetivo) {
        if (efectoTurnosRestantes > 0) {
            objetivo.recibirDano(efectoDanoPendiente);
            efectoTurnosRestantes--;
        }
    }

    @Override
    public String mensajeInicio() {
        return "¡El temible " + nombre + " ha aparecido!";
    }

    @Override
    public String mensajeVictoria() {
        return nombre + " ha derrotado a su oponente con su sed de sangre.";
    }

    @Override
    public String mensajeMuerte() {
        return nombre + " ha sido derrotado, pero su leyenda vivirá para siempre.";
    }
}
