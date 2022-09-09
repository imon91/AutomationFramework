package Core;

import java.io.File;

public class FilePath {
    public static final String dir = System.getProperty("user.dir");
    static File f = new File(dir);
    static String filepath = f.getParent();
    public static final String FileBathInCore = filepath+"/AutomationFramework/src/main/java/repository/localRepo/";
    public static final String createVAFilepath = FileBathInCore+"CreateVAFormat.json";
    public static final String idReaderPath = FileBathInCore+"id.txt";
    public static final String updateDateFilepath = FileBathInCore+"UpdateDateFormat.json";
    public static final String updateDateReaderFilepath = FileBathInCore+"date.txt";
    public static final String externalIdFilepath = FileBathInCore+"externalId.txt";

    public static final String paymentVAFilepath = FileBathInCore+"PaymentVAFormat.json";

}


