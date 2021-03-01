import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.file.Files;
import java.nio.file.Paths;
// BEGIN SOLUTION
// please import only standard libraries and make sure that your code compiles and runs without unhandled exceptions 
// END SOLUTION
 
public class HW1 {    
  static void Problem1() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher1.bin"));
    
    // BEGIN SOLUTION
    byte[] key = new byte[] { 0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0, 
                              0, 0, 0, 0 };
    byte[] plainText = cipherText;    
    // END SOLUTION
    
    Files.write(Paths.get("plain1.txt"), plainText);
  }

  static void Problem2() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher2.bin"));
    
    // BEGIN SOLUTION
    byte[] modifiedCipherText = cipherText;
    byte[] plainText = modifiedCipherText;
    // END SOLUTION
    
    Files.write(Paths.get("plain2.txt"), plainText);
  }

  static void Problem3() throws Exception {
    byte[] cipherBMP = Files.readAllBytes(Paths.get("cipher3.bmp"));
    byte[] otherBMP = Files.readAllBytes(Paths.get("msg3.bmp"));
    
    // BEGIN SOLUTION
    byte[] modifiedCipherBMP = cipherBMP;
    // END SOLUTION
    
    Files.write(Paths.get("cipher3_modified.bmp"), modifiedCipherBMP);
  }

  static void Problem4() throws Exception {
    byte[] plainTextA = Files.readAllBytes(Paths.get("plain4A.txt"));
    byte[] cipherTextA = Files.readAllBytes(Paths.get("cipher4A.bin"));
    byte[] cipherTextB = Files.readAllBytes(Paths.get("cipher4B.bin"));
    
    // BEGIN SOLUTION
    byte[] plainTextB = cipherTextB;
    // END SOLUTION
    
    Files.write(Paths.get("plain4B.txt"), plainTextB);
  }

  static void Problem5() throws Exception {
    byte[] cipherText = Files.readAllBytes(Paths.get("cipher5.bin"));
    
    // BEGIN SOLUTION
    byte[] plainText;
    byte[] key = new byte[] {   0,   0,    0,   0, 
                                0,   0,    0,   0,
                                0,   0,    0,   0,
                                0,   0,    0,   0 }; 
    plainText = cipherText;
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
