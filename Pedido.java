import java.util.ArrayList;
import java.util.Random;

public class Pedido {
    private int id;
    private ArrayList<Producto> lista;

    public Pedido() {
        this.id = generarIdAleatorio();
        this.lista = new ArrayList<>();
    }

    private static int generarIdAleatorio() {
        Random random = new Random();
        return random.nextInt(9000) + 1000; 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getLista() {
        return lista;
    }



    public void mostrarProductos() {
        System.out.println("--- Numero de pedido : " + id + " ---");
        if(lista.size()!=0){
        for (Producto p : lista) {
            p.mostrar();
        }
        System.out.println("\n");
        }else{
            System.out.println("--- No hay productos cargados en el pedido--- \n");
        }
    }



    
    public void listarPedido(){
         System.out.println("ID: " + this.id + " | Cantidad productos: " + this.lista.size() + " | Total : $" + obtenerElTotal());


    }
    public double obtenerElTotal() {
        double total = 0;
        for (Producto p : lista) {
            total += p.getPrecio(); 
        }
        return total;
    }
}
