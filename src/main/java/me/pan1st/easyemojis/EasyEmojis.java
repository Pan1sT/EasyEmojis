package me.pan1st.easyemojis;

import lombok.Getter;
import me.pan1st.easyemojis.utils.SexyConfig;
import me.pan1st.easyemojis.listeners.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyEmojis extends JavaPlugin {

    @Getter public static SexyConfig configFile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        configFile = new SexyConfig(this, "config.yml");
        System.out.println("> > > > > > > > > > > > > > > " + getConfigFile().getStringList("emojis").size());
        //new ReplacementHandler();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
