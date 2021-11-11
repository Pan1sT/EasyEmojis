package me.pan1st.easyemojis.listeners;

import me.pan1st.easyemojis.modules.emoji.EmojiHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SignListener implements Listener {

    @EventHandler
    public void handle(SignChangeEvent e){
        e.lines().forEach(line -> e.line(e.lines().indexOf(line), EmojiHandler.parse(e.getPlayer(), line)));
    }
}
