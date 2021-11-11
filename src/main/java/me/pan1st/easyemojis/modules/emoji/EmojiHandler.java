package me.pan1st.easyemojis.modules.emoji;

import lombok.Getter;
import me.pan1st.easyemojis.utils.SexyColor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextReplacementConfig;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class EmojiHandler {

    @Getter public static ArrayList<Emoji> emojiList = new ArrayList<>();

    public EmojiHandler(){
        load();
    }

    private void load(){

    }

    public static Component parse(Player player, Component message){
        for (Emoji emoji : getEmojiList()) {
            if (!player.hasPermission("easyemojis.useall") && !player.hasPermission(emoji.perm())) continue;
            message = message.replaceText(TextReplacementConfig.builder().matchLiteral(emoji.name()).replacement(emoji.emoji()).build());
        }
        return SexyColor.translate(message);
    }

}
