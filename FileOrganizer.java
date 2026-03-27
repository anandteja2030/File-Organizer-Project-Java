import java.io.File;

public class FileOrganizer {

    int movedFiles = 0;

    public void organize(String folderPath) {

        File folder = new File(folderPath);

        System.out.println("Organizing folder: " + folder.getAbsolutePath());

        if (!folder.exists()) {
            System.out.println("Folder does not exist");
            return;
        }

        File[] files = folder.listFiles();

        if (files == null) {
            System.out.println("No files found");
            return;
        }

        for (File file : files) {

            // Skip folders (Images, Videos etc.)
            if (file.isDirectory()) {
                continue;
            }

            String name = file.getName().toLowerCase();

            if (name.endsWith(".jpg") || name.endsWith(".png")) {
                moveFile(file, folderPath + "/Images");
            }

            else if (name.endsWith(".mp4")) {
                moveFile(file, folderPath + "/Videos");
            }

            else if (name.endsWith(".mp3")) {
                moveFile(file, folderPath + "/Audio");
            }

            else if (name.endsWith(".pdf") || name.endsWith(".txt")) {
                moveFile(file, folderPath + "/Documents");
            }

            else {
                moveFile(file, folderPath + "/Others");
            }
        }

        System.out.println("Total files moved: " + movedFiles);
        System.out.println("Organization completed.");
    }

    private void moveFile(File file, String newFolderPath) {

        File newFolder = new File(newFolderPath);

        if (!newFolder.exists()) {
            newFolder.mkdirs();
        }

        File newFile = new File(newFolder, file.getName());

        boolean moved = file.renameTo(newFile);

        if (moved) {
            movedFiles++;
        }
    }
}