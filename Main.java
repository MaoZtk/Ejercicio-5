import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        GeneradorAPA generadorAPA = new GeneradorAPA();

        int opcion;

        do {
            System.out.println("1. Agregar material bibliográfico");
            System.out.println("2. Mostrar conteo por género");
            System.out.println("3. Mostrar conteo por autor");
            System.out.println("4. Mostrar conteo por año de publicación");
            System.out.println("5. Generar catálogo en formato APA");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea después del número
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine(); // Limpiar la entrada no válida
                opcion = -1; // Asignar un valor no válido para que el bucle se repita
            }

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los datos del material:");

                    System.out.print("Nombre del material: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Editorial: ");
                    String editorial = scanner.nextLine();

                    int anioPublicacion = 0;
                    boolean anioValido = false;

                    while (!anioValido) {
                        try {
                            System.out.print("Año de publicación: ");
                            anioPublicacion = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea
                            anioValido = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingrese un año válido.");
                            scanner.nextLine(); // Limpiar la entrada no válida
                        }
                    }

                    System.out.print("Género (Libro, ArticuloCientifico, Periodico, Tesis, DVD): ");
                    String genero = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    MaterialBibliografico material = new Catalogo(nombre, editorial, anioPublicacion, genero, autor);
                    catalogo.agregarMaterial(material);
                    System.out.println("Material agregado al catálogo.");
                    break;
                case 2:
                    System.out.println("Conteo por género:");
                    Map<String, Integer> conteoGenero = catalogo.contarPorGenero();
                    for (Map.Entry<String, Integer> entry : conteoGenero.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 3:
                    System.out.println("Conteo por autor:");
                    Map<String, Integer> conteoAutor = catalogo.contarPorAutor();
                    for (Map.Entry<String, Integer> entry : conteoAutor.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 4:
                    System.out.println("Conteo por año de publicación:");
                    Map<Integer, Integer> conteoAnio = catalogo.contarPorAnio();
                    for (Map.Entry<Integer, Integer> entry : conteoAnio.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;

                case 5:
                    System.out.println("Catálogo en formato APA:");
                    catalogo.generarCatalogo(generadorAPA);
                    break;

                case 0:
                    System.out.println("¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close(); // Cerrar el scanner al salir del programa
    }
}

