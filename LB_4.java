import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CodeWars {
    public String crack(String hash) {
        for (int i = 0; i <= 99999; i++) {
            String pin = String.format("%05d", i);
            if (hash.equals(md5(pin))) {
                return pin;
            }
        }
        return null; // If no match is found
    }

    private static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        CodeWars cw = new CodeWars();
        String crackedPin = cw.crack("827ccb0eea8a706c4c34a16891f84e7b"); // Example hash for "12345"
        System.out.println("Cracked PIN: " + crackedPin);
    }
}
