package resourcebundlesample.util;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 * メッセージのユーティリティのテストクラスです
 */
public class MessageUtilTest {
    @Test
    public void setLocale() {
        // Arrange・Act
        MessageUtil.setLocale(Locale.ENGLISH);
        
        // Assert
        assertEquals("enのプロパティが適用されてない", "HELLO!!", MessageUtil.getMessage("hello"));
    }
}
