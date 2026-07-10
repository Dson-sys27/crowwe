package dson.crowee.sources.sourceTools;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MapRenderer {

    public static int[][] renderMap(String filePath){
        List<String> lineas = null;
        try{
            lineas = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {

        }

        int filas = lineas.size();
        int columnas = lineas.get(0).trim().split("\\s+").length;

        int[][] matrizMapa = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            String[] numerosDeLaLinea = lineas.get(i).trim().split("\\s+");

            for (int j = 0; j < columnas; j++) {
                matrizMapa[i][j] = Integer.parseInt(numerosDeLaLinea[j]);
            }
        }

        for(int i = 20; i < 60; i++)
            for(int j = 20; j < 70; j++)
                matrizMapa[i][j] = 1;

        return matrizMapa;
    }
}
