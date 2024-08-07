package ui;
import entities.Product;
import entities.ProductDao;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();

        // Crear un nuevo producto
        Product newProduct = new Product(0, "Laptop", "High performance laptop", 999.99, 10, true);

        try {
            // Agregar el producto a la base de datos
            productDao.addProduct(newProduct);
            System.out.println("Producto insertado exitosamente.");

            // Obtener y mostrar todos los productos
            System.out.println("Lista de todos los productos:");
            for (Product product : productDao.getAllProducts()) {
                System.out.println(product);
            }

            // Obtener y mostrar un producto por ID
            Product productById = productDao.getProduct(1);
            if (productById != null) {
                System.out.println("Producto con ID 1: " + productById);
            } else {
                System.out.println("No se encontró el producto con ID 1.");
            }

            // Actualizar un producto
            if (productById != null) {
                productById.setPrice(899.99);
                productDao.updateProduct(productById);
                System.out.println("Producto actualizado: " + productById);
            }

            // Eliminar un producto por ID
            productDao.deleteProduct(1);
            System.out.println("Producto con ID 1 eliminado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
