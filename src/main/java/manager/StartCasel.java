package manager;

import com.github.m5rian.jdaCommandHandler.CommandListener;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandService;
import com.github.m5rian.jdaCommandHandler.commandServices.DefaultCommandServiceBuilder;
import commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

/**
 * Project: Casel
 * Date: 06/02/2021 @ 21:59
 * Class: manager.Main
 */
public enum StartCasel {
    INTANCE;
    private JDA jda;
    public void startBot() throws LoginException {
        DefaultCommandService commandService = new DefaultCommandServiceBuilder()
                .setDefaultPrefix("/")
                .build();

        JDA jda = JDABuilder.createDefault("yourbottokens")
                .setActivity(Activity.watching("In 2 Server" + " | /help"))
                .addEventListeners(new CommandListener(commandService))
                .build();
        commandService.registerCommand(new PingCommand());
    }
}
