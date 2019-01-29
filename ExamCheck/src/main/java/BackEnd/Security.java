/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Douglas
 */
public class Security {

    Base64.Encoder enc =  Base64.getEncoder();
    
    public byte[] getNewSalt() {
        byte[] salt = new byte[16];
        Random random = new Random();
        random.nextBytes(salt);
        
        System.out.println("GENERATED SALT: " + enc.encodeToString(salt));
        return salt;
    }

    public byte[] getSaltedHash(String password, byte[] salt) throws Exception {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory k = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");

        byte[] saltedHash = k.generateSecret(spec).getEncoded();

        System.out.println("GENERATED SALTED HASH: " + enc.encodeToString(saltedHash));
        
        return saltedHash;
    }
}
