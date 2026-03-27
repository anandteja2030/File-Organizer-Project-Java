public class Main {

    public static void main(String[] args) {

        System.out.println("===== FILE ORGANIZER TOOL =====");

        String folderPath = "testfiles";

        FileOrganizer organizer = new FileOrganizer();
        organizer.organize(folderPath);
    }
}