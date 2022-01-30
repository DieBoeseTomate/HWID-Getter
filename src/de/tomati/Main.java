package de.tomati;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String os = System.getProperty("os.name").toUpperCase();
        if (os.startsWith("WIN")) {
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("wmic csproduct get UUID").getInputStream()));
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                stringBuilder.append(content).append("\n");
            }
            String id = stringBuilder.toString().replace(" ", "").split("\n")[2];
            System.out.println(id);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(new StringSelection(id), null);
        }
    }
}
