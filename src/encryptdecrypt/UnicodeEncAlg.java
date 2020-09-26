package encryptdecrypt;

class UnicodeEncAlg implements EncryptionStrategy {

    public String execute(String input, int key, String output) {

        char[] inputInArray = input.toCharArray();
        for (char sign : inputInArray) {
            char tempChar = (char) (sign + key);
            output += tempChar;
        }
        return output;
    }
}