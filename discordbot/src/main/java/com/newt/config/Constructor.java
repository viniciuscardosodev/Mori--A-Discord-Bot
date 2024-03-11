package com.newt.config;

import java.util.Arrays;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public final class Constructor {

    private static JDA jda;
    private final String token = "";

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
        JDABuilder builder = JDABuilder.create("MTEwNjI0ODgxODc5MTU1NTIwMw.GKXJ-W.2OhQsZl0QHCIS6REIvYPmWcP0Oj54sXpqB5lGE", Arrays.asList(gatewayIntents));
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
