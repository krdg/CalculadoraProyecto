
/**
 *
 * @author Keneth
 */
public class Historial {
    private String expresion;
    private double resultado;

    public Historial(String expresion, double resultado) {
        this.expresion = expresion;
        this.resultado = resultado;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
    
    
}
