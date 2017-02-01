package tn.iit.lora;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class DefaultRedis extends Thread {
	private String channelDownlink;

	public static Jedis jedis;

	public DefaultRedis(String channelDownlink, String redisServer) {

		this.channelDownlink = channelDownlink;
		jedis = new Jedis(redisServer, 6379, 60000);
		jedis.auth("iot2016");
		jedis.connect();

	}

	public void handle(String channel, String message) {
		System.out.println("redis.DefaultRedisClient.handle : " + message);
	}

	public void run() {

		System.out.println("Starting subscriber for channel ");

		while (true) {

			try {

				jedis.subscribe(new JedisPubSub() {
					@Override
					public void onMessage(String channel, String message) {

						handle(channel, message);

					}

					@Override
					public void onSubscribe(String channel, int subscribedChannels) {
					}

					@Override
					public void onUnsubscribe(String channel, int subscribedChannels) {
					}

					@Override
					public void onPMessage(String pattern, String channel, String message) {
					}

					@Override
					public void onPUnsubscribe(String pattern, int subscribedChannels) {
					}

					@Override
					public void onPSubscribe(String pattern, int subscribedChannels) {
					}

				}, channelDownlink);

			} catch (Exception e) {
				String timeStamp = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(Calendar.getInstance().getTime());

				System.out.println(timeStamp + "  " +"I m in catch Exception");
				e.printStackTrace();
			}

		}

	}

}
