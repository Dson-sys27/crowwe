package dson.crowee.sources.sourceTools;

import dson.crowee.globals.LogViews;

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
            LogViews.dropMapRendererError(filePath);
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

        return matrizMapa;
    }
}
