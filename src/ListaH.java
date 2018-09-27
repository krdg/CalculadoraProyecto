import java.util.*;

/**
 *
 * @author Keneth
 */
public class ListaH {
    
    List<Historial> hist;

    public ListaH() {
        hist = new ArrayList();
    }
    
    public void saveH(String expresion, Double resultado){
        Historial dato = new Historial(expresion, resultado);
        hist.add(dato);
    }
    
    /**
     *
     */
    public void printH(){
        Calculadora calcu = new Calculadora();
        for(int i=0; i<hist.size(); i++){
           Historial temp = hist.get(i);
           System.out.println(temp.getExpresion()+ " = " + temp.getResultado());
        }
        calcu.mostrarMenu();
    }
    
    }
