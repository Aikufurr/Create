package com.simibubi.create.lib.utility;

import net.minecraft.entity.item.minecart.AbstractMinecartEntity;

/**
 * Interface to allow access to MinecartController class from lib
 */
public interface MinecartController {
	// I don't like this but it works.
	public class InitController {
		public static MinecartController initController = null;
	}
	MinecartController create(AbstractMinecartEntity cart);
}
