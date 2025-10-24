package com.example.tp1;

public class NotificationManager {

	private Notification[] channels;
	private int count;

	public NotificationManager() {
		this.channels = new Notification[4];
		this.count = 0;
	}

	public void addChannel(Notification n) {
		if (count == channels.length) {
			Notification[] tmp = new Notification[channels.length * 2];
			System.arraycopy(channels, 0, tmp, 0, channels.length);
			channels = tmp;
		}
		channels[count++] = n;

	}

	public void broadcast(String recipient, String message) {
		for (int i = 0; i < count - 1; i++) {
			for (int j = i + 1; j < count; j++) {
				if (channels[j].getPriority() > channels[i].getPriority()) {
					Notification tmp = channels[i];
					channels[i]=channels[j];
					channels[j]=tmp;

				}

			}
		}
		System.out.println("Broadcast to " + recipient + ":");
		for (int i = 0; i < count ; i++) {
		 Notification current=channels[i];
		 System.out.printf("Channel [%s, prio=%d]: ",
				 current.getType(), current.getPriority());
		 current.send(recipient, message);
		
		}
	}

}
