/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package access_db_design_pattern;

/**
 *
 * @author tordeepweb
 */
public class Marque {
    private int code_marque;

    public void setCode_marque(int code_marque) {
        this.code_marque = code_marque;
    }

    public void setLibelle_marque(String libelle_marque) {
        this.libelle_marque = libelle_marque;
    }

    public int getCode_marque() {
        return code_marque;
    }

    public String getLibelle_marque() {
        return libelle_marque;
    }
    private String libelle_marque;

    public Marque(int code_marque, String libelle_marque) {
        this.code_marque = code_marque;
        this.libelle_marque = libelle_marque;
    }

    public Marque() {
    }
    
    
}
