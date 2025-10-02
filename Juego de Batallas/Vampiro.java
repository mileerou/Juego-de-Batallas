public class Vampiro extends Enemigo {
    public Vampiro(String nombre, int puntosVida, int poderAtaque){
        super("Vampiro", 120, 70);
    }

    @Override
    public void usarHabilidadEspecial(Combatiente objetivo){
        int cantidad = poderAtaque + 7;
        objetivo.recibirDano(cantidad);
        curar(cantidad/2);
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
