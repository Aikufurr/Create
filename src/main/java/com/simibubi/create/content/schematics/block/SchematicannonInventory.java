package com.simibubi.create.content.schematics.block;

import org.jetbrains.annotations.NotNull;

import com.simibubi.create.AllItems;
import com.simibubi.create.lib.lba.ItemStackHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SchematicannonInventory extends ItemStackHandler {
	/**
	 *
	 */
	private final SchematicannonTileEntity te;

	public SchematicannonInventory(SchematicannonTileEntity schematicannonTileEntity) {
		super(5);
		te = schematicannonTileEntity;
	}

	@Override
	protected void onContentsChanged(int slot) {
		super.onContentsChanged(slot);
		te.markDirty();
	}

	@Override
	public boolean isItemValid(int slot, @NotNull ItemStack stack) {
		switch (slot) {
		case 0: // Blueprint Slot
			return AllItems.SCHEMATIC.isIn(stack);
		case 1: // Blueprint output
			return false;
		case 2: // Book input
			return stack.isItemEqual(new ItemStack(Items.BOOK)) || stack.isItemEqual(new ItemStack(Items.WRITTEN_BOOK));
		case 3: // Material List output
			return false;
		case 4: // Gunpowder
			return stack.isItemEqual(new ItemStack(Items.GUNPOWDER));
		default:
			return super.isItemValid(slot, stack);
		}
	}
}
