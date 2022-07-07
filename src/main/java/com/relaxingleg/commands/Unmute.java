package com.relaxingleg.commands;

import com.relaxingleg.ICommand;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class Unmute implements ICommand {
    @Override
    public String getName() {
        return "unmute";
    }

    @Override
    public String getDescription() {
        return "Will unmute a user";
    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> options = new ArrayList<>();
        options.add(new OptionData(OptionType.USER, "muted", "The user to unmute", true));
        return options;
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        Member member = event.getMember();
        Guild guild = event.getGuild();
        Role role = guild.getRoleById(992827277706526771L);
        if(member.getRoles().contains(role)) {
            Member mutedMember = event.getOption("muted").getAsMember();
            Role muteRole = guild.getRoleById(993897538262401066L);
            Role defaultRole = guild.getRoleById(992826406604111962L);
            guild.removeRoleFromMember(mutedMember, muteRole).queue();
            guild.addRoleToMember(mutedMember, defaultRole).queue();
            event.reply("Unmuted member").queue();
        } else {
            event.reply("You do not have permission to execute this command").queue();
        }
    }
}
