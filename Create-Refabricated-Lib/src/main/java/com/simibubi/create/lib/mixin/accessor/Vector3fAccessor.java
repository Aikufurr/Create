package com.simibubi.create.lib.mixin.accessor;

import net.minecraft.util.math.vector.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Vector3f.class)
public interface Vector3fAccessor {
	@Accessor("x")
	void create$x(float x);

	@Accessor("y")
	void create$y(float y);

	@Accessor("z")
	void create$z(float z);
}
