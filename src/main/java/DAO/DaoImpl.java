package DAO;

public class DaoImpl implements IDAO {
    @Override
    public double getData() {
        System.out.println("version base de données");
        double temp = 23;
        return temp;
    }
}
