package me.atticusthecoder.bulldog.common;

public abstract class Module {
	private String moduleName;
	private String authorName;
	
	public Module(String moduleName, String authorName) {
		this.moduleName = moduleName;
		this.authorName = authorName;
		Logger.info(getModuleName(), "Loaded module " + getModuleName() + " by " + getAuthorName());
		onLoad();
	}
	
	// Abstract methods
	public abstract void onLoad();
	
	// Getters
	
	public String getModuleName() {
		return moduleName;
	}
	
	public String getAuthorName() {
		return authorName;
	}
}
