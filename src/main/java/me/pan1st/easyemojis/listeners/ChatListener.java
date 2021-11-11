package me.pan1st.easyemojis.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import me.pan1st.easyemojis.modules.emoji.EmojiHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void handle(AsyncChatEvent e) {
        e.message(EmojiHandler.parse(e.getPlayer(), e.message()));
    }

}
