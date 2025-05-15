
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    static ArrayList<Producto> lista = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\n");
        int opcion;
        do {
            System.out.println("\n--- Menú de Producto ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Producto");
            System.out.println("3. Buscar/Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedido");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> listarProductos();
                case 3 -> buscarActualizarProducto();
                case 4 ->  eliminarProducto();
                case 5 -> crearPedido();
                case 6 -> listarPedidos();
                case 7 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 7);
        sc.close(); 


    }
    public static void listarPedidos(){


         System.out.println("\n--- Mis pedidos confirmados ---");
        for (Pedido pedido : listaPedidos) {
            pedido.listarPedido();
        }

    }

    public static void crearPedido(){
            Pedido pedido =new Pedido();
            System.out.println("\n\n");
            int opcion;
            boolean confirmacion=true;
            do {
            pedido.mostrarProductos();
            System.out.println("1. Agregar producto al pedido");
            System.out.println("2. Eliminar producto del pedido");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1 -> agregarProductoAlpedido(pedido);
                case 2 -> eliminarProductoDelPedido(pedido.getLista());
                case 3 ->  confirmacion=SaliendoDelPedido(pedido); 
                default -> System.out.println("Opción inválida");
               
            }
        
        } while (opcion != 3 || confirmacion);
        
    }

    private static boolean SaliendoDelPedido(Pedido pedido){
        boolean flag =true;
       
        
        while (flag) {
             String confirmacion=entradaDeString("Confirmar pedido [Si/No]");

            if (confirmacion.equalsIgnoreCase("Si")) {
                    listaPedidos.add(pedido);
                    System.out.println("Pedido registrado");
                   return flag = false;
            }else if (confirmacion.equalsIgnoreCase("No")) {
                   return flag = true; 
            } else {
                     System.out.println("Error, ingresa [Si/No]");
           }
            
        }
        return flag;
    }


    private static void agregarProductoAlpedido(Pedido pedido){

        if (lista.size()==0) {
            System.out.println("\nEl sistema no tiene productos cargados..");
        }else{
             
             int opcion;
            do {
                System.out.println("\n");
            listarProductos();
            System.out.println("\n");
            opcion = entradaDeIdModificarYeliminar("Seleccione ID [0 para salir]: ",lista);
            
            if (buscarProducto(opcion,lista)!=null) {
                 pedido.getLista().add(buscarProducto(opcion,lista));
                 System.out.println("\nProducto cargado a su pedido...");
            }else{
                System.out.println("\nPedido listo para ENVIO.");
            }
            
          
             } while (opcion != 0);
        }

        
        
    }


    private static void eliminarProductoDelPedido(ArrayList<Producto> listaPedido) {
        if (listaPedido.size()!=0) {
        int idAEliminar = entradaDeIdModificarYeliminar("ID del Producto a eliminar: ",listaPedido);
        eliminarElPrimerProductoEncontrador(listaPedido,idAEliminar);
        System.out.println("\nProducto eliminado del pedido.");
        }else{
        System.out.println("\nNo presentas productos para eliminar en el pedido.");
        }
    }

    private static void eliminarElPrimerProductoEncontrador(ArrayList<Producto> listaPedido,int id){
        for (int i = 0; i < listaPedido.size(); i++) {
                if (listaPedido.get(i).getId() == id) {
                listaPedido.remove(i);
         return; 
    }
  }
}

    private static Producto buscarProducto(int id, List<Producto> lista) {
    for (Producto a : lista) {
        if (id == a.getId()) {
            return a;
        }
    }
    return null; 
}

    public static void agregarProducto() {
        int id= entradaDeId("ID: ",lista);
        String nombre = entradaDeString("Nombre: ");
        double precio = entradaDeDouble("Precio :");
        Producto nuevo = new Producto(id, nombre, precio);
        lista.add(nuevo);
        System.out.println("Producto agregado.");
    }
    public static void listarProductos() {
        if (lista.isEmpty()) {
            System.out.println("No hay productos cargados.");
        } else {
            for (Producto Producto : lista) {
                Producto.mostrar();
            }
        }
    }
    public static void buscarActualizarProducto() {
        listarProductos();
        if (lista.size()!=0) {
            int id = entradaDeIdModificarYeliminar("ID del producto a modificar[0 para salir]: ",lista);
            if(id!=0){
            for (Producto a : lista) {
                if (a.getId()== id) {
                     a.setNombre(entradaDeString("Nuevo nombre: "));
                     a.setPrecio(entradaDeDouble("Nuevo precio: "));
                    System.out.println("Producto actualizado.");
                    return;
                }
            }
            }  else{
                System.out.println("Saliendo..");
            }
        }else{
            System.out.println("No presentas producto para modificar.");
        }
   
      
        
    }
    public static void eliminarProducto() {
        listarProductos();
        if (lista.size()!=0) {
        int idAEliminar = entradaDeIdModificarYeliminar("ID del Producto a eliminar[0 para salir]: ",lista);
        lista.removeIf(ProductoLista -> ProductoLista.getId()== idAEliminar);
        if (idAEliminar==0){
            System.out.println("Saliendo..");
        }else{
             System.out.println("Producto eliminado.");
        }
    
        }else{
            System.out.println("No presentas productos para eliminar.");
        }
    }
    private static int entradaDeIdModificarYeliminar(String mensaje,ArrayList<Producto> lista){

        boolean flag=true;
        int id=0;
        do{
            System.out.print(mensaje);
            try{
                 id = sc.nextInt(); sc.nextLine();
                    
                if (id<0) {
                System.out.println("¡Error! Ingresa un numero mayor a cero.");
                }else if( id!=0 && !idEstaSiendoUsado(id,lista)){
                System.out.println("¡Error! El id es inexistente");    
                 }else{
                    flag =false;
                }
            }catch(InputMismatchException  e){

                System.out.println("¡Error! Ingresa un número.");
                sc.nextLine();
            }

        }while(flag==true);

       
        return id;
    }
    private static double entradaDeDouble(String mensaje){
        boolean flag=true;
        double id=0;
        do{
            System.out.print(mensaje);
            try{
                 id = sc.nextDouble(); sc.nextLine();
                    
                if (id<=0) {
                System.out.println("¡Error! Ingresa un numero mayor a cero.");
                }else{
                    flag =false;
                }
            }catch(InputMismatchException  e){

                System.out.println("¡Error! Ingresa un precio.");
                sc.nextLine();
            }

        }while(flag==true);

       
        return id;
    }
    private static int entradaDeId(String mensaje,ArrayList<Producto> lista){
        boolean flag=true;
        int id=0;
        do{
            System.out.print(mensaje);
            try{
                 id = sc.nextInt(); sc.nextLine();
                    
                if (id<=0) {
                System.out.println("¡Error! Ingresa un numero mayor a cero.");
                }else if(idEstaSiendoUsado(id,lista)){
                System.out.println("¡Error! El id esta siendo usado");    
                
                 }else{
                    flag =false;
                }
            }catch(InputMismatchException  e){

                System.out.println("¡Error! Ingresa un número.");
                sc.nextLine();
            }

        }while(flag==true);

       
        return id;
    }
    private  static boolean idEstaSiendoUsado(int id ,ArrayList<Producto> lista){

        for (Producto Producto : lista) {
            if (Producto.getId()==id)return true;
        }
        
        return false;
    }   

    private static String entradaDeString(String mensaje){

        boolean flag=true;
        String palabra="";
        do{
            System.out.print(mensaje);
            palabra = sc.nextLine(); 
                    
                if (palabra.isEmpty()) {
                    System.out.println("¡Error! El nombre no puede estar vacío.");
                }else if (palabra.contains("  ")){
                    System.out.println("¡Error! No puede haber múltiples espacios seguidos.");
                   
                }else{
                    flag=false;
                }
      
            

        }while(flag==true);

       
        return palabra;

    }
}
