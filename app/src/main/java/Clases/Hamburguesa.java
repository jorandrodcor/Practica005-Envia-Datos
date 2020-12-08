package Clases;

import java.io.Serializable;
public class Hamburguesa implements Serializable{
    private String tipo;
    private boolean cebolla;
    private String cantham;

    public Hamburguesa(String tipo, boolean cebolla, String cantham){
        this.tipo = tipo;
        this.cebolla = cebolla;
        this.cantham = cantham;
    }

    public String getTipo(){return tipo;}
    public String getCantHam(){return cantham;}
    public boolean getCebolla(){return cebolla;}

}//Cierre clase Hamburguesa
