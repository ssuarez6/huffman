package huffman;
public class Arbol{
    private int f; //frecuencia
    private String c; //el caracter
    private Arbol derecho;
    private Arbol izquierdo;
    private Arbol padre;

    
    private int numIzq, numDer;//izq: 0 der: 1
    /**
     *Constructor de nodo
     *@param c el caracter del nodo
     *@param f la frecuencia inicial
     **/
    public Arbol(String c, int f){
	this.c = c;
	this.f = f;
    }
    /**
     *Getter del caracter
     *@return el caracter de este nodo
     **/
    public String getCaracter(){
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
    public void setCaracter(String c){
	this.c = c;
    }
    /**
     *Setter para la frecuencia
     *@param f la nueva frecuencia
     */
    public void setFrecuencia(int f){
	this.f = f;
    }
    /**
     * getter para el hijo derecho
     * @return Arbol hijo derecho
     */
    public Arbol getDerecho() {
        return derecho;
    }
    
    /**
     * getter para el hijo izquierdo
     * @return Arbol hijo izquierdo
     */
    public Arbol getIzquierdo() {
        return izquierdo;
    }

    /**
     * setter para el hijo derecho
     * @param derecho el nuevo hijo
     */
    public void setDerecho(Arbol derecho) {
        this.derecho = derecho;
    }

    /**
     * setter para el hijo izquierdo de este arbol
     * @param izquierdo el nuevo hijo izquierdo
     */
    public void setIzquierdo(Arbol izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    /**
     * Getter para el padre
     * @return el padre
     */
    public Arbol getPadre(){
        return this.padre;
    }
    
    /**
     * Setter para el padre
     * @param padre el nuevo padre
     */
    public void setPadre(Arbol padre){
        this.padre=padre;
    }
    
    /**
     * Metodo para saber si este nodo es hoja
     * @return true si es hoja
     */
    public boolean esHoja(){
        return (this.derecho==null && this.izquierdo==null);
    }
    
    /**
     * Metodo split para juntar dos arboles
     * @param n Nodo con el que se juntara
     * @return un arbol raiz con este y el otro de hijos
     */
    public Arbol split(Arbol n){
        Arbol raiz = new Arbol("",this.getFrecuencia()+n.getFrecuencia());
        if(this.getFrecuencia() < n.getFrecuencia()){
            raiz.setIzquierdo(this);
            this.setPadre(raiz);
            raiz.setDerecho(n);
            n.setPadre(raiz);
        }else{
            raiz.setIzquierdo(n);
            n.setPadre(raiz);
            raiz.setDerecho(this);
            n.setPadre(raiz);
        }
        return raiz;
    }
}