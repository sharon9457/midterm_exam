import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q04_NotificationRouter {
public interface Channel {
String name();
boolean supports(String destination);
String send(String destination, String message);
}
public static class EmailChannel implements Channel { 
    public String name(){
        return "EMAIL";
    }
    public boolean supports(String destination){
        if(destination== null){
            return false;
        }else{
             return destination.contains("@")&&!destination.startsWith("@")&&!destination.endsWith("@");

        }}
        public String send(String destination,String message){
            return "姓名"+name()+"目的地"+destination+"訊息";
        }     

    }
    
public static class SmsChannel implements Channel { 
    public String name(){
        return "SMS";
    }
    public boolean supports(String destination){
        if(destination == null){
            return false;
        }
        String claeaned = destination.replace("-","");
        return claeaned.matches("\\d{10}");
    }
    public String send(String destination,String message){
        return "姓名:"+name()+"目的地"+destination+"訊息"+message;
    }
 }
public static List<String> route(List<Channel> channels,String destination,String message){
    if(channels == null ||destination == null ||message ==null){
        new ArrayList<>();
    }
List<String> results = new ArrayList<>();
for(Channel channel:channels){
    if(channel != null && channel.supports(destination)){
        results.add(channel.send(destination,message));
    }
}
return results;
}
public static void main(String[] args){
    var channels = List.of(
        new Q04_NotificationRouter.EmailChannel(),
        new Q04_NotificationRouter.SmsChannel()
    );
    System.out.println(Q04_NotificationRouter.route(channels,"@gmail.com","Hello"));
    System.out.println(Q04_NotificationRouter.route(channels,"412222333","word!!"));
    System.out.println(Q04_NotificationRouter.route(channels,"a@b.com","Hello"));
    System.out.println(Q04_NotificationRouter.route(channels,"412-222-333","word!!"));

}}



