//
// EvgeniiLitvinovHW1_1827937.java
// COSC3360 - 3371
// Purpouse for this assigment: Learn how to use cryptoCipher,crypto.spec libraries.
// Code was written in Java language.
// Created by Evgenii Litvinov on 02/23/21.
//

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.file.Files;
import java.nio.file.Paths;
// BEGIN SOLUTION

import java.util.Arrays;
import java.nio.ByteBuffer;

// please import only standard libraries and make sure that your code compiles and runs without unhandled exceptions 
// END SOLUTION
 
public class Main {    
  static void Problem1() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher1.bin"));
    
    // BEGIN SOLUTION
    byte[] key = new byte[] { 0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0 };
    byte[] key1 = new byte[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    SecretKeySpec keybytes = new SecretKeySpec(key1, "AES");
     IvParameterSpec ivspec = new IvParameterSpec(key);
    Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
    cipher.init(Cipher.DECRYPT_MODE,keybytes,ivspec);
    byte[] plainText = cipher.doFinal(cipherText);    
    // END SOLUTION
    
    Files.write(Paths.get("plain1.txt"), plainText);
  }
//converting
  public static String convertBytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte temp : bytes) {
            result.append(String.format("%02x", temp));
        }
        return result.toString();
    }

  static void Problem2() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher2.bin"));
    
    // BEGIN SOLUTION
    byte[] modifiedCipherText = cipherText;
    System.out.println(+ modifiedCipherText.length);
    System.out.println("Input (Hex)    : " + convertBytesToHex(modifiedCipherText));
    byte[] cipher2 = new byte[16];    
    byte[] nonce2 = new byte[16];
    byte[] extra2 = new byte[16];
  
    System.arraycopy(modifiedCipherText, 0, cipher2, 0, cipher2.length);
    System.arraycopy(modifiedCipherText, cipher2.length, nonce2, 0, nonce2.length);
    System.arraycopy(modifiedCipherText, nonce2.length + cipher2.length, extra2, 0, extra2.length);

    System.out.println("\n--- System.arraycopy ---");
    System.out.println("Cipher2 (Hex)  : " + convertBytesToHex(cipher2));
    System.out.println("Nonce2  (Hex)  : " + convertBytesToHex(nonce2));
    System.out.println("extra2  (Hex)  : " + convertBytesToHex(extra2));


    byte[] result = new byte[extra2.length + nonce2.length];
    System.arraycopy(extra2, 0, result, 0, extra2.length);
    System.arraycopy(nonce2, 0, result, extra2.length, nonce2.length);
    //System.out.println("result2 (Hex)  : " + convertBytesToHex(result));

    byte[] final1 = new byte[result.length + cipher2.length];
    System.arraycopy(result, 0, final1, 0, result.length);
    System.arraycopy(cipher2, 0, final1, result.length, cipher2.length);
    System.out.println("final1 (Hex)  : " + convertBytesToHex(final1));

    System.out.println(+ cipher2.length);
    byte[] key = new byte[] { 0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0 };
    byte[] key1 = new byte[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    SecretKeySpec keybytes = new SecretKeySpec(key1, "AES");
    IvParameterSpec ivspec = new IvParameterSpec(key);
    Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
    cipher.init(Cipher.DECRYPT_MODE,keybytes,ivspec);
    byte[] plainText = cipher.doFinal(final1);

    // END SOLUTION
    
    Files.write(Paths.get("plain2.txt"), plainText);
  }



  static void Problem3() throws Exception {
    byte[] cipherBMP = Files.readAllBytes(Paths.get("cipher3.bmp"));
    byte[] otherBMP = Files.readAllBytes(Paths.get("msg3.bmp"));
  
    // BEGIN SOLUTION
    byte[] modifiedCipherBMP = cipherBMP;

    System.out.println(+ cipherBMP.length);
    System.out.println(+ otherBMP.length);

    for(int i = 0; i< 10000; i ++)
    {
      modifiedCipherBMP[i] = otherBMP[i];
    }

    // END SOLUTION
    
    Files.write(Paths.get("cipher3_modified.bmp"), modifiedCipherBMP);
  }

  static void Problem4() throws Exception {
    byte[] plainTextA = Files.readAllBytes(Paths.get("plain4A.txt"));
    byte[] cipherTextA = Files.readAllBytes(Paths.get("cipher4A.bin"));
    byte[] cipherTextB = Files.readAllBytes(Paths.get("cipher4B.bin"));
  
    // BEGIN SOLUTION
    byte[]result = new byte[cipherTextB.length];
    for (int i = 0; i < cipherTextB.length; i++) {
        result[i] = (byte) ((plainTextA[i]) ^ (cipherTextA[i]) ^ (cipherTextB[i]));    
    }
    byte[] plainTextB = result;

    // END SOLUTION
    
    Files.write(Paths.get("plain4B.txt"), plainTextB);
  }

  static void Problem5() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher5.bin"));
    
    // BEGIN SOLUTION
    byte[] key = new byte[] { 0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0 };
    byte[] key1 = new byte[16];

    for (int i = 1; i <=12 ; i++) {
      key[0]=(byte)(i);
      // inner loop prints days
      for (int j = 1; j <=31 ; j++) {
        key[1]=(byte)(j);
        for (int z = 0; z <=99 ; z++) {
          key[2]=(byte)(z);
          cipher.init(Cipher.DECRYPT_MODE,keybytes,ivspec);
          for (int y = 0; i < keybytes.length; i++) {
        result[i] = (byte) ((plainTextA[i]) ^ (cipherTextA[i]) ^ (cipherTextB[i]));   
        //I got that I nee to check every singl byte from 0 - 128 and use IF else statemant
    }
      }
      }
    }
    SecretKeySpec keybytes = new SecretKeySpec(key, "AES");
    IvParameterSpec ivspec = new IvParameterSpec(key1);
    Cipher cipher = Cipher.getInstance("AES/CBC/NOPADDING");
    
    byte[] plainText = cipher.doFinal(cipherText); 
    // END SOLUTION
    
    Files.write(Paths.get("plain5.txt"), plainText);
  }

  public static void main(String [] args) {
    try {  
      Problem1();
      Problem2();
      Problem3();
      Problem4();
      Problem5();
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}