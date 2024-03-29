package ChatEncrypter.Cryptography;

import java.util.Base64; // encoding to provide collision-less byte encoding
import javax.crypto.Cipher; // functionality of cryptographic cipher for encryption/decryption
import javax.crypto.SecretKey; //
import javax.crypto.spec.SecretKeySpec; // secret key in provider-independent fashion. No need for SecretKeyFactory

public class DES {
  private static Cipher ecipher;

  private static Cipher dcipher;
  
  public static String encrypt(String str,String key) throws Exception {
    // Encode the string into bytes using utf-8
    ecipher = Cipher.getInstance("DES"); // create DES cipher object
    byte[] decodedKey = Base64.getDecoder().decode(key);
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");
    ecipher.init(Cipher.ENCRYPT_MODE, originalKey);
    ecipher.init(Cipher.ENCRYPT_MODE, originalKey);
    byte[] utf8 = str.getBytes("UTF8");

    // Encrypt
    byte[] enc = ecipher.doFinal(utf8);

    // Encode bytes to base64 to get a string
    return new sun.misc.BASE64Encoder().encode(enc);
  }

  public static String decrypt(String str,String key) throws Exception {
    // Decode base64 to get bytes
    dcipher = Cipher.getInstance("DES");
    byte[] decodedKey = Base64.getDecoder().decode(key);
    SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES"); 
    dcipher.init(Cipher.DECRYPT_MODE, originalKey);
    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

    byte[] utf8 = dcipher.doFinal(dec);

    // Decode using utf-8
    return new String(utf8, "UTF8");
  }
}
