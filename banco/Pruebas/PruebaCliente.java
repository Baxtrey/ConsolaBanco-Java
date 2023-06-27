package banco.Pruebas;

import banco.modelos.Cliente;

public class PruebaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1, "Paco", "1234", "correo1@correo.es", 200.0, 1);
        Cliente cliente2 = new Cliente(2, "María", "5678", "correo2@correo.es", 500.0, 1);
        Cliente cliente3 = new Cliente(3, "Juan", "abcd", "correo3@correo.es", 1000.0, 1);
        Cliente cliente4 = new Cliente(4, "Luisa", "efgh", "correo4@correo.es", 150.0, 1);
        Cliente cliente5 = new Cliente(5, "Carlos", "ijkl", "correo5@correo.es", 300.0, 1);
        
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
        System.out.println(cliente4);
        System.out.println(cliente5);
    }
}
