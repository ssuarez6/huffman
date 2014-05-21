package huffman;
public class Arbol{
    private int f; //frecuencia
    private char c; //el caracter
    private Arbol derecho;
    private Arbol izquierdo;

    
    private int numIzq, numDer;//izq: 0 der: 1
    /**
     *Constructor de nodo
     *@param c el caracter del nodo
     *@param f la frecuencia inicial
     **/
    public Arbol(char c, int f){
	this.c = c;
	this.f = f;
    }
    /**
     *Getter del caracter
     *@return el caracter de este nodo
     **/
    public char getCaracter(){
	return this.c;
    }
    /**
     *Getter de la frecuencia
     *@return int f la frecuencia
     */
    public int getFrecuencia(){
	return this.f;
    }
    /**
     *Setter para el caracter
     *@param c el nuevo caracter
     */
    public void setCaracter(char c){
	this.c = c;
    }
    /**
     *Setter para la frecuencia
     *@param f la nueva frecuencia
     */
    public void setFrecuencia(int f){
	this.f = f;
    }
    public Arbol getDerecho() {
        return derecho;
    }

    public Arbol getIzquierdo() {
        return izquierdo;
    }

    public void setDerecho(Arbol derecho) {
        this.derecho = derecho;
    }

    public void setIzquierdo(Arbol izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    /**
     * Metodo split para juntar dos arboles
     * @param n Nodo con el que se juntara
     * @return un arbol raiz con este y el otro de hijos
     */
    public Arbol split(Arbol n){
        Arbol raiz = new Arbol('_',this.getFrecuencia()+n.getFrecuencia());
        if(this.getFrecuencia() < n.getFrecuencia()){
            raiz.setIzquierdo(this);
            raiz.setDerecho(n);
        }else{
            raiz.setIzquierdo(n);
            raiz.setDerecho(this);
        }
        return raiz;
    }
}