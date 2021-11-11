package me.pan1st.easyemojis.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.md_5.bungee.api.ChatColor.COLOR_CHAR;

public class SexyColor {

    public static String serialize(Component comp){
        return LegacyComponentSerializer.legacyAmpersand().serialize(comp);
    }

    public static Component deserialize(String str){
        return LegacyComponentSerializer.legacyAmpersand().deserialize(str);
    }

    public static Component translate(Component comp){
        return deserialize(serialize(comp));
    }

    public static String translate(String str){
        return translateHex(ChatColor.translateAlternateColorCodes('&', str));
    }

    public static String translateHex(String str)
    {
        final Pattern hexPattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = hexPattern.matcher(str);
        StringBuilder buffer = new StringBuilder(str.length() + 4 * 8);
        while (matcher.find())
        {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return matcher.appendTail(buffer).toString();
    }

}
