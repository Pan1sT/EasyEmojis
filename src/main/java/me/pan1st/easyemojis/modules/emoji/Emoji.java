package me.pan1st.easyemojis.modules.emoji;

public record Emoji(String name, String emoticon, String emoji, String perm) {

    public Emoji{
        if (name == null || emoticon == null || emoji == null || perm == null){
            throw new IllegalArgumentException( "Arguments cannot be null !");
        }
    }

}
