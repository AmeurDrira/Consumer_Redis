package tn.iit.lora;

public class ClientRedis extends DefaultRedis {

	public ClientRedis(String channelDownlink, String redisServer) {
		super(channelDownlink, redisServer);

	}

	@Override
	public void handle(String channel, String message) {
		super.handle(channel, message);

	}

	public static void main(String[] args) {
		ClientRedis receiveRedisFrame = new ClientRedis("Downlink", "soitech.cloudapp.net");
		receiveRedisFrame.start();

	}

}
