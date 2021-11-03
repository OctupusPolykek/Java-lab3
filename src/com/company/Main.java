package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static final String BACKUP_PATH = "C:\\Users\\rasia\\IdeaProjects\\lab3\\src\\";

    public static boolean createBackUp(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "_copy.txt"));
        if (!Files.exists(path)) return false;
        Files.copy(file.toPath(), path, REPLACE_EXISTING);
        return true;
    }

    public static void restoreBackUp(File file) throws Exception {
        Path path = Paths.get(BACKUP_PATH + file.getName().replace(".txt", "_copy.txt"));
        if (!Files.exists(path)) return;

        Files.copy(path, file.toPath(), REPLACE_EXISTING);
    }

    public static void main(String[] args) throws Exception {
        Product product = new Product(20, 20, 2020, "Ukraine");
        boolean isBackUp = false;

        File file = new File(BACKUP_PATH + "text.txt");
        file.createNewFile();

        try (ObjectSerializer objectSerializer = new ObjectSerializer(file)) {
            objectSerializer.save(product);
            isBackUp = createBackUp(file);

            Product productBefore = (Product) objectSerializer.load();

            System.out.println("До бекапа: ");
            System.out.println(productBefore);
        }
        try (ObjectSerializer restoreObjectSerializer = new ObjectSerializer(file)) {
            if (isBackUp) {
                restoreBackUp(file);
            }
            Product productAfter = (Product) restoreObjectSerializer.load();
            System.out.println("После бекапа: ");
            System.out.println(productAfter);
        }

    }
}
