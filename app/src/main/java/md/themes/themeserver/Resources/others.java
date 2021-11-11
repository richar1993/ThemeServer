package md.themes.themeserver.Resources;


import java.io.File;

/**
 * Created by Yousef Al Basha on 20/12/14.
 */
public class others {
    public static String homeBK_path;


    public static void init() {
        yo.datafolder = (yo.getCtx().getFilesDir().getAbsolutePath() + File.separator).replace("files/", "");
        homeBK_path = yo.datafolder + "files/homeBK.jpg";
    }

}
