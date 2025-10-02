public class HombreLoboJefe extends HombreLobo {
    public HombreLoboJefe(String nombre, int puntosVida, int poderAtaque){
        super("Wawik", 150, 90);
    }
    
    @Override
    public void usarHabilidadEspecial(Combatiente objetivo){
        if (puntosVida < (getPuntosVida() * 0.5)) {
            int cantidad = (int)((poderAtaque + 14) * 1.25);
            objetivo.recibirDano(cantidad);

            if (Math.random() < 0.10) {
                curar(cantidad);
            }
        } else {
            int cantidad = poderAtaque + 14;
            objetivo.recibirDano(cantidad);
            curar(cantidad / 2);
        }
    }

    @Override
    public String mensajeInicio() {
        return "¡El feroz " + nombre + " ha aparecido!";
    }

    @Override
    public String mensajeMuerte() {
        return nombre + " ha sido derrotado, pero su furia perdurará.";
    }

    @Override
    public String mensajeVictoria() {
        return nombre + " ha vencido a su oponente con su fuerza salvaje.";
    }
}
