package com.company;

import java.io.*;

public class ObjectSerializer implements AutoCloseable {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    File file;

    ObjectSerializer(File file) throws Exception {
        if (!file.isFile()) {
            throw new Exception("Current file must be a file.");
        }
        this.file = file;
    }

    public void save (Object object) throws Exception {
        if (this.outputStream == null) {
            this.outputStream = new ObjectOutputStream(new FileOutputStream(this.file));
        }

        this.outputStream.writeObject(object);
    }

    public Object load () throws Exception {
        if (this.inputStream == null) {
            this.inputStream = new ObjectInputStream(new FileInputStream(this.file));
        }

        return inputStream.readObject();
    }

    @Override
    public void close() throws Exception {
        if (inputStream != null) {
            inputStream.close();
            inputStream = null;
        }
        if (outputStream != null) {
            outputStream.close();
            outputStream = null;
        }
    }
}
