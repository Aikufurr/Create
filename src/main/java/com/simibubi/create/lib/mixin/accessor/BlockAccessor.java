package com.simibubi.create.lib.mixin.accessor;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Block.class)
public interface BlockAccessor {
	@Invoker("popExperience")
	void create$popExperience(ServerLevel serverWorld, BlockPos blockPos, int i);
}