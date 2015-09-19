

package shopping.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 此類別包含了以MD5格式加密的類別方法 */
public class SavePWD {

    /**
     *這個方法可以將輸入的String參數加上一個預設字串後，
     *以MD5的格式回傳ㄧ個32位元的加密字串。
     *@param pwd 欲加密的字串
     *@return 32bit MD5 String
     */
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
     /** 
   
     */
    
}
