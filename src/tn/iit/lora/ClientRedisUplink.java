package tn.iit.lora;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClientRedisUplink extends DefaultRedis {

	public ClientRedisUplink(String channelDownlink, String redisServer) {
		super(channelDownlink, redisServer);

	}

	@Override
	public void handle(String channel, String message) {
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

		System.out.println(timeStamp + "  " + channel + " Message  : " + message);

	}

	public static void main(String[] args) {
		ClientRedisUplink receiveRedisFrame = new ClientRedisUplink("Uplink", "52.183.78.136");
		receiveRedisFrame.start();
		
	}

}
