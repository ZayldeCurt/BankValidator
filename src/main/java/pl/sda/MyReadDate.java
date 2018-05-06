package pl.sda;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadIssuer {

    public static MyGeneral readIssuer(String path){
        MyFileReader reader = FileReaderFactory.produce(path);
        MyGeneral dateSets=new MyGeneral();
        try {
            dateSets = reader.readData(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dateSets;
    }


}
