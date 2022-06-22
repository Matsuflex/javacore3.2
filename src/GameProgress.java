import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String path, GameProgress gamer) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(gamer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void zipFiles(String path, List<String> savings) {
        try {
            ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(path));
            for (int i = 0; i < savings.size(); i++) {
                try {
                    FileInputStream fis = new FileInputStream(savings.get(i));
                    ZipEntry ze = new ZipEntry("mysavings" + i);
                    zos.putNextEntry(ze);
                    byte[] bytes = new byte[(fis.available())];
                    fis.read(bytes);
                    zos.write(bytes);
                    zos.closeEntry();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            zos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFiles(String fileName) {
        File file = new File(fileName);
        if (!fileName.endsWith(".zip")) {
            file.delete();
        }
    }
}