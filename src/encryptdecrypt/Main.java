package encryptdecrypt;

import static encryptdecrypt.IO.*;

class Main {
    private static String alg = "shift";
    private static String mode = "enc";
    private static int key = 0;
    private static String data = "";
    private static String output = "";
    private static String fromFilePath = "";
    private static String toFilePath = "";
    private static boolean dataFromConsole = false;
    private static boolean dataToConsole = true;


    static int getKey() {
        return key;
    }

    static void setOutput(String text) {
        output = text;
    }

    static String getOutput() {
        return output;
    }

    static void setData(String text) {
        data = text;
    }

    static String getData() {
        return data;
    }

    static String getToFilePath() {
        return toFilePath;
    }

    static boolean isDataToConsole() {
        return dataToConsole;
    }

    static void main(String[] args) {

        //simple test
       // args = new String[]{"-mode", "dec", "-alg", "unicode", "-key", "5", "-data", "\\jqhtrj%yt%m~ujwxpnqq&"};


        for (int i = 0; i < args.length - 1; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    dataFromConsole = true;
                    break;
                case "-in":
                    if (!dataFromConsole) {
                        for (int j = i; j < args.length - 1; j++) {
                            if (args[j].equals("-data")) {
                                dataFromConsole = true;
                                break;
                            }
                        }
                        while (!dataFromConsole) {
                            fromFilePath = args[i + 1];
                            break;
                        }
                    }
                    break;
                case "-out":
                    toFilePath = args[i + 1];
                    dataToConsole = false;
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }

        if (!dataFromConsole) {
            ReadFromFile(fromFilePath);
        }

        AlgorithmContext context = new AlgorithmContext();

        if ("enc".equals(mode) && "unicode".equals(alg)) {
            context.set(new UnicodeEncAlg());
            context.process();
        } else if ("enc".equals(mode) && "shift".equals(alg)) {
            context.set(new ShiftingEncAlg());
            context.process();
        } else if ("dec".equals(mode) && "unicode".equals(alg)) {
            context.set(new UnicodeDecAlg());
            context.process();
        } else if ("dec".equals(mode) && "shift".equals(alg)) {
            context.set(new ShiftingDecAlg());
            context.process();
        }
    }
}