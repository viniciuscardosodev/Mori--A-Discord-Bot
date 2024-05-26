package com.newt.bot.commands;

import java.util.List;
import java.util.Random;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import com.newt.bot.config.*;
import java.awt.Color;

public class MapPick extends SlashExecutor{

    @Override
    public void execute(EventData data) {
        Random r = new Random();
        EmbedBuilder mapa = new EmbedBuilder();
        int mapIndex = r.nextInt(Maps.values().length);
        mapa.setTitle("Mapa: " + Maps.getByIndex(mapIndex).getString1());
        mapa.setImage(Maps.getByIndex(mapIndex).getString2());
        mapa.setColor(Color.CYAN);
        data.getHook().sendMessageEmbeds(mapa.build()).queue();
        data.deferReply();
    }

    @Override
    public String getDescription() {
        return "Sorteia um mapa!";
    }

    @Override
    public String getName() {
        return "pickmap";
    }

    @Override
    public List<OptionData> getOptions() {
        return super.getOptions();
    }

    @Override
    public boolean isOwnerOnly() {
        return false;
    }
}
