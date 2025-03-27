package pres;

import DAO.IDAO;
import Metier.IMetier;
import Metier.MetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    public static void main(String[] args) throws FileNotFoundException {
        //instantiation dynamique
        try {
            Scanner sc = new Scanner(new File("cnfig.txt"));

            //DaoImpl d = new DaoImpl(); equivalent a les 3 lignes
            String daoClassename = sc.nextLine();
            //System.out.println(daoClassename); //lire la 1ere ligne de config.txt
            //instanciation dynamique
            Class cDao = Class.forName(daoClassename);//charger la classe en memoire d'un obket de type Class
            //cDao.newInstance();/cree une instance de cette classe comme un constructeur dans les novelle version on le n'utilise pas
            //Object dao =  cDao.getConstructor().newInstance();
            IDAO dao = (IDAO) cDao.getConstructor().newInstance();//cree un objet de type object et fais le caste en IDAO
            //System.out.println(dao.getData());

            // MetierImpl metier = new MetierImpl(d); equivalent a les 3ligne sauf cette declaration est statique et les 3 lignes dynamiqua
            String metirtClassename = sc.nextLine();//chercher le nom de la classe
            Class cMetier = Class.forName(metirtClassename);//chercher si cette classe est existe puis la charge en memoire
            IMetier metier = (IMetier) cMetier.getConstructor(IDAO.class).newInstance(dao);//cree un objet de cette classe et instanciation via le constructeur

            Method setDao = cMetier.getDeclaredMethod("setDao",IDAO.class);//instansiaction avec setter
            setDao.invoke(metier,dao);//invok cad execute et equivalant a metier.setDao(d);
            System.out.println("Res="+metier.calcul());

            //dans la pratique c'est pas faisable d'ecrir tous ce code c'est du copier collé le framework spring qui va s'occuper de ca  @Component
            //@autowared on le fait dans la classe metierimpl avent la declaration di idao pou isdiaue au spring de chercher un objet de type idao et l'infecter au metietr injection des deppendence automaique injection via autowired
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
