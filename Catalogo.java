//Universidad del Valle de Guatemala
//Departamento de Ciencia de la Computación
//Autor: Marielos Ortiz, Sandra Pineda
//Carné: 23882, 231137
//CC2008 - 50
//Fecha: 16 de Octubre de 2023
//Descripción: Ejercicio 5 en parejas sobre un programa de creación de citas y referencias APA 7.
//Esta clase es del contenido del catálogo existente de referencias y citas, en conjunto con los conteos necesarios en métodos.
//************************************************************************

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase representa un catálogo de materiales bibliográficos.
 * Un catálogo es una colección de materiales bibliográficos con funcionalidades para contar y generar citas APA.
 */
public class Catalogo {
    private List<MaterialBibliografico> materiales;
    
    /**
     * Constructor para crear un catálogo vacío.
     */
    public Catalogo(){
        materiales = new ArrayList<>();
    } 

    /**
     * Agrega un material bibliográfico al catálogo.
     *
     * @param material El material bibliográfico a agregar.
     */
    public void agregarMaterial(MaterialBibliografico material) {
        materiales.add(material);
    }

    /**
     * Cuenta la cantidad de materiales por género.
     *
     * @return Un mapa que asocia géneros con la cantidad de materiales en el catálogo de ese género.
     */
    public Map<String, Integer> contarPorGenero() {
        Map<String, Integer> conteoGenero = new HashMap<>();

        for (MaterialBibliografico material : materiales) {
            String genero = material.getGenero();
            conteoGenero.put(genero, conteoGenero.getOrDefault(genero, 0) + 1);
        }

        return conteoGenero;
    }

    /**
     * Cuenta la cantidad de materiales por autor.
     *
     * @return Un mapa que asocia autores con la cantidad de materiales en el catálogo de ese autor.
     */
    public Map<String, Integer> contarPorAutor() {
        Map<String, Integer> conteoAutor = new HashMap<>();

        for (MaterialBibliografico material : materiales) {
            String autor = material.getAutor();
            conteoAutor.put(autor, conteoAutor.getOrDefault(autor, 0) + 1);
        }

        return conteoAutor;
    }

    /**
     * Cuenta la cantidad de materiales por año de publicación.
     *
     * @return Un mapa que asocia años de publicación con la cantidad de materiales en el catálogo de ese año.
     */
    public Map<Integer, Integer> contarPorAnio() {
        Map<Integer, Integer> conteoAnio = new HashMap<>();

        for (MaterialBibliografico material : materiales) {
            int anio = material.getAnioPublicacion();
            conteoAnio.put(anio, conteoAnio.getOrDefault(anio, 0) + 1);
        }

        return conteoAnio;
    }

    /**
     * Genera citas APA para todos los materiales del catálogo y las muestra en la consola.
     * @param generadorAPA
     */
    public void generarCatalogo(GeneradorAPA generadorAPA) {
        for (MaterialBibliografico material : materiales) {
            String citaAPA = generadorAPA.generarCitaAPA(material);
            System.out.println(citaAPA);
        }
    }
}
