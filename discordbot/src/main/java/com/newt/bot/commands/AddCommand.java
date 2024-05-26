package com.newt.bot.commands;

import java.util.List;

import ca.tristan.easycommands.commands.slash.SlashExecutor;
import ca.tristan.easycommands.commands.EventData;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

public class AddCommand extends SlashExecutor{

    public AddCommand(){
        
    }

    @Override
    public void execute(EventData data) {
        String participante = data.getCommand().getOptions().get(0).getAsString();
        SortCommand.addIfNotIn(participante);
        data.deferReply();
        data.getHook().sendMessage("Participante **" + participante + "** adicionado!").queue();
    }

    @Override
    public String getDescription() {
        return "Adicione um participante ausente!";
    }

    @Override
    public String getName() {
        return "adicionar";
    }

    @Override
    public List<OptionData> getOptions() {
        options.add(new OptionData(OptionType.STRING, "participante", "digite o nome do participante ausente para adiconar à lista.", true));
        return options;
    }

    @Override
    public boolean isOwnerOnly() {
        return false;
    }

    
}
