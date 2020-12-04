package ProgramLogic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Connector {

    public void writeObject(Object object) {
        String file = object.getClass().getSimpleName();
        file = file.concat(".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void writeObject(String fileName, Object object) {
        fileName = fileName.concat(".dat");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public Object extractObject(Object object){
        String file = object.getClass().getSimpleName();
        file = file.concat(".dat");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            object = (Object) ois.readObject();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return object;
    }

    public Object extractObject(String fileName, Object object){
        fileName = fileName.concat(".dat");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            object = (Object) ois.readObject();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return object;
    }

}
