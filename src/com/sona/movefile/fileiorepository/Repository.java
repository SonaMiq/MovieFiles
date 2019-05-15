package com.sona.movefile.fileiorepository;

import java.io.*;

public class Repository<K, V extends Serializable> {

    private File file;

    public Repository(String filePath) {
        try {
            file = new File(filePath);
            file.createNewFile();
        } catch (IOException ex) {
            throw new RuntimeException("Something went wrong with file.");
        }
    }

    public void writeInFile(K key, V object) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(key.toString() + "/105/" + Serializer.serialize(object));
            writer.newLine();
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            throw new RuntimeException();
        }
    }

    public V readFromFile(K id) {

        String line = "";
        V object = null;
        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));
            do {
                line = reader.readLine();
                if (line == null)
                    break;

            }
            while (!line.split("/105/")[0].equals(id.toString()));
            reader.close();
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        try {
            if (line != null) {
                String obj = line.split("/105/")[1];
                object = (V) Serializer.deserialize(obj);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return object;
    }

    public long getObjectCounts() {
        long size = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            size = reader.lines().count();
        } catch (IOException ex) {
            throw new RuntimeException();
        }
        return size;
    }


}
