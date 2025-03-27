package DAO;

public interface IDAO { //couche ferme a la modification car la classe dao implementation  ne depend pas des autres classes et ouverte a l'extension car on a une interface et on peut cree une classe qui l'implemente

    public double getData();

}
