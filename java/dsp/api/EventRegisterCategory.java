package dsp.api;

import cpw.mods.fml.common.eventhandler.Event;

public class EventRegisterCategory extends Event{
	
	public DebugScreenCategory category;
	public String modid;
	
	public EventRegisterCategory(DebugScreenCategory c, String modid){
		this.category = c;
		this.modid = modid;
	}
}
