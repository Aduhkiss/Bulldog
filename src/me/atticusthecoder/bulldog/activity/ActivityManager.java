package me.atticusthecoder.bulldog.activity;

import org.javacord.api.entity.activity.ActivityType;

import me.atticusthecoder.bulldog.Main;
import me.atticusthecoder.bulldog.common.Module;

public class ActivityManager extends Module {

	public ActivityManager() {
		super("Activity Manager", "Atticus Zambrana");
	}
	
	private String activity;
	private ActivityType activityType;

	@Override
	public void onLoad() {
		// Add the activities that we want to run
		//update();
		Main.getBot().getApi().updateActivity(ActivityType.PLAYING, Main.getBot().cm.PREFIX + "help");
	}
	
	public void update() {
		//Main.getBot().getApi().updateActivity(ActivityType.PLAYING, "LOL");
		System.out.println("Update!");
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				update();
			}
		};
		t.start();
	}

}
