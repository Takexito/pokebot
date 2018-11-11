import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.requests.restaction.MessageAction;

public class Bot {
    private Guild guild;
    private TextChannel channel;

    public Bot(Guild guild){
        this.guild = guild;
        channel = guild.getTextChannelById("507269681439309834");
    }

    public void sendMessageToGuild(Message message){

        MessageAction m = channel.sendMessage(message);
        Message mes = m.complete();
        //System.out.println(.get(0).getName());
        mes.addReaction(guild.getJDA().getEmotesByName("CharmanderHi", true).get(0)).queue();
        mes.addReaction(guild.getJDA().getEmotesByName("SquirtleSquadCool", true).get(0)).queue();
        mes.addReaction(guild.getJDA().getEmotesByName("PikaLolipop", true).get(0)).queue();

    }


    public void sendMessage(MessageChannel channel, String message){
        channel.sendMessage(message).queue();
    }
}
