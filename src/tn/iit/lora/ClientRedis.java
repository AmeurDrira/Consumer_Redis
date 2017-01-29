package tn.iit.lora;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClientRedis extends DefaultRedis {

	public ClientRedis(String channelDownlink, String redisServer) {
		super(channelDownlink, redisServer);

	}

	@Override
	public void handle(String channel, String message) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

		System.out.println(timeStamp + "  DownLink  " + channel + " Message  : " + message);

	}

	public static void main(String[] args) {
		ClientRedis receiveRedisFrame = new ClientRedis("Downlink", "52.183.78.136");
		receiveRedisFrame.start();
		
		

	}

}
