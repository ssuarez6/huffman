package huffman;
public class Nodo{
    private int f; //frecuencia
    private char c; //el caracter
    /**
     *Constructor de nodo
     *@param c el caracter del nodo
     *@param f la frecuencia inicial
     **/
    public Nodo(char c, int f){
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
}