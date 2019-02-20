package resourcebundlesample.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * メッセージのユーティリティクラスです
 */
public class MessageUtil {
    // プロパティファイルのFQDN
    private static final String PROPERTY_FILE_NAME = "lang.message";

    private static ResourceBundle.Control UTF8_ENCODING_CONTROL = new ResourceBundle.Control() {
        /**
         * UTF-8 エンコーディングのプロパティファイルから ResourceBundle オブジェクトを生成する
         *
         * @throws IllegalAccessException
         * @throws InstantiationException
         * @throws IOException
         */
        @Override
        public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, "properties");

            try (InputStream is = loader.getResourceAsStream(resourceName);
                 InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                 BufferedReader reader = new BufferedReader(isr)) {
                return new PropertyResourceBundle(reader);
            }
        }
    };

    // リソースバンドル、既定でデフォルトのロケールを読み込む
    private static ResourceBundle bundle = ResourceBundle.getBundle(MessageUtil.PROPERTY_FILE_NAME, UTF8_ENCODING_CONTROL);

    /**
     * メッセージのLocaleを変更します
     * @param locale ロケール情報
     */
    public static void setLocale(Locale locale) {
        MessageUtil.bundle = ResourceBundle.getBundle(MessageUtil.PROPERTY_FILE_NAME, locale, UTF8_ENCODING_CONTROL);
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