package dsp.api;

import cpw.mods.fml.common.eventhandler.Event;

public class EventAddPageToCategory extends Event{

	
	public String pageName, categoryName;
	
	public EventAddPageToCategory(String pageName, String categoryName){
		this.pageName = pageName;
		this.categoryName = categoryName;
	}
	
}
