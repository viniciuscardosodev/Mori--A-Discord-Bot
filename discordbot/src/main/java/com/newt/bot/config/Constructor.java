package com.newt.bot.config;

import ca.tristan.easycommands.EasyCommands;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public final class Constructor {

    private static JDA jda;

    public static final GatewayIntent[] gatewayIntents = {
        GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
        GatewayIntent.GUILD_VOICE_STATES,
        GatewayIntent.DIRECT_MESSAGES,
        GatewayIntent.GUILD_MEMBERS,
        GatewayIntent.GUILD_MESSAGES,
        GatewayIntent.GUILD_PRESENCES,
        GatewayIntent.MESSAGE_CONTENT,
        GatewayIntent.GUILD_PRESENCES
    };

    public static void main(String[] args) {
        JDABuilder builder = JDABuilder.createDefault(EasyCommands.getConfig().getToken());
        try {
            jda = builder.build().awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static JDA getJDA(){
        main(null);
        return jda;
    }

}
