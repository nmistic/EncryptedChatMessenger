package ChatEncrypter.Cryptography;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest; // SHA-1, SHA-256 - one way secure hash functions
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64; // encoding to provide collision-less byte encoding
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher; // functionality of cryptographic cipher for encryption/decryption
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec; // secret key in provider-independent fashion. No need for SecretKeyFactory


public class AES {

    private static SecretKeySpec secretKey;
    private static byte[] key;

    public static void setKey(String myKey) {
        MessageDigest sha;
        try {
            key = myKey.getBytes("UTF-8"); // get bytes from string in utf-8 format
            sha = MessageDigest.getInstance("SHA-1"); // set sha as SHA-1 message digest
            key = sha.digest(key); // produce digest hash
            key = Arrays.copyOf(key, 16); // take 1st 16
            secretKey = new SecretKeySpec(key, "AES"); // prepare a secret key from key byte array
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.out.println("No such algorithm can be found or no such encoding is found here");
        }
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); // algorithm/mode/padding
            cipher.init(Cipher.ENCRYPT_MODE, secretKey); // cipher encr/decr mode
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))); // doFinal - multipart encr/decr based on initialization
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))); // fetch Base64 encoded string from stream, decrypt using doFinal with DECRYPT_MODE
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
}
