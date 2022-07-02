package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;
import java.util.List;

public class Embed implements ICommand {
    @Override
    public String getName() {
        return "embed";
    }

    @Override
    public String getDescription() {
        return "Will send an embed";
    }

    @Override
    public List<OptionData> getOptions() {
        return null;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Example Embed");
        builder.setDescription("An example embed");
        builder.addField("Field 1", "Value", false);
        builder.addField("Field 2", "Value", false);
        builder.addField("Field 3", "Value", false);
        builder.setFooter("Example Footer");
        builder.setColor(Color.BLUE);
        builder.appendDescription(" This has been added");
        builder.setAuthor("Relaxing Leg");
        event.replyEmbeds(builder.build()).queue();
    }
}
