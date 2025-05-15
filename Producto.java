
public class Producto {

    private int id;
    private String nombre;
    private double precio;

    public Producto(int idParametro, String nombreParametro, double precioParametro) {
        this.id = idParametro;
        this.nombre = nombreParametro;
        this.precio = precioParametro;
    }
    public int getId() {
    return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


    void mostrar() {
        System.out.println("ID: " + this.id + " | Nombre: " + this.nombre + " | Precio: $" + this.precio);
    }
}
