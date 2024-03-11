package com.newt.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.newt.config.Maps;

import ca.tristan.easycommands.commands.CommandExecutor;
import ca.tristan.easycommands.commands.EasyCommands;
import ca.tristan.easycommands.commands.EventData;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import java.awt.Color;



public class SortCommand extends CommandExecutor{

    public static ArrayList<String> listaMembros = new ArrayList<String>();

    @Override
    public void execute(EventData data) {

        // vars
        EmbedBuilder mapa = new EmbedBuilder();
        EmbedBuilder atacantes = new EmbedBuilder();
        EmbedBuilder defensores = new EmbedBuilder();
        EmbedBuilder reservas = new EmbedBuilder();
        Random r = new Random();
        String attackersDesc = "Esse será o time que começará atacando. \n";
        String defendersDesc = "Esse será o time que começará defendendo. \n";

        if (!data.getMemberVoiceState().inAudioChannel()){
            data.deferReply().queue();
            data.getHook().sendMessage("Hey, você não está em nenhum voice chat! Entre em um voice chat para usar esse comando.").queue();
            return;
        }
        data.deferReply().queue();
        List<Member> l = data.getMemberVoiceState().getChannel().getMembers();
        System.out.println("Tamanho da lista" + l.size());
        for (Member m : l) 
            addIfNotIn(m.getUser().getName());;

        if (listaMembros.size() < 10) {   
                data.getHook().sendMessage("Aí tem menos de 10 jogadores, digite /adicionar para cada membro pendente!").queue();
                return;
        }
        
        
        int mapIndex = r.nextInt(Maps.values().length);
        mapa.setTitle("Mapa: " + Maps.getByIndex(mapIndex).getString1());
        mapa.setImage(Maps.getByIndex(mapIndex).getString2());
        atacantes.setTitle("Atacantes:");
        reservas.setTitle("Reservas:");
        reservas.setColor(Color.MAGENTA);
        reservas.setDescription("Não fique triste, você pode jogar como coach ou assistir a partida!");
        defensores.setTitle("Defensores:");
        mapa.setColor(Color.CYAN);
        atacantes.setColor(Color.RED);
        defensores.setColor(Color.BLUE);
        ArrayList<String> atacantesList = new ArrayList<String>();
        ArrayList<String> defensoresList = new ArrayList<String>();

        for (int n = 0; n < 5; n++) {
            int index = r.nextInt(listaMembros.size());
            atacantesList.add(listaMembros.get(index));
            listaMembros.remove(index);
            index = r.nextInt(listaMembros.size());
            defensoresList.add(listaMembros.get(index));
            listaMembros.remove(index);
        }
        if (listaMembros.size() != 0)
            for (String string : listaMembros) 
                reservas.addField("**" + string + "**", " \n", false);
        else 
            reservas.addField("** Ninguém ficou de fora **", " \n", false);

        listaMembros.clear();
        for (String string : defensoresList) {
            // defensores.addField("**" + string + "**", " \n", false);
            defendersDesc += "**" + string + "**" + " \n";
        }
        for (String string : atacantesList) {
            // atacantes.addField("**" + string + "**", " \n", false);
            attackersDesc += "**" + string + "**" + " \n";
        }
        atacantes.setDescription(attackersDesc);
        defensores.setDescription(defendersDesc);

        data.getHook().sendMessageEmbeds(mapa.build(), atacantes.build(), defensores.build(), reservas.build()).queue();
   }

    @Override
    public String getDescription() {
        return "Separa todos os usuários do chat de voz em dois times.";
    }

    @Override
    public String getName() {
        return "sortear";
    }

    @Override
    public List<OptionData> getOptions() {
        return super.getOptions();
    }

    @Override
    public boolean isOwnerOnly() {
        return false;
    }

    public static void addIfNotIn(String newParticipant){
        boolean add = true;
        for (String s : listaMembros){
            if (newParticipant.equalsIgnoreCase(s))
                add = false;
        }
        if (add) {
            listaMembros.add(newParticipant);
        }
    }

    
}
