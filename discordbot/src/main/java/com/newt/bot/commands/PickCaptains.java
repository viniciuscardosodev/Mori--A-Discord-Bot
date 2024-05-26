package com.newt.bot.commands;

import java.util.List;
import java.util.Random;

import ca.tristan.easycommands.commands.EventData;
import ca.tristan.easycommands.commands.slash.SlashExecutor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import com.newt.bot.resources.*;

import java.awt.Color;


public class PickCaptains extends SlashExecutor{
    

    @Override
    public void execute(EventData data) {

        if (!data.getMemberVoiceState().inAudioChannel()){
            data.deferReply();
            data.getHook().sendMessage("Hey, você não está em nenhum voice chat! Entre em um voice chat para usar esse comando.").queue();
            data.deferReply();
            return;
        }

        Players.build(data);
        if (Players.playerQuantity() < 2) {
            data.getHook().sendMessage("Hey, aí tem menos de 3 pessoas, quer sortear o quê?????").queue();
            data.deferReply();
            return;
        }


        EmbedBuilder cap1 = new EmbedBuilder();
        EmbedBuilder cap2 = new EmbedBuilder();
        Random r = new Random();
        int random;
        System.out.println(Players.getPlayers().size());
        random = r.nextInt(Players.getPlayers().size());
        System.out.println("INDICE DA LISTA SORTEADO : " + random);
        String sorteado = Players.getPlayer(r.nextInt(Players.getPlayers().size()));
        cap1.setTitle("Capitão do Time Atancantes: ");
        cap1.setDescription("# " + sorteado);
        cap1.setImage(Players.getUserIconURL(sorteado));
        cap1.setColor(Color.RED);
        Players.removePlayer(sorteado);

        random = r.nextInt(Players.getPlayers().size());
        sorteado = Players.getPlayer(random);
        cap2.setTitle("Capitão do Time Defensores: ");
        cap2.setDescription("# " + sorteado);
        cap2.setImage(Players.getUserIconURL(sorteado));
        cap2.setColor(Color.CYAN);
        Players.removePlayer(sorteado);
        
        data.getHook().sendMessageEmbeds(cap1.build(), cap2.build()).queue();
        data.deferReply();
    }

    @Override
    public String getDescription() {
        return "Sorteia dois capitões da call!";
    }

    @Override
    public String getName() {
        return "pickcap";
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
