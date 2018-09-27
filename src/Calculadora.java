import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

/*
 * @author Keneth
 */
public class Calculadora {

    public static void main(String[] args) {
        
        String opcion;
        System.out.println("Bienvenido a la calculadora RPN");
        Calculadora calcu = new Calculadora();
        System.out.println();
        calcu.mostrarMenu();
        
        
        
    }
    
    List<Historial> hist;
    
    public Calculadora() {
        hist = new ArrayList();
    }
       
    /**
     *
     */
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
    


    
    public void menu(String opcion){
        
        ListaH historial = new ListaH();
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
     *
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
    
    

       


