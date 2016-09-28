package utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/9/26.
 * 凌瑞
 */


public class PrefsUtils {
    //定义静态变量
    private static final String FILE = "FILE";

    //获得
    public static boolean get(Context ctx, String key) {
        SharedPreferences sp = ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        boolean val = sp.getBoolean(key, true);
        return val;

    }

    //保存
    public static void save(Context ctx, String key, boolean value) {
        SharedPreferences sp = ctx.getSharedPreferences(FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();

    }

}
