class GeneradorAPA extends MaterialBibliografico {
    public GeneradorAPA() {
        super(null, null, 0, null, null); // Llama al constructor de la superclase
    }
    public String generarCitaAPA(MaterialBibliografico material) {
        String referenciaAPA = "";

        if (material.getGenero().equals("Libro")) {
            referenciaAPA = material.getAutor() + " (" + material.getAnioPublicacion() + "). " + material.getNombre_material() + ". " + material.getEditorial() + ".";
        } else if (material.getGenero().equals("ArticuloCientifico")) {
            referenciaAPA = material.getAutor() + " (" + material.getAnioPublicacion() + "). " + material.getNombre_material() + ". Título de la revista, Volumen, Páginas.";
        } else if (material.getGenero().equals("Periodico")) {
            referenciaAPA = material.getAutor() + " (" + material.getAnioPublicacion() + "). " + material.getNombre_material() + ". Nombre del periódico, Páginas.";
        } else if (material.getGenero().equals("Tesis")) {
            referenciaAPA = material.getAutor() + " (" + material.getAnioPublicacion() + "). " + material.getNombre_material() + " [Tesis de doctorado, Nombre de la institución que otorgó el título].";
        } else if (material.getGenero().equals("DVD")) {
            referenciaAPA = material.getAutor() + " (" + material.getAnioPublicacion() + "). " + material.getNombre_material() + " [DVD]. Productora.";
        }

        return referenciaAPA;
    }
    @Override
    public String generarCitaAPA() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generarCitaAPA'");
    }
}