/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopping.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SavePWD {

    public static String encode(String pwd) {
        pwd = pwd + "shop";
        StringBuffer hexString = null;
        try {
            MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
            mdAlgorithm.update(pwd.getBytes());
            byte[] digest = mdAlgorithm.digest();
            hexString = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                pwd = Integer.toHexString(0xFF & digest[i]);

                if (pwd.length() < 2) {
                    pwd = "0" + pwd;
                }
                hexString.append(pwd);
            }
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SavePWD.class.getName()).log(Level.SEVERE, null, ex);
        }return hexString.toString();
    }
    
}
