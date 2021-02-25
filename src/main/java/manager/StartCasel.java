package manager;

import com.github.m5rian.jdaCommandHandler.CommandListener;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandService;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandServiceBuilder;
import commands.AvCommand;
import commands.HelpCommand;
import commands.PingCommand;
import commands.ServerCommand;
import commands.moderation.*;
import listener.FilterListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * Project: Casel
 * Date: 06/02/2021 @ 21:59
 * Class: manager.Main
 */
public enum StartCasel {
    INTANCE;
    public void startBot() throws LoginException {
        //Variables
        //Set Prefix A CommandAPI Value
        DefaultCommandService commandService = new DefaultCommandServiceBuilder()
                .setDefaultPrefix("/")
                .build();

        //Set Tokens And Register Listener
        JDA jdabuilder = JDABuilder.createDefault("yourtokensbots")
                .addEventListeners(new CommandListener(commandService))
                .addEventListeners(new FilterListener())
                .build();
        //Register All Commands
        commandService.registerCommand(new PingCommand());
        commandService.registerCommand(new AvCommand());
        commandService.registerCommand(new BanCommand());
        commandService.registerCommand(new KickCommand());
        commandService.registerCommand(new MuteCommand());
        commandService.registerCommand(new ClearCommand());
        commandService.registerCommand(new HelpCommand());
        commandService.registerCommand(new ServerCommand());
        commandService.registerCommand(new FortuneBallCommand());
    }
}
