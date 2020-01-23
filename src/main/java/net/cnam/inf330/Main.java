package net.cnam.inf330;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Main class for running the Rover Mission Command Center application.
 */
public class Main {

    /**
     * Main method for running the Rover Mission Command Center application.
     *
     * @param args --
     * @throws IOException
     * @throws URISyntaxException
     */
    public static void main(String[] args) throws IOException, URISyntaxException, InvalidRoverPositionException {
        List<String> lines = Main.readResourceFile("rover_data.txt");
        MissionCommandCenter mcc = new MissionCommandCenter();
        List<String> outputLines = mcc.processRoverData(lines);

        System.out.println("\n===========");
        StringBuilder fichierSortie = new StringBuilder();
        for (String line : outputLines) {
            System.out.println(line);
            fichierSortie.append(line);
        }
        System.out.println("===========");

        // TODO 8) Write output lines to file
        File file = createFile("C:\\Users\\ELE5bc943f9005a3\\Desktop\\rover_test_outuput.txt");
        writeFile(file,fichierSortie);
    }

    private static File createFile(String nomFichier) throws IOException {
        File fichier = new File(nomFichier);
        fichier.createNewFile();
        return fichier;

    }
    private static FileWriter writeFile(File f, StringBuilder texte) throws IOException {
        FileWriter fichier = new FileWriter(f);
        fichier.write(String.valueOf(texte));
        fichier.close();
        return fichier;

    }

    /**
     * Read a file from the application's resource bundle.
     *
     * @param resourceFileName The name of the file to read
     * @return The list of lines read from the file, without the empty lines
     * @throws IOException
     * @throws URISyntaxException
     */
    public static List<String> readResourceFile(String resourceFileName) throws IOException, URISyntaxException {
        List<String> lines = Files.readAllLines(Paths.get(Main.class.getClassLoader()
                .getResource(resourceFileName).toURI()));

        return lines.stream().filter(line -> !line.isEmpty()).collect(Collectors.toList());
    }
}
