public class ArticuloCientifico extends MaterialBibliografico {
    private String tituloRevista;
    private int volumen;
    private String paginas;

    public ArticuloCientifico(String nombre, int anioPublicacion, String autor, String tituloRevista, int volumen2, String paginas) {
        super(nombre, "N/A", anioPublicacion, "ArticuloCientifico", autor);
        this.tituloRevista = tituloRevista;
        this.volumen = volumen2;
        this.paginas = paginas;
    }

    @Override
    public String generarCitaAPA() {
        return getAutor() + " (" + getAnioPublicacion() + "). " + getNombre_material() + ". " + tituloRevista + ", " + volumen + ", " + paginas + ".";
    }
}
