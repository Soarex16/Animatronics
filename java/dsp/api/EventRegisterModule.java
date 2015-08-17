package dsp.api;

import cpw.mods.fml.common.eventhandler.Event;

public class EventRegisterModule extends Event{
	
	public IModule module;
	public String modid;

	public EventRegisterModule(IModule module, String modid){
		this.module = module;
		this.modid = modid;
	}

}
