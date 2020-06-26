package ro.ionutscheianu.tsp.input;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class FileReader {

    private FileReader(){

    }

    public static List<String> readLinesFromTextFile(String path) {
        List<String> result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new DataInputStream(new FileInputStream(path))))) {
            String readString;
            result = new ArrayList<>();
            while ((readString = bufferedReader.readLine()) != null) {
                result.add(readString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result == null){
            throw new NullPointerException();
        }
        return result;
    }

}