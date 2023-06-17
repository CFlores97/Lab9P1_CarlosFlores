
package lab9p1_carlosflores;


public class Libros {
    private String titulo;
    private String nombre_autor;
    private String genero;
    private int edad_minima;

    public Libros(String titulo, String nombre_autor, String genero, int edad_minima) {
        this.titulo = titulo;
        this.nombre_autor = nombre_autor;
        this.genero = genero;
        this.edad_minima = edad_minima;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }
    
    
    
}
