import R.Commands;
import R.Strings;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;

import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;

import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Listener {

    public static class PrivateMessageListener  extends ListenerAdapter{

        public void onPrivateMessageReceived(PrivateMessageReceivedEvent event)
        {
            if (event.getAuthor().isBot()) return;

            Message message = event.getMessage();
            String content = message.getContentRaw().toLowerCase();
            MessageChannel channel = event.getChannel();

            System.out.println("Message recived: "+ message.getContentDisplay());

            if (content.startsWith(Commands.RAID))
            {
                Raid raid = new Raid(message.getContentDisplay());
                if (!isMapLink(content)) Main.BOT.sendMessage(channel, Strings.BAD_LINK);

                Main.BOT.sendMessageToGuild(raid.getRaidInfo());
            }
            else if (content.contains(Commands.HELP)){
                Main.BOT.sendMessage(channel, Strings.HELP_MESSAGE);
            }
        }

        private boolean isMapLink(String str){
            return str.contains("goo.gl/maps/");
        }

        private String getWithoutPerfix(String string){
            return string.substring(5);
        }

    }
}
