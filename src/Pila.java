/**
 *
 * @author Keneth
 */
public class Pila {
    
    double arreglo[];
    int cima;
    
    public Pila(){
                
        arreglo = new double[10];
        cima = 0;
    }
    
    public void push(double token){
        
        if(cima < arreglo.length){
        arreglo[cima]=token;
        cima++;
     }else{
         double temp[]=new double[arreglo.length+10];
            System.arraycopy(arreglo, 0, temp, 0, arreglo.length);
         arreglo=temp;
         arreglo[cima]=token;
         cima++;
    }
    }
    /**
     *
     * @return
     */
    public double pop(){
        
        double temp=0;
        if(cima>0){
            temp = arreglo[cima-1];
            arreglo[cima-1]=0;
            cima--;
        }
        return temp;
    }
        
    
    
}
