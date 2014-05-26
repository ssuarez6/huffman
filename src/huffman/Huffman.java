package huffman;
import java.util.Scanner;
import java.util.ArrayList;
public class Huffman{
    public static void main(String[] args){
	Scanner read = new Scanner(System.in);
	String in = read.next();
	Arbol[] nodos;
        nodos = process(in);
    }
    /**
     * Metodo process, solo para esta clase y único para el main
     * @param in el string con la palabra
     * @return el arreglo de arboles para unir
     */
    private static Arbol[] process(String in){
        Arbol[] arrnodos = new Arbol[in.length()];
	for(int i=0; i<in.length();i++){
	    arrnodos[i] = new Arbol(in.charAt(i)+"", 1);
	}
	for(int i=0; i<arrnodos.length-1;i++){
            for(int j=i+1; j<arrnodos.length;j++){
                try{
                    String actual = arrnodos[i].getCaracter();
                    String tmp = arrnodos[j].getCaracter();
                    if(actual == null ? tmp == null : actual.equals(tmp)){
                        arrnodos[i].setFrecuencia(arrnodos[i].getFrecuencia()+1);
                        arrnodos[j] = null;
                    }
                }catch(Exception ex){
                    continue;
                }
            }
        }
        ArrayList<Arbol> an = new ArrayList<>();
        int t = 0;
        for (Arbol arrnodo : arrnodos) {
            if(arrnodo != null) {
                an.add(arrnodo);
            }else{
                continue;
            }
        }
        Object[] tmp = an.toArray();
        Arbol[] arr2 = new Arbol[tmp.length];
        for(int i=0;i<tmp.length;i++){
            arr2[i] = (Arbol)tmp[i];
            System.out.println("Caracter: "+arr2[i].getCaracter()+" Frecuencia:  "+arr2[i].getFrecuencia());
        }
        return arr2;
    }
    /**
     * método para ir uniendo árboles
     * @param caracs el arreglo de nodos
     * @return un arbol unico con los caracteres como hojas
     */
    private static Arbol combinate(Arbol[] caracs){
        int minor = caracs[0].getFrecuencia();
        Arbol min = caracs[0];
        int ac_minor = 0;
        for(int i=0; i<caracs.length; i++){ //hallando el primer menor
            int ac = caracs[i].getFrecuencia();
            if(ac < minor){
                minor = ac;
                ac_minor = i;
                min = caracs[i];
            }
        }
        int minor2 = caracs[1].getFrecuencia();
        Arbol min2 = caracs[1];
        for(int i=0;i<caracs.length;i++){ //hallando el segundo menor
            int ac = caracs[i].getFrecuencia();
            if(i!=ac_minor && ac<minor2 ){
                minor2 = ac;
                min2 = caracs[i];
            }
        }
        Arbol mix;
        mix = min.split(min2);
        return mix;
    }
}