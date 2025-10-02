public abstract class Enemigo extends Combatiente {
    protected String HabilidadEspecial;

    public String getHabilidadEspecial() {
        return HabilidadEspecial;
    }

    public Enemigo(String nombre, int puntosVida, int poderAtaque){
        super(nombre, puntosVida, poderAtaque);
    }

    public abstract void usarHabilidadEspecial(Combatiente objetivo);
}
