/*
 * Identity Service for integration Oracle Identity Governance 12c.
 * License by HPT Corp.
 * Author: pvanh@hpt.vn
 */
package com.pows.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.management.openmbean.InvalidKeyException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author pvanh@hpt.vn
 */
public class SymmetricKeyCrypto {

    private SecretKeySpec secretKey;
    private Cipher cipher;

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(SecretKeySpec secretKey) {
        this.secretKey = secretKey;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public SymmetricKeyCrypto(String secret, int length, String algorithm)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] key = new byte[length];
        key = fixSecret(secret, length);
        this.secretKey = new SecretKeySpec(key, algorithm);
        this.cipher = Cipher.getInstance(algorithm);
    }

    private byte[] fixSecret(String s, int length) throws UnsupportedEncodingException {
        if (s.length() < length) {
            int missingLength = length - s.length();
            for (int i = 0; i < missingLength; i++) {
                s += " ";
            }
        }
        return s.substring(0, length).getBytes("UTF-8");
    }

    public String encryptString(String plan_text) throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, java.security.InvalidKeyException {
        String encryted_text = "";
        System.out.println("Encrypting String: " + plan_text);
        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        byte[] input = plan_text.getBytes();
        byte[] output = this.cipher.doFinal(input);
        encryted_text = DatatypeConverter.printBase64Binary(output);
        return encryted_text;
    }

    public String decryptString(String encrypted_text) throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, java.security.InvalidKeyException {
        String plan_text = "";
        System.out.println("Decrypting String: " + encrypted_text);
        this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
        byte[] input = DatatypeConverter.parseBase64Binary(encrypted_text);
        byte[] output = this.cipher.doFinal(input);
        plan_text = new String(output);
        return plan_text;
    }

    public void encryptFile(File f)
            throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, java.security.InvalidKeyException {
        System.out.println("Encrypting file: " + f.getName());
        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKey);
        this.writeToFile(f);
    }

    public void decryptFile(File f)
            throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, java.security.InvalidKeyException {
        System.out.println("Decrypting file: " + f.getName());
        this.cipher.init(Cipher.DECRYPT_MODE, this.secretKey);
        this.writeToFile(f);
    }

    public void writeToFile(File f) throws IOException, IllegalBlockSizeException, BadPaddingException {
        try (FileInputStream in = new FileInputStream(f)) {
            byte[] input = new byte[(int) f.length()];
            in.read(input);

            try (FileOutputStream out = new FileOutputStream(f)) {
                byte[] output = this.cipher.doFinal(input);
                out.write(output);

                out.flush();
            }
        }
    }
}
