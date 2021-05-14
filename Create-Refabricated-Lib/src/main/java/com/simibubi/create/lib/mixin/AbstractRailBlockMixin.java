package com.simibubi.create.lib.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.simibubi.create.lib.extensions.AbstractRailBlockExtensions;

import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.state.Property;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

@Mixin(AbstractRailBlock.class)
public abstract class AbstractRailBlockMixin implements AbstractRailBlockExtensions {
	@Shadow
	public abstract Property<RailShape> getShapeProperty();

	@Override
	public RailShape getRailDirection(BlockState state, IBlockReader world, BlockPos pos, @Nullable AbstractMinecartEntity cart) {
		return state.get(getShapeProperty());
	}

	@Override
	public RailShape getRailDirection(BlockState state) {
		return state.get(getShapeProperty());
	}
}