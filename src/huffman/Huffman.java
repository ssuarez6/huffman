package huffman;
import java.util.ArrayList;
public class Huffman{
    /**
     * Metodo para dividir el string en arboles
     * @param in El string con la palabra
     * @return El arreglo de arboles, con cada caracter y su frecuencia
     */
    public Arbol[] process(String in){
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
                        int actmp = arrnodos[i].getFrecuencia()+1;
                        arrnodos[i].setFrecuencia(actmp);
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
        }
        return arr2;
    }
    /**
     * Método para generar el árbol general con cada caracter como hoja
     * @param caracs el arreglo de nodos
     * @return un arbol unico con los caracteres como hojas
     */
    public Arbol combinate(Arbol[] caracs){
        if(caracs.length==1) return caracs[0];
        else{
            ordenar(caracs);
            Arbol[] tmp = new Arbol[caracs.length-1];
            int cont=0;
            for(int i=2;i<caracs.length;i++){
                tmp[cont] = caracs[i];
                cont++;
            }
            Arbol raiz;
            int sumfre = caracs[0].getFrecuencia()+caracs[1].getFrecuencia();
            raiz = new Arbol("null",sumfre);
            raiz.setIzquierdo(caracs[0]);
            raiz.setDerecho(caracs[1]);
            caracs[0].setPadre(raiz);
            caracs[1].setPadre(raiz);
            tmp[tmp.length-1] = raiz;
            return combinate(tmp);
        }
    }
    /**
     * Ordena un arreglo de arboles por su frecuencia de menor a mayor
     * @param aa arreglo de arboles
     */
    public static void ordenar(Arbol[] aa){
        try{
        for(int i=1;i<=aa.length;i++){
            for(int j=0; j<= aa.length-i;j++){  //bubble sort
                int ac = aa[j].getFrecuencia();
                int ac1 = aa[j+1].getFrecuencia();
                if(ac > ac1){
                    Arbol aux;
                    aux = aa[j];
                    aa[j] = aa[j+1];
                    aa[j+1] = aux;
                }
            }
        }
        }catch(Exception ex){}
    }
    /**
     * Metodo que utiliza los dos anteriores y devuelve el huffman
     * @param in String con la entrada
     * @return un string con el codigo huffman
     */
    public String execute(String in){
        Arbol tmp;
        Arbol[] arrtmp;
        arrtmp = this.process(in);
        tmp = combinate(arrtmp);
        String[] arrcodigos = new String[in.length()];
        String codigo = "";
        for(int i=0; i<in.length();i++){
            try{
                arrcodigos[i] = tmp.recorrer(in.charAt(i)+"", tmp, "");
                codigo = codigo + arrcodigos[i];
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        return codigo;
    }
}