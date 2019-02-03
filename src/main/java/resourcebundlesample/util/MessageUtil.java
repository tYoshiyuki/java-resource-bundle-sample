package resourcebundlesample.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * メッセージのユーティリティクラスです
 */
public class MessageUtil {
    // プロパティファイルのパス
    private static final String PROPERTY_FILE_PATH = "lang\\message";

    // リソースバンドル、既定でデフォルトのロケールを読み込む
    private static ResourceBundle bundle = ResourceBundle.getBundle(MessageUtil.PROPERTY_FILE_PATH);

    /**
     * メッセージのLocaleを変更します
     * @param locale ロケール情報
     */
    public static void setLocale(Locale locale) {
        MessageUtil.bundle = ResourceBundle.getBundle(MessageUtil.PROPERTY_FILE_PATH, locale);
    }

    /**
     * メッセージを取得します
     * @param key プロパティファイルのキー名
     * @return メッセージ文字列
     */
    public static String getMessage(String key) {
        return bundle.getString(key);
    }
}