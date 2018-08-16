/*
 * Identity Service for integration Oracle Identity Governance 12c.
 * License by HPT Corp.
 * Author: pvanh@hpt.vn
 */
package com.pows.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.management.openmbean.InvalidKeyException;

/**
 *
 * @author pvanh@hpt.vn
 */
public class TestCrypto {
// change "test" to "main" when need do a test

    public static void test(String[] args) {
        SymmetricKeyCrypto ske;

        try {
            ske = new SymmetricKeyCrypto("!@#$MySecr3tPassw0rd", 16, "AES");
            String source_text = "Hpt123456";
            String encVal = "";
            String decVal = "";
            try {
                encVal = ske.encryptString(source_text);
            } catch (InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException | java.security.InvalidKeyException ex) {
                Logger.getLogger(TestCrypto.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Ket qua ma hoa: " + encVal);
            if (encVal.equals("")) {
                System.out.println("Ma hoa that bai.");
            } else {
                try {
                    decVal = ske.decryptString(encVal);
                } catch (InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException | java.security.InvalidKeyException ex) {
                    Logger.getLogger(TestCrypto.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ket qua giai ma: " + decVal);
            }
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            Logger.getLogger(TestCrypto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
