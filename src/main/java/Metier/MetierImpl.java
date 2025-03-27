package Metier;

import DAO.IDAO;

public class MetierImpl implements IMetier {
    //couplage faible
    private IDAO dao;// par default val null et je ne sais pas est ce que c'est daoimpl ou daoimplv2
    // private IDAO dao = new DaoImpl();je oeux implementer a dao un objet de type daoimpl et daoimplv2


    public MetierImpl() {
    }

    public MetierImpl(IDAO dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double t = dao.getData();//exeption nullpointerexeption cad on a pas satisfait les dependences
        double res = t*23;
        return res;
    }

    //injecter dans la variable un objet d'une classe qui implement l'interface IDao
    public void setDao(IDAO dao) {
        this.dao = dao;
    }
}
