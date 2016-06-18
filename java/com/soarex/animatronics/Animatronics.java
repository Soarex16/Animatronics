package com.soarex.animatronics;

import com.soarex.animatronics.client.gui.CreativeTabAnimatronics;
import com.soarex.animatronics.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by soarex on 17.06.16.
 */

@Mod(modid = Animatronics.MODID, version = Animatronics.VERSION)
public class Animatronics {

    @SidedProxy(clientSide = "com.soarex.animatronics.proxy.ClientProxy", serverSide = "com.soarex.animatronics.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static CreativeTabs creativeTabAnimatronics = new CreativeTabAnimatronics();

    public static final String MODID = "animatronics";
    public static final String VERSION = "0.1722.1a";

    @Instance
    public static Animatronics instance = new Animatronics();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
