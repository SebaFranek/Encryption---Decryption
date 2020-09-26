package encryptdecrypt;

import static encryptdecrypt.Main.*;
import static encryptdecrypt.IO.*;

class AlgorithmContext {                //  S T R A T E G Y   C O N T E X T

    private EncryptionStrategy strategy;

    void set(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

    void process() {
        String data = strategy.execute(getData(), getKey(), getOutput());
        setOutput(data);
        if (isDataToConsole()) {
            TerminalMessage(getOutput());
        } else {
            WriteToFile(getToFilePath(), getOutput());
        }
    }
}
