//Universidad del Valle de Guatemala
//Departamento de Ciencia de la Computación
//Autor: Marielos Ortiz, Sandra Pineda
//Carné: 23882, 231137
//CC2008 - 50
//Fecha: 16 de Octubre de 2023
//Descripción: Ejercicio 5 en parejas sobre un programa de creación de citas y referencias APA 7.
//Esta clase es del contenido del Material bibliogrpafico que se requiera.
//************************************************************************

/**
 * Esta clase representa un material bibliográfico genérico con información básica.
 */
public class MaterialBibliografico {
    protected String nombre_material;
    protected String editorial;
    protected int anioPublicacion;
    protected String genero;
    protected String autor;

    /**
     * Constructor para crear un nuevo material bibliográfico.
     *
     * @param nombre_material  El nombre del material.
     * @param editorial        La editorial del material.
     * @param anioPublicacion  El año de publicación del material.
     * @param genero           El género o categoría del material.
     * @param autor            El autor del material.
     */
    public MaterialBibliografico(String nombre_material, String editorial, int anioPublicacion, String genero, String autor) {
        this.nombre_material = nombre_material;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
        this.autor = autor;
    }

    /**
     * Obtiene el nombre del material.
     *
     * @return El nombre del material.
     */
    public String getNombre_material() {
        return nombre_material;
    }

    /**
     * Establece el nombre del material.
     *
     * @param nombre_material El nuevo nombre del material.
     */
    public void setnombre_material(String nombre_material) {
        this.nombre_material = nombre_material;
    }

    /**
     * Obtiene la editorial del material.
     *
     * @return La editorial del material.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del material.
     *
     * @param editorial La nueva editorial del material.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el año de publicación del material.
     *
     * @return El año de publicación del material.
     */
    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    /**
     * Establece el año de publicación del material.
     *
     * @param anioPublicacion El nuevo año de publicación del material.
     */
    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    /**
     * Obtiene el género o categoría del material.
     *
     * @return El género o categoría del material.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género o categoría del material.
     *
     * @param genero El nuevo género o categoría del material.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el autor del material.
     *
     * @return El autor del material.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del material.
     *
     * @param autor El nuevo autor del material.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }
}
