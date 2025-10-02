public abstract class Combatiente {
    protected String nombre;
    protected int puntosVida;
    protected int poderAtaque;

    public Combatiente(String nombre, int puntosVida, int puntosAtaque) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.poderAtaque = poderAtaque;
    }

    public abstract void tomarTurno(Combatiente objetivo);

    public void atacar(Combatiente objetivo){
        objetivo.recibirDano(poderAtaque);
    }

    public void recibirDano(int cantidad){
        puntosVida -= cantidad;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
    }

    public void curar(int cantidad){
        if (puntosVida != 0)puntosVida += cantidad;
    }

    public void modificarPoderAtaque(int cantidad){
        poderAtaque += cantidad;
        if (poderAtaque < 0) {
            poderAtaque = 0;
        }
    }

    public boolean estaVivo(){
        return puntosVida > 0;
    }

    public abstract String mensajeInicio();

    public abstract String mensajeMuerte();

    public abstract String mensajeVictoria();

    public String getNombre() { return nombre; }

    public int getPuntosVida() { return puntosVida; }

    public int getPuntosAtaque() { return poderAtaque; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setPuntosVida(int puntosVida) { this.puntosVida = puntosVida; }

    public void setPuntosAtaque(int puntosAtaque) { this.poderAtaque = poderAtaque; }
}