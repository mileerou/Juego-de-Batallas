import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalla {
    private Heroe heroe;
    private final List<Enemigo> enemigos = new ArrayList<>();
    private final List<String> registroAcciones = new ArrayList<>();
    private final Random random = new Random();

    public void agregarHeroe(Heroe heroe) { this.heroe = heroe; }
    public void agregarEnemigo(Enemigo enemigo) { enemigos.add(enemigo); }

    public void registrarAccion(String texto) {
    registroAcciones.add(texto);
        while (registroAcciones.size() > 3) {
        registroAcciones.remove(0);
        }
    }

    public void iniciar(){
        registrarAccion("¡La batalla comienza! ¡Combatientes a la arena!");
    }

    public boolean hayVivos(){
        return heroe.estaVivo() && enemigos.stream().anyMatch(Enemigo::estaVivo);
    }

    public Enemigo obtenerEnemigoVivo(){
        return enemigos.stream().filter(Enemigo::estaVivo).findFirst().orElse(null);
    }

    public void ejecutarTurnoEnemigo(Enemigo enemigo){
        for (Enemigo e: enemigos){
            if (!e.estaVivo()) continue;

            if (random.nextDouble() < 0.3){
                e.usarHabilidadEspecial(heroe);
                registrarAccion(e.getNombre() + " usa su habilidad especial" + " contra " + heroe.getNombre());
            } else {
                e.atacar(heroe);
                registrarAccion(e.getNombre() + " ataca a " + heroe.getNombre());
            }

            if (!heroe.estaVivo()){
                registrarAccion(heroe.getNombre() + " ha sido derrotado!");
                registrarAccion(heroe.mensajeMuerte());
                break;
            }
        }
    }

    public List<String> getRegistroAcciones() { return registroAcciones; }
    public Heroe getHeroe() { return heroe; }
    public List<Enemigo> getEnemigos() { return enemigos; }

}

    

