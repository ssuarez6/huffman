package huffman;
import java.util.Scanner;
import java.util.ArrayList;
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
        ArrayList<Nodo> an = new ArrayList<Nodo>();
        int t = 0;
        for (Nodo arrnodo : arrnodos) {
            if(arrnodo != null) {
                an.add(arrnodo);
            }else{
                continue;
            }
        }
        Object[] tmp = an.toArray();
        Nodo[] arr2 = new Nodo[tmp.length];
        for(int i=0;i<tmp.length;i++){
            arr2[i] = (Nodo)tmp[i];
            System.out.println("Caracter: "+arr2[i].getCaracter()+" Frecuencia:  "+arr2[i].getFrecuencia());
        }
    }
}