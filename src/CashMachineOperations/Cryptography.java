package CashMachineOperations;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aracorn on 25.12.16.
 */
public class Cryptography {
        public static String encrypt(String pin)
        {
            String encryptPin="";
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(pin.getBytes());

                byte byteData[] = md.digest();
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }

                encryptPin=sb.toString();
            } catch (NoSuchAlgorithmException ex) {
                ex.printStackTrace();
            }
            return encryptPin;
        }
}
