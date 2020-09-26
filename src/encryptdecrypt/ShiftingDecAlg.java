package encryptdecrypt;

class ShiftingDecAlg implements EncryptionStrategy {

   public String execute(String input, int key, String output) {

        char[] inputInArray = input.toCharArray();

        for (char sign : inputInArray) {
            if (sign > 96 && sign < 123) {                       // lowercase
                char tempChar = (char) (sign - key);
                if (tempChar < 97) {
                    tempChar = (char) (123 - (97 - tempChar));
                }
                output += tempChar;
            } else {                                           // uppercase
                char tempChar = (char) (sign + key);
                if (tempChar < 65) {
                    tempChar = (char) (91 - (65 - tempChar));
                }
                output += tempChar;
            }
        }
        return output;
    }
}
