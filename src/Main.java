import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        GameProgress firstGamer = new GameProgress(100, 4, 38, 12);
        GameProgress secondGamer = new GameProgress(34, 2, 15, 30);
        GameProgress thirdGamer = new GameProgress(68, 5, 20, 19);

        firstGamer.saveGame("D://Games/savegames/save1.dat", firstGamer);
        secondGamer.saveGame("D://Games/savegames/save2.dat", secondGamer);
        thirdGamer.saveGame("D://Games/savegames/save3.dat", thirdGamer);

        ArrayList<String> files = new ArrayList<>();
        files.add("D://Games/savegames/save1.dat");
        files.add("D://Games/savegames/save2.dat");
        files.add("D://Games/savegames/save3.dat");

        GameProgress.zipFiles("D://Games/savegames/zip.zip", files);

        GameProgress.deleteFiles("save1.dat");
        GameProgress.deleteFiles("save2.dat");
        GameProgress.deleteFiles("save3.dat");
    }
}
