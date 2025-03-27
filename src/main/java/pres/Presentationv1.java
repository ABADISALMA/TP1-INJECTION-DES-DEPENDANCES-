package pres;

import DAO.DaoImpl;
import DAO.exe.DaoImplV2;
import Metier.MetierImpl;

import java.lang.invoke.MethodHandle;

public class Presentationv1 {//n'est pas fermé a la modification cad ouverte a la modification car dans la classe presentation on utilise les classe couplage fort la seule place ou je peux fair la modification
    public static void main(String[] args) {
        //Injection des dependance par instanciation statique cad on utilise new
        //DaoImpl d = new DaoImpl();
        DaoImplV2 d = new DaoImplV2();//new cad couplage fort donc app ouverte a la modification donc on va utilisé instanciation dynamique dans un fichier config.txt pour evité new
        //le bn developpement un code on a pas de new
        MetierImpl metier = new MetierImpl(d);//injection via constructeur
        //metier.setDao(d); injection via le setter
        System.out.println("Res="+metier.calcul());

    }

}
