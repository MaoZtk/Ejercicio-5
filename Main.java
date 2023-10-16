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
                            System.out.print("Año de publicación: ");
                            anioPublicacion = scanner.nextInt();
                            anioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un año válido.");
                            scanner.next(); // Limpiar la entrada no válida
                        }
                    }
                    
                    System.out.print("Género (Libro, ArticuloCientifico, Periodico, Tesis, DVD): ");
                    String genero = scanner.next();
                    System.out.print("Autor: ");
                    String autor = scanner.next();

                    MaterialBibliografico material = new MaterialBibliografico(nombre, editorial, anioPublicacion, genero, autor);
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
