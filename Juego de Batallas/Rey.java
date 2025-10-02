public class Rey extends Heroe {

    public Rey(String nombre) {
        super("Rey", 120, 25);
    }

    @Override
    public String mensajeInicio(){
        return "¡El Rey entra al campo de batalla para proteger a su pueblo!";
    }

    @Override
    public String mensajeVictoria(){
        return "¡El Rey ha triunfado y la paz reina en el reino!";
    }

    @Override
    public String mensajeMuerte(){
        return "El Rey ha caído, pero su legado vivirá en su pueblo.";
    }
}
