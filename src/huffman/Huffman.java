package huffman;
import java.util.Scanner;
public class Huffman{
    public static void main(String[] args){
	Scanner read = new Scanner(System.in);
	String in = read.next();
	Nodo[] arrnodos = new Nodo[in.length()];
	for(int i=0; i<in.length();i++){
	    arrnodos[i] = new Nodo(in.charAt(i), 1);
	}
	for(int i=0; i<arrnodos.length-1;i++){
            for(int j=i+1; j<arrnodos.length;j++){
                try{
                    char actual = arrnodos[i].getCaracter();
                    char tmp = arrnodos[j].getCaracter();
                    if(actual == tmp){
                        arrnodos[i].setFrecuencia(arrnodos[i].getFrecuencia()+1);
                        arrnodos[j] = null;
                    }
                }catch(Exception ex){
                    continue;
                }
            }
        }
	for(int i=0; i<arrnodos.length;i++){
	    try{
		System.out.println("Caracter:\t"+arrnodos[i].getCaracter());
		System.out.println("Frecuencia:\t"+arrnodos[i].getFrecuencia());
	    }catch(Exception ex){
		continue;
	    }
	}
    }
}