import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

/*Declaracion de la clase principal Calculadora
 * @author Keneth
 */
public class Calculadora implements MenuInterface{
/**
 * Declaracion del metodo main
 * @param args 
 */
    public static void main(String[] args) {
        
        String opcion;
        System.out.println("Bienvenido a la calculadora RPN");
        Calculadora calcu = new Calculadora();
        System.out.println();
        calcu.mostrarMenu();
        
        
        
    }
    /**
     * Lista hist de tipo Historial. Almacena el historial de operaciones 
     */
    List<Historial> hist;
    /**
     * Constructor
     */
    public Calculadora() {
        hist = new ArrayList();
    }
       
    /**
     *Metodo implementado de la interface MenuInterface imprime 
     * en pantalla las opciones que el usuario puede seleccionar, 
     * recibe la seleccion y envia el parametro "opcion" al metodo menu
     */
    @Override
    public void mostrarMenu(){
        String opcion;
        Scanner scanner = new Scanner(System.in);
        Calculadora calcu = new Calculadora();
        System.out.println("Por favor ingrese el numero de opcion que desea realizar");
        System.out.println();
        System.out.println("1. Ingresar expresion");
        System.out.println("2. Imprimir el historial");
        System.out.println("3. Salir");
        System.out.println();
        opcion = scanner.next();
        calcu.menu(opcion);
    }
    

    /**
     * Metodo implementado de la Interface MenuInterface recibe el
     * parametro y ejecuta la accion correspondiente a la seleccion
     * realizada por el usuario
     * @param opcion 
     */
    
    @Override
    public void menu(String opcion){
        
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);
        switch(opcion){
            
            case "1":
                    System.out.println();
                    System.out.println("Por favor ingrese la expresion");
                    System.out.println();
                    String expresion = scanner.nextLine();
                    calc.operar(expresion);
                    break;
            case "2":
                    calc.printH();
                    calc.mostrarMenu();
                    break;
            case "3":
                    break;
            
            
        }
        
    }

    /**
     * Metodo que recibe la expresion ingresada por el usuario como parametro,
     * divide la expresion en tokens y realiza la operacion matematica, 
     * devuelve el resultado en pantalla y por ultimo invoca el 
     * metodo mostrarMenu
     * @param expresion
     */
    public void operar(String expresion) {
        
        StringTokenizer st;
        st = new StringTokenizer(expresion, " ", false);

        String token;
        Pila pila = new Pila();
        Calculadora historial = new Calculadora();
        Calculadora calcu = new Calculadora();
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            if (esNum(token)) {
                pila.push(Double.parseDouble(token)); 
            }else{
                
                if("PLUS".equals(token)){
                    double valor1=pila.pop();
                    double valor2=pila.pop();
                    double resultado=valor1+valor2;
                    pila.push(resultado);
                }
                if("LESS".equals(token)){
                    double valor1=pila.pop();
                    double valor2=pila.pop();
                    double resultado=valor2-valor1;
                    pila.push(resultado);
                }
                if("TIMES".equals(token)){
                    double valor1=pila.pop();
                    double valor2=pila.pop();
                    double resultado=valor1*valor2;
                    pila.push(resultado);
                }
                if("DIVIDE".equals(token)){
                    double valor1=pila.pop();
                    double valor2=pila.pop();
                    if(valor1==0){
                    System.out.println();    
                    System.out.println("Error: Division entre 0");
                    }
                    double resultado=valor2/valor1;
                    pila.push(resultado);
                    
                }
                
                
        }
        }
            
                if(pila.cima==1){
                double resultado = pila.pop();
                historial.saveH(expresion, resultado);
                System.out.println();
                System.out.println("Resultado:" +resultado);
                
                
        }
        System.out.println();
        calcu.mostrarMenu();
    }
    
    
    /**
     * Metodo recibe un token y determina si es un operando u operador 
     * @param token
     * @return 
     */
    public static boolean esNum(String token) {
        boolean resultado;

        try {
            Double.parseDouble(token);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;

    }
    /**
     * Metodo que almacena el historial de las expresiones y resultados en 
     * la lista hist
     * @param expresion
     * @param resultado 
     */
    
    public void saveH(String expresion, Double resultado){
        Historial dato = new Historial(expresion, resultado);
        hist.add(dato);
    }
    
    /**
     *Metodo que imprime la lista hist mostrando el historial de operaciones
     */
    public void printH(){
        Calculadora calcu = new Calculadora();
        for(int i=0; i<hist.size(); i++){
           Historial temp = hist.get(i);
           System.out.println(temp.getExpresion()+ " = " + temp.getResultado());
        }
        calcu.mostrarMenu();
    }
    
    /**
     * Metodo que envia el historial de operaciones a un archivo de texto
     * @throws IOException 
     */
    private void writeToFile() throws IOException {
        FileWriter fileWriter;
        
            fileWriter = new FileWriter("historial-Calculadora.txt");
        try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (int i = 0; i < hist.size(); i++) {
                Historial aux = hist.get(i);
                printWriter.println(aux.getExpresion() + " = " + aux.getResultado());
            }
        }
        } 

    }
    
    

       


