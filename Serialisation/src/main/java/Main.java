
import java.io.IOException;

public class Main{

    public static void main(String args[]) {
        DataValueObject dataValueObject = new DataValueObject();
        dataValueObject.setCustomer("Debbie");
        dataValueObject.setBusiness("JAVA Concepts");
        dataValueObject.setContractID("ZZZZZZ");
        dataValueObject.setPassKeys("!@wer#$");

        try {
            Serilisation.serialization("fileToSave.txt", dataValueObject);
            DataValueObject object = (DataValueObject) Serilisation.deSerialization("fileToSave.txt");
            System.out.println(object.toString());
        } catch (IOException exp) {
            exp.printStackTrace();
        } catch (ClassNotFoundException exp) {
            exp.printStackTrace();
        }
    }

}