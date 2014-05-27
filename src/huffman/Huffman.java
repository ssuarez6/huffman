package huffman;
import java.util.ArrayList;
public class Huffman{
    /**
     * Metodo para dividir el string en arboles
     * @param in El string con la palabra
     * @return El arreglo de arboles, despues se unen
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
        if(caracs.length == 1) return caracs[0];
        else{
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
            int ac_minor2 = 1;
            for(int i=0;i<caracs.length;i++){ //hallando el segundo menor
                int ac = caracs[i].getFrecuencia();
                if(i!=ac_minor && ac<minor2 ){
                    minor2 = ac;
                    min2 = caracs[i];
                    ac_minor2 = i;
                }
            }
            Arbol tmp = caracs[ac_minor].split(caracs[ac_minor2]);
            caracs[ac_minor] = null;
            caracs[ac_minor2] = null;
            Arbol[] out = new Arbol[caracs.length-1];
            int cont = 0;
            for (Arbol carac : caracs) {
                if (carac != caracs[ac_minor] && carac != caracs[ac_minor2]) {
                    out[cont] = carac;
                    cont++;
                }
            }
            out[out.length-1] = tmp;
            return combinate(out);
        }
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
        return tmp.recorrer("",tmp); //primera vez vacio
    }
}