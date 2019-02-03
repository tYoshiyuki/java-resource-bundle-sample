package resourcebundlesample;

import java.util.Locale;

import resourcebundlesample.util.MessageUtil;

public class App {

    public String getGreeting() {
        return MessageUtil.getMessage("hello") + " world.";
    }

    public String getGreetingEn() {
        // ロケールの変更
        MessageUtil.setLocale(Locale.ENGLISH);        
        return MessageUtil.getMessage("hello") + " world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        System.out.println(new App().getGreetingEn());
    }
}
