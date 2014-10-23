/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access_db_design_pattern;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tordeepweb
 */
public class MarqueManager {

    public boolean ajouterMarque(Marque m) {
        SingletonData mSD = SingletonData.getSingletonData();
        int ret = mSD.requeteAction("insert into marque values (null,'" + m.getLibelle_marque() + "')");
        return ret == 1;
    }

    public boolean supprimerMarque(Marque m) {
        SingletonData mSD = SingletonData.getSingletonData();
        int ret = mSD.requeteAction("delete from marque where code_marque =" + m.getCode_marque());

        return ret == 1;
    }

    public Marque obtenirMarque(int code_marque) {
        try {
            SingletonData mSD = SingletonData.getSingletonData();
            ResultSet marqueRetournee = mSD.requeteSelection("select * from marque where code_marque =" + code_marque);
            
            if (marqueRetournee.next()) {
                Marque objMarque = new Marque();
                objMarque.setCode_marque(marqueRetournee.getInt("code_marque"));
                objMarque.setLibelle_marque(marqueRetournee.getString("libelle_marque"));
                return objMarque;
                
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarqueManager.class.getName()).log(Level.SEVERE, null, ex);
        }
return null;
    }
}
