public class Libro extends MaterialBibliografico {
    private String edicion;
    private String lugarPublicacion;

    public Libro(String nombre, String editorial, int anioPublicacion, String autor, String edicion, String lugarPublicacion) {
        super(nombre, editorial, anioPublicacion, autor, "Libro");
        this.edicion = edicion;
        this.lugarPublicacion = lugarPublicacion;
    }

    @Override
    public String generarCitaAPA() {
        // Implementa la generación de cita APA específica para un libro
    }
}