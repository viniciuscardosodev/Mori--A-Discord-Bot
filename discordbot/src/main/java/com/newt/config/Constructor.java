package com.newt.config;

import java.util.Arrays;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class Constructor {

    public static JDA jda;

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
        JDABuilder builder = JDABuilder.create("MTEwNjI0ODgxODc5MTU1NTIwMw.GUJZoG.25uMr0w2UJYQL2BbzVopUPwNSD88HRvPHjz9vw", Arrays.asList(gatewayIntents));
        try {
            jda = builder.build().awaitReady();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
