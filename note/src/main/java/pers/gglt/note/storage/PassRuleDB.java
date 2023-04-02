package pers.gglt.note.storage;//package pers.gglt.note.storage;
//
//import android.os.Environment;
//
//import org.xutils.DbManager;
//import org.xutils.x;
//
//import java.io.File;
//import java.util.List;
//
//import passrule.entity.PassRule;
//
//public class PassRuleDB {
//    public static final String DB_NAME = "pass_rule";
//    private static final String TAG = "PassRuleDB";
//    public static DbManager dbManager;
//    private static final String dbDir;
//    private static PassRuleDB instance;
//    private List<PassRule> allPassRules;
//    private boolean isFlush;
//
//    static {
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//        dbDir = path + File.separator + "mipsClientDB";
//    }
//
//    public static PassRuleDB getInstance() {
//        if (instance == null) {
//            synchronized (PassRuleDB.class) {
//                if (instance == null) {
//                    instance = new PassRuleDB();
//                }
//            }
//        }
//        return instance;
//    }
//
//    private PassRuleDB() {
//        try {
//            dbManager = x.getDb(new DbManager.DaoConfig().
//                    setDbName(DB_NAME).
//                    setDbDir(getDbDir()).
//                    setDbVersion(1).
//                    setAllowTransaction(true).
//                    setDbUpgradeListener(this::upgradeToVersion));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static DbManager getDBManager() {
//        return dbManager;
//    }
//
//    private File getDbDir() {
//        final File file = new File(dbDir);
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        return file;
//    }
//
//    private void upgradeToVersion(DbManager db, int olderVersion, int newVersion) {
//    }
//}
