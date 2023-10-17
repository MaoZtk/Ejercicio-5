import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo(null, null, 0, null, null);
        GeneradorAPA generadorAPA = new GeneradorAPA();

        int opcion;

        do {
            System.out.println("1. Agregar material bibliografico");
            System.out.println("2. Mostrar conteo por genero");
            System.out.println("3. Mostrar conteo por autor");
            System.out.println("4. Mostrar conteo por anio de publicacion");
            System.out.println("5. Generar catalogo en formato APA");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                System.out.println("Ingrese los datos del material:");
                System.out.print("Nombre del material: ");
                String nombre = scanner.next();
                System.out.print("Editorial: ");
                String editorial = scanner.next();
    
                int anioPublicacion = 0;
                boolean anioValido = false;
    
                while (!anioValido) {
                    try {
                        System.out.print("Anio de publicacion: ");
                        anioPublicacion = scanner.nextInt();
                        anioValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un anio valido.");
                        scanner.next(); // Limpiar la entrada no válida
                    }
                }
    
                System.out.print("Genero (Libro, ArticuloCientifico, Periodico, Tesis, DVD): ");
                String genero = scanner.next();
                System.out.print("Autor: ");
                String autor = scanner.next();
    
                MaterialBibliografico material;
    
                if (genero.equalsIgnoreCase("Libro")) {
                    System.out.print("Edición: ");
                    String edicion = scanner.next();
                    System.out.print("Lugar de publicación: ");
                    String lugarPublicacion = scanner.next();
    
                    material = new Libro(nombre, editorial, anioPublicacion, autor, edicion, lugarPublicacion);
                } else if (genero.equalsIgnoreCase("ArticuloCientifico")) {
                    // Ingresa los datos específicos para ArticuloCientifico
                    System.out.print("Título de la revista: ");
                    String tituloRevista = scanner.next();
                    System.out.print("Volumen: ");
                    int volumen = scanner.nextInt();
                    System.out.print("Páginas: ");
                    String paginas = scanner.next();
    
                    material = new ArticuloCientifico(nombre, anioPublicacion, autor, tituloRevista, volumen, paginas);
                } else if (genero.equalsIgnoreCase("Periodico")) {
                    // Ingresa los datos específicos para Periodico
                    System.out.print("Nombre del periódico: ");
                    String nombrePeriodico = scanner.next();
                    System.out.print("Páginas: ");
                    String paginas = scanner.next();
    
                    material = new Periodico(nombre, anioPublicacion, autor, nombrePeriodico, paginas);
                } else if (genero.equalsIgnoreCase("Tesis")) {
                    // Ingresa los datos específicos para Tesis
                    System.out.print("Nombre de la institución: ");
                    String nombreInstitucion = scanner.next();
                    System.out.print("URL: ");
                    String url = scanner.next();
    
                    material = new Tesis(nombre, anioPublicacion, autor, nombreInstitucion, url);
                } else if (genero.equalsIgnoreCase("DVD")) {
                    // Ingresa los datos específicos para DVD
                    System.out.print("Director: ");
                    String director = scanner.next();
                    System.out.print("Productora: ");
                    String productora = scanner.next();
    
                    material = new DVD(nombre, anioPublicacion, autor, director, productora);
                } else {
                    System.out.println("Género no válido.");
                    continue; // Volver al menú principal
                }
    
                catalogo.agregarMaterial(material);
                System.out.println("Material agregado al catálogo.");
                break;

                case 2:
                    System.out.println("Conteo por genero:");
                    catalogo.contarPorGenero().forEach((nombreGenero, cantidad) -> System.out.println(nombreGenero + ": " + cantidad));
                    break;

                case 3:
                    System.out.println("Conteo por autor:");
                    catalogo.contarPorAutor().forEach((nombreAutor, cantidad) -> System.out.println(nombreAutor + ": " + cantidad));
                    break;

                case 4:
                    System.out.println("Conteo por anio de publicacion:");
                    catalogo.contarPorAnio().forEach((anio, cantidad) -> System.out.println(anio + ": " + cantidad));
                    break;

                case 5:
                    System.out.println("Catalogo en formato APA:");
                    catalogo.generarCatalogo(generadorAPA);
                    break;

                case 0:
                    System.out.println("¡Adios!");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 0);
    }
}
