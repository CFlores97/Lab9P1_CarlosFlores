package lab9p1_carlosflores;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab9P1_CarlosFlores {

    static Random ran = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Libros> libros = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("1. Libros y más Libros REMASTERED\n2. Salir");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    boolean new_running = true;

                    while (new_running) {

                        System.out.println("Elija una opcion: ");
                        System.out.println("1. Agregar Libro\n"
                                + "2. Listar libros\n"
                                + "3. Modificar libro\n"
                                + "4. Eliminar libro\n"
                                + "5. Buscar libro por titulo\n"
                                + "6. Buscar libros según autor\n"
                                + "7. Búsqueda con filtro de genero"
                                + "\n8. Salir");

                        int book_op = sc.nextInt();

                        switch (book_op) {
                            case 1:
                                agregarLibro(libros);
                                break;
                            case 2:
                                System.out.println("Libros Disponibles: ");
                                printArray(libros);
                                break;

                            case 3:
                                modificarLibreria(libros);
                                break;

                            case 4:
                                eliminarLibro(libros);
                                break;

                            case 5:
                                buscarLibro(libros);
                                break;
                            case 6:
                                buscarAutor(libros);
                                break;
                            case 7:
                                buscaFiltro(libros);
                                break;
                            case 8:
                                new_running = false;
                                break;

                            default:
                                break;
                        }

                    }

                    break;
                case 2:
                    running = false;
                    break;

                default:
                    break;
            }

        }
    }

    public static void agregarLibro(ArrayList<Libros> libros) {

        System.out.println("Ha elegido la opcion para agregar un libro, por favor aporte la informacion solicitada");

        System.out.println("Titulo: ");
        sc.nextLine();
        String title = sc.nextLine();

        System.out.println("Autor: ");
        String author = sc.next();

        System.out.println("Genero: ");
        String genero = sc.next();

        System.out.println("Edad minima: ");
        int edad = sc.nextInt();
        while (edad <= 0) {
            System.out.println("no puede ser menor o igual a 0");
            edad = sc.nextInt();
        }

        Libros libro = new Libros(title, author, genero, edad);

        libros.add(libro);

        System.out.println("Libro agregado exitosamente!\n");
    }

    public static void modificarLibreria(ArrayList<Libros> libros) {

        System.out.println("Ha ingresado la opción de modificar libros, elija el libro que modificara: ");
        printArray(libros);

        System.out.println("Libro seleccionado: ");
        int num_selected = sc.nextInt();

        System.out.println("Libro seleccionado: " + num_selected);

        String selected_book = libros.get(num_selected - 1).getTitulo();

        System.out.println("Ha seleccionado el libro " + selected_book + "¿qué atributo desea modificar?");
        System.out.println("1. Titulo\n"
                + "2. Autor\n"
                + "3. Genero\n"
                + "4. Edad Mínima");

        int opcion_ingresada = sc.nextInt();

        switch (opcion_ingresada) {
            case 1:
                System.out.println("Modificara el Titulo del libro, ingrese el nuevo Titulo: ");
                sc.nextLine();
                String new_title = sc.nextLine();
                libros.get(num_selected - 1).setTitulo(new_title);

                break;
            case 2:
                System.out.println("Modificara el Autor del libro, ingrese el nuevo Autor: ");
                String new_author = sc.next();
                libros.get(num_selected - 1).setNombre_autor(new_author);
                break;
            case 3:
                System.out.println("Modificara el Genero del libro, ingrese el nuevo Genero: ");
                String new_genre = sc.next();
                libros.get(num_selected - 1).setGenero(new_genre);
                break;
            case 4:
                System.out.println("Modificara la edad minima del libro, ingrese la nueva edad minima: ");
                int new_edad = sc.nextInt();
                while (new_edad <= 0) {
                    System.out.println("no puede ser menor o igual a 0");
                    new_edad = sc.nextInt();
                }
                libros.get(num_selected - 1).setEdad_minima(new_edad);
                break;

            default:

        }

    }

    public static void eliminarLibro(ArrayList<Libros> libros) {

        printArray(libros);

        System.out.println("Que libro desea eliminar?");
        int libro_elim = sc.nextInt();

        libros.remove(libro_elim - 1);

        //String selected_book = libros.get(libro_elim - 1).getTitulo();
        System.out.println("Libro eliminado exitosamente!");

    }

    public static void buscarLibro(ArrayList<Libros> libros) {

        boolean encontrado = false;

        System.out.println("Ingrese el libro que desea buscar por Titulo: ");
        sc.nextLine();
        String libro_buscar = sc.nextLine();
        
        int c = 1;

        for (Libros book : libros) {
            if (libro_buscar.equalsIgnoreCase(book.getTitulo())) {
                System.out.println("Libro encontrado!");
                System.out.println("Libro " + c  + "\nTitulo: " + book.getTitulo() + "\nAutor: " + book.getNombre_autor() + "\nGenero: " + book.getGenero() + "\nEdad: " + book.getEdad_minima() + "\n");
                c++;
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado");
        }
    }

    public static void buscarAutor(ArrayList<Libros> libros) {

        boolean encontrado = false;

        System.out.println("Ingrese el libro que desea buscar por Autor: ");
        sc.nextLine();
        String libro_buscar = sc.nextLine();
        
        int c = 1;

        for (Libros book : libros) {
            if (libro_buscar.equalsIgnoreCase(book.getNombre_autor())) {
                System.out.println("Libro encontrado!");
                System.out.println("Libro " + c + "\nTitulo: " + book.getTitulo() + "\nAutor: " + book.getNombre_autor() + "\nGenero: " + book.getGenero() + "\nEdad: " + book.getEdad_minima() + "\n");
                c++;
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Libro no encontrado");
        }

    }

    public static void buscaFiltro(ArrayList<Libros> libros) {
        System.out.println("Ingrese el genero a buscar: ");
        boolean encontrados = false;
        int c = 1;

        sc.nextLine();
        String libro_buscar = sc.nextLine();

        for (Libros book : libros) {
            if (libro_buscar.equalsIgnoreCase(book.getGenero())) {
                encontrados = true;
                
                System.out.println("Libro " + c +"\nTitulo: " + book.getTitulo() + "\nAutor: " + book.getNombre_autor() + "\nGenero: " + book.getGenero() + "\nEdad: " + book.getEdad_minima() + "\n");
                c++;
            } else {

            }
        }

        if (!encontrados) {
            System.out.println("Los libros no se encuentran en la lista");
        }
    }

    public static void printArray(ArrayList<Libros> libros) {
        int c = 1;

        for (Libros book : libros) {
            System.out.println("Libro " + c + "\n" + "Titulo: " + book.getTitulo() + "\nAutor: " + book.getNombre_autor() + "\nGenero: " + book.getGenero() + "\nEdad: " + book.getEdad_minima());
            c++;
            System.out.println();
        }
    }

}
