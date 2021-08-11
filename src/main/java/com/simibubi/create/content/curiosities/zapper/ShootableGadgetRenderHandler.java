package com.simibubi.create.content.curiosities.zapper;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.simibubi.create.lib.event.RenderHandCallback;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public abstract class ShootableGadgetRenderHandler {

	protected float leftHandAnimation;
	protected float rightHandAnimation;
	protected float lastLeftHandAnimation;
	protected float lastRightHandAnimation;
	protected boolean dontReequipLeft;
	protected boolean dontReequipRight;

	public void tick() {
		lastLeftHandAnimation = leftHandAnimation;
		lastRightHandAnimation = rightHandAnimation;
		leftHandAnimation *= animationDecay();
		rightHandAnimation *= animationDecay();
	}

	public float getAnimation(boolean rightHand, float partialTicks) {
		return Mth.lerp(partialTicks, rightHand ? lastRightHandAnimation : lastLeftHandAnimation,
			rightHand ? rightHandAnimation : leftHandAnimation);
	}

	protected float animationDecay() {
		return 0.8f;
	}

	public void shoot(InteractionHand hand, Vec3 location) {
		LocalPlayer player = Minecraft.getInstance().player;
		boolean rightHand = hand == InteractionHand.MAIN_HAND ^ player.getMainArm() == HumanoidArm.LEFT;
		if (rightHand) {
			rightHandAnimation = .2f;
			dontReequipRight = false;
		} else {
			leftHandAnimation = .2f;
			dontReequipLeft = false;
		}
		playSound(hand, location);
	}

	protected abstract void playSound(InteractionHand hand, Vec3 position);

	protected abstract boolean appliesTo(ItemStack stack);

	protected abstract void transformTool(PoseStack ms, float flip, float equipProgress, float recoil, float pt);

	protected abstract void transformHand(PoseStack ms, float flip, float equipProgress, float recoil, float pt);

	public void register() {
		RenderHandCallback.EVENT.register(this::onRenderPlayerHand);
	}

	public boolean onRenderPlayerHand(AbstractClientPlayer client, InteractionHand hand, ItemStack heldItem, PoseStack ms, MultiBufferSource vertexConsumers, float tickDelta, float pitch, float swingProgress, float equipProgress, int light) {
		if (!appliesTo(heldItem))
			return false;

		Minecraft mc = Minecraft.getInstance();
		AbstractClientPlayer player = mc.player;
		TextureManager textureManager = mc.getTextureManager();
		PlayerRenderer playerrenderer = (PlayerRenderer) mc.getEntityRenderDispatcher()
			.getRenderer(player);
		ItemInHandRenderer firstPersonRenderer = mc.getItemInHandRenderer();

//		PoseStack ms = event.getMatrixStack();
//		IRenderTypeBuffer buffer = event.getBuffers();
//		int light = event.getLight();
//		float pt = event.getPartialTicks();

		boolean rightHand = hand == InteractionHand.MAIN_HAND ^ mc.player.getMainArm() == HumanoidArm.LEFT;
		float recoil = rightHand ? Mth.lerp(tickDelta, lastRightHandAnimation, rightHandAnimation)
			: Mth.lerp(tickDelta, lastLeftHandAnimation, leftHandAnimation);
//		float equipProgress = event.getEquipProgress();

		if (rightHand && (rightHandAnimation > .01f || dontReequipRight))
			equipProgress = 0;
		if (!rightHand && (leftHandAnimation > .01f || dontReequipLeft))
			equipProgress = 0;

		// Render arm
		ms.pushPose();
		textureManager.bindForSetup(player.getSkinTextureLocation());

		float flip = rightHand ? 1.0F : -1.0F;
		float f1 = Mth.sqrt(swingProgress);
		float f2 = -0.3F * Mth.sin(f1 * (float) Math.PI);
		float f3 = 0.4F * Mth.sin(f1 * ((float) Math.PI * 2F));
		float f4 = -0.4F * Mth.sin(swingProgress * (float) Math.PI);
		float f5 = Mth.sin(swingProgress * swingProgress * (float) Math.PI);
		float f6 = Mth.sin(f1 * (float) Math.PI);

		ms.translate(flip * (f2 + 0.64F - .1f), f3 + -0.4F + equipProgress * -0.6F, f4 + -0.72F + .3f + recoil);
		ms.mulPose(Vector3f.YP.rotationDegrees(flip * 75.0F));
		ms.mulPose(Vector3f.YP.rotationDegrees(flip * f6 * 70.0F));
		ms.mulPose(Vector3f.ZP.rotationDegrees(flip * f5 * -20.0F));
		ms.translate(flip * -1.0F, 3.6F, 3.5F);
		ms.mulPose(Vector3f.ZP.rotationDegrees(flip * 120.0F));
		ms.mulPose(Vector3f.XP.rotationDegrees(200.0F));
		ms.mulPose(Vector3f.YP.rotationDegrees(flip * -135.0F));
		ms.translate(flip * 5.6F, 0.0F, 0.0F);
		ms.mulPose(Vector3f.YP.rotationDegrees(flip * 40.0F));
		transformHand(ms, flip, equipProgress, recoil, tickDelta);
		if (rightHand)
			playerrenderer.renderRightHand(ms, vertexConsumers, light, player);
		else
			playerrenderer.renderLeftHand(ms, vertexConsumers, light, player);
		ms.popPose();

		// Render gadget
		ms.pushPose();
		ms.translate(flip * (f2 + 0.64F - .1f), f3 + -0.4F + equipProgress * -0.6F, f4 + -0.72F - 0.1f + recoil);
		ms.mulPose(Vector3f.YP.rotationDegrees(flip * f6 * 70.0F));
		ms.mulPose(Vector3f.ZP.rotationDegrees(flip * f5 * -20.0F));
		transformTool(ms, flip, equipProgress, recoil, tickDelta);
		firstPersonRenderer.renderItem(mc.player, heldItem,
			rightHand ? ItemTransforms.TransformType.FIRST_PERSON_RIGHT_HAND
				: ItemTransforms.TransformType.FIRST_PERSON_LEFT_HAND,
			!rightHand, ms, vertexConsumers, light);
		ms.popPose();

		return true;
	}

	public void dontAnimateItem(InteractionHand hand) {
		LocalPlayer player = Minecraft.getInstance().player;
		boolean rightHand = hand == InteractionHand.MAIN_HAND ^ player.getMainArm() == HumanoidArm.LEFT;
		dontReequipRight |= rightHand;
		dontReequipLeft |= !rightHand;
	}

}
