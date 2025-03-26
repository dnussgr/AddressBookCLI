package Utils;


public class ListToTable {

    public static void printTable(String[][] data) {
        if (data == null || data.length == 0) return;

        // Berechnet die Breite der Spalten anhand der max. Länge der Strings
        int[] columnWidths = new int[data[0].length];
        for (String[] row : data) {
            for (int i = 0; i < row.length; i++) {
                columnWidths[i] = Math.max(columnWidths[i], row[i].length());
            }
        }

        // Zählt die Anzahl der benötigten horizontalen Trennlinien (+) anhand Spaltenbreite
        String horizontalLine = "+";
        for (int width : columnWidths) {
            horizontalLine += "-".repeat(width + 2) + "+";
        }
        System.out.println(horizontalLine);


        // Erstellt eine Trennlinie zwischen den Feldern
        for (String[] row : data) {
            System.out.print("|");
            for (int i = 0; i < row.length; i++) {
                System.out.printf(" %-" + columnWidths[i] + "s |", row[i]);
            }
            System.out.println();
            System.out.println(horizontalLine);
        }
    }
}
