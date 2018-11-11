import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.w3c.dom.events.EventListener;

import java.util.ArrayList;
import java.util.List;


public class Main extends ListenerAdapter {

    public static Bot BOT;
    public static String GUILD_ID = "489376202050633740";

    public static void main(String[] arguments) throws Exception {
        JDA api = new JDABuilder("NTA2ODk2MDMyMDUxODg4MTQ4.DrozjQ.T5yNKviMgwnhiqrov9fh0easkIk").build();
        api.addEventListener(new Listener.PrivateMessageListener());
        api.awaitReady();

        BOT = new Bot(api.getGuildById(GUILD_ID));
    }

}
