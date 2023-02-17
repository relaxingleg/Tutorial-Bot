package com.relaxingleg;

import com.relaxingleg.commands.Ban;
import com.relaxingleg.commands.Buttons;
import com.relaxingleg.commands.Embed;
import com.relaxingleg.commands.Modals;
import com.relaxingleg.commands.Mute;
import com.relaxingleg.commands.music.NowPlaying;
import com.relaxingleg.commands.music.Play;
import com.relaxingleg.commands.Staff;
import com.relaxingleg.commands.Sum;
import com.relaxingleg.commands.UnStaff;
import com.relaxingleg.commands.Unmute;
import com.relaxingleg.commands.music.Queue;
import com.relaxingleg.commands.music.Repeat;
import com.relaxingleg.commands.music.Skip;
import com.relaxingleg.commands.music.Stop;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(Token.TOKEN).build();
        jda.addEventListener(new Listeners());
        CommandManager manager = new CommandManager();
        manager.add(new Sum());
        manager.add(new Embed());
        manager.add(new Buttons());
        manager.add(new Modals());
        manager.add(new Ban());
        manager.add(new Mute());
        manager.add(new Staff());
        manager.add(new UnStaff());
        manager.add(new Unmute());
        manager.add(new Play());
        manager.add(new Skip());
        manager.add(new Stop());
        manager.add(new NowPlaying());
        manager.add(new Queue());
        manager.add(new Repeat());
        jda.addEventListener(manager);
    }
}
