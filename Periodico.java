public class Periodico extends MaterialBibliografico {
    private String nombrePeriodico;
    private String paginasPeriodico;

    public Periodico(String nombre, int anioPublicacion, String autor, String nombrePeriodico, String paginasPeriodico) {
        super(nombre, anioPublicacion, autor, "Periodico");
        this.nombrePeriodico = nombrePeriodico;
        this.paginasPeriodico = paginasPeriodico;
    }

    @Override
    public String generarCitaAPA() {
        return getAutor() + " (" + getAnioPublicacion() + "). " + getNombre_material() + ". " + nombrePeriodico + ", " + paginasPeriodico + ".";
    }
}
