package DAO.exe;

import DAO.IDAO;

public class DaoImplV2 implements IDAO {
    @Override
    public double getData() {
        System.out.println("Version web service ");
        double temp = 12;
        return temp;
    }
}
