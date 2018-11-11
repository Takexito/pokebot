import net.dv8tion.jda.core.MessageBuilder;
import net.dv8tion.jda.core.entities.Message;

public class Raid {
    String link;
    String team;
    boolean isEgg;
    String isEggStr;
    String time;
    String place;

    public Raid(String link, String team, boolean isEgg, String time){
        this.link = link;
        this.team = team;
        this.isEgg = isEgg;
        this.time = time;
    }
// raid link egg time team
    public Raid(String content){
        String result = content.substring(content.indexOf(" |")+2);
        link = result.substring(0, result.indexOf(" |")+1);
        result = result.substring(result.indexOf(" |")+2);
        place = result.substring(0, result.indexOf(" |")+1);
        result = result.substring(result.indexOf(" |")+2);
        team = result.substring(0, result.indexOf(" |")+1);
        result = result.substring(result.indexOf(" |")+2);
        isEggStr = result.substring(0, result.indexOf(" |")+1);
        //System.out.println(isEggStr);
        //isEgg = isEggStr.equalsIgnoreCase("да");
        result = result.substring(result.indexOf(" |")+2);
        time = result;
    }

    public Message getRaidInfo(){
        String temp;
        if (isEgg) temp = "Время до вылупления: ";
        else temp = "Время до конца: ";
        //return "Рейд!!!" + "\n" +
                //"Карта: " + link + "\n" +
                //"Название гима: " + place + "\n" +
                //"Название/Звезды покемона: "+ team + "\n" +
                //"Яйцо: "+ isEggStr + "\n" +
                //temp + time ;

        MessageBuilder messageBuilder = new MessageBuilder();
        messageBuilder.append("@everyone \n");
        messageBuilder.append("Рейд!!! ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append('\n');
        messageBuilder.append("Дата: ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append(isEggStr, MessageBuilder.Formatting.BLOCK).append("\n");
        messageBuilder.append("Время: ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append(time, MessageBuilder.Formatting.BLOCK).append("\n");
        messageBuilder.append("Название: ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append(place, MessageBuilder.Formatting.BLOCK).append("\n");
        messageBuilder.append("Покемон/Звезды : ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append(team, MessageBuilder.Formatting.BLOCK).append("\n");
        messageBuilder.append("Карта: ", MessageBuilder.Formatting.BOLD);
        messageBuilder.append(link);

        return messageBuilder.build();

    }
}
