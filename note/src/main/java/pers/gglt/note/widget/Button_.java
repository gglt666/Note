package pers.gglt.note.widget;

public class Button_ {
    // 防止快速点击
    private static long interval = 2000;
    private static long lastClickTime;
    private static int lastButtonId;
    public static boolean isFastClick() {
        if (System.currentTimeMillis() - lastClickTime < interval) {
            return true;
        }
        lastClickTime = System.currentTimeMillis();
        return false;
    }
    public static boolean isFastClick(int buttonId) {
        if (lastButtonId == buttonId && System.currentTimeMillis() - lastClickTime < interval) {
            return true;
        }
        lastClickTime = System.currentTimeMillis();
        lastButtonId = buttonId;
        return false;
    }
    public static void setInterval(long interval) {
        Button_.interval = interval;
    }



}
