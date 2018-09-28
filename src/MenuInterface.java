/**
 *Interface MenuInterface define los metodos de menu a ser implementados
 * @author Keneth
 */
public interface MenuInterface {
    
    /**
     * Metodo que imprime el menu en pantalla y permite seleccionar la opcion 
     * deseada
     */
    public void mostrarMenu();
    
    /**
     * Metodo que ejecuta la opcion solicitada por el usuario
     * @param opcion 
     */
    public void menu(String opcion);
    
}
