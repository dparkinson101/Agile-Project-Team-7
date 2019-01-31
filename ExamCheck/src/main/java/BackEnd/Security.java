/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author Douglas
 */
public class Security {

    Base64.Encoder enc = Base64.getEncoder();
    Base64.Decoder dec = Base64.getDecoder();

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

    public String convertObjectToEncodedBase64(Object instance, String sessionVar) {
        String base64;

        byte[] permBytes = convertObjectToByteArray(instance);
        byte[] sessionVarBytes = sessionVar.getBytes();

        byte[] byteBase64 = xorByteArrays(permBytes, sessionVarBytes);

        base64 = enc.encodeToString(byteBase64);

        return base64;
    }

    public Object convertEncodedBase64ToObject(String base64, String sessionVar) {
        Object obj;
        
        if(base64 == null || sessionVar == null || base64.equals("") || sessionVar.equals("")){
            return null;
        }

        byte[] encodedBytes = dec.decode(base64);
        byte[] sessionVarBytes = sessionVar.getBytes();
        
        byte[] decodedBytes = xorByteArrays(encodedBytes, sessionVarBytes);
        
        obj = convertByteArrayToObject(decodedBytes);
        
        return obj;
    }

    public byte[] convertObjectToByteArray(Object instance) {
        byte[] bytes = null;

        //Converts Instance to Byte[] 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(instance);
            out.flush();
            bytes = bos.toByteArray();

        } catch (IOException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }

        return bytes;
    }

    public Object convertByteArrayToObject(byte[] bytes) {
        Object obj = null;

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            obj = in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
                System.out.println(ex);
            }
        }

        return obj;
    }

    public byte[] xorByteArrays(byte[] a, byte[] b) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ b[i % b.length]);
        }
        return out;
    }
}
