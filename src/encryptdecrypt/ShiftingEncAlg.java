package encryptdecrypt;

public class ShiftingEncAlg implements EncryptionStrategy {

    public String execute(String input, int key, String output) {

        char[] inputInArray = input.toCharArray();

        for (char sign : inputInArray) {
            if (sign > 96 && sign < 123) {                       // lowercase
                char tempChar = (char) (sign + key);
                if (tempChar > 122) {
                    tempChar = (char) (96 + (tempChar - 122));
                }
                output += tempChar;
            } else if (sign > 64 && sign < 91) {               // uppercase
                char tempChar = (char) (sign + key);
                if (tempChar > 90) {
                    tempChar = (char) (64 + (tempChar - 90));
                }
                output += tempChar;
            } else {
                output += sign;
            }
        }
        return output;
    }
}