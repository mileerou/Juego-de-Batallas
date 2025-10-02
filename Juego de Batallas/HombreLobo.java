public class HombreLobo extends Enemigo {
    public HombreLobo(String nombre, int puntosVida, int poderAtaque) {
        super("Hombre Lobo", 110, 100);
    }

    @Override
    public void tomarTurno(Combatiente objetivo) {
        usarHabilidadEspecial(objetivo);
    }

    @Override
    public void usarHabilidadEspecial(Combatiente objetivo) {
        int cantidad = poderAtaque + 15;
        objetivo.recibirDano(cantidad);
        curar(cantidad / 3);
    }

    @Override
    public String mensajeInicio() {
        return "¡El Hombre Lobo aulló y se lanzó al ataque!";
    }

    @Override
    public String mensajeMuerte() {
        return "El Hombre Lobo ha sido derrotado, pero su furia perdurará.";
    }

    @Override
    public String mensajeVictoria() {
        return "El Hombre Lobo ha vencido a su oponente con su fuerza salvaje.";
    }
}
