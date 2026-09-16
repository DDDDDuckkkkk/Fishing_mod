// Made with Blockbench 5.1.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Renamed to comply with Java naming conventions (UpperCamelCase class, lowerCamelCase members)
// NOTE: getChild("...") strings are Blockbench group names in the model file - do NOT change them

package com.example.fishingmod.client.model;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FishingRodModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "fishing_rod_model"), "main");
	private final ModelPart root;
	private final ModelPart magAndLefthand;
	private final ModelPart lefthand;
	private final ModelPart lefthandPos;
	private final ModelPart gunAndRighthand;
	private final ModelPart righthand;
	private final ModelPart righthandPos;
	private final ModelPart camera;
	private final ModelPart positioning;
	private final ModelPart thirdpersonHand;
	private final ModelPart ground;
	private final ModelPart fixed;
	private final ModelPart view;
	private final ModelPart idleView;
	private final ModelPart ironView;
	private final ModelPart refitView;
	private final ModelPart refitMuzzleView;
	private final ModelPart refitStockView;
	private final ModelPart refitScopeView;
	private final ModelPart refitExtendedMagView;
	private final ModelPart refitLaserView;
	private final ModelPart refitGripView;
	private final ModelPart constraint;
	private final ModelPart positioning2;
	private final ModelPart muzzleFlash;
	private final ModelPart muzzlePos;
	private final ModelPart laserPos;
	private final ModelPart scopePos;
	private final ModelPart stockPos;
	private final ModelPart gripPos;
	private final ModelPart shell;
	private final ModelPart fishing2;
	private final ModelPart bone5;
	private final ModelPart fishing;
	private final ModelPart bone7;
	private final ModelPart bone8;
	private final ModelPart bone9;
	private final ModelPart bone10;
	private final ModelPart bone11;
	private final ModelPart bone6;
	private final ModelPart fishingReel2;
	private final ModelPart bone3;
	private final ModelPart fishingReelHandle;
	private final ModelPart bone4;
	private final ModelPart bone2;
	private final ModelPart bone;

	public FishingRodModel(ModelPart root) {
		this.root = root.getChild("root");
		this.magAndLefthand = this.root.getChild("mag_and_lefthand");
		this.lefthand = this.magAndLefthand.getChild("lefthand");
		this.lefthandPos = this.lefthand.getChild("lefthand_pos");
		this.gunAndRighthand = this.root.getChild("gun_and_righthand");
		this.righthand = this.gunAndRighthand.getChild("righthand");
		this.righthandPos = this.righthand.getChild("righthand_pos");
		this.camera = root.getChild("camera");
		this.positioning = root.getChild("positioning");
		this.thirdpersonHand = this.positioning.getChild("thirdperson_hand");
		this.ground = this.positioning.getChild("ground");
		this.fixed = this.positioning.getChild("fixed");
		this.view = root.getChild("view");
		this.idleView = this.view.getChild("idle_view");
		this.ironView = this.view.getChild("iron_view");
		this.refitView = this.view.getChild("refit_view");
		this.refitMuzzleView = this.view.getChild("refit_muzzle_view");
		this.refitStockView = this.view.getChild("refit_stock_view");
		this.refitScopeView = this.view.getChild("refit_scope_view");
		this.refitExtendedMagView = this.view.getChild("refit_extended_mag_view");
		this.refitLaserView = this.view.getChild("refit_laser_view");
		this.refitGripView = this.view.getChild("refit_grip_view");
		this.constraint = root.getChild("constraint");
		this.positioning2 = root.getChild("positioningII");
		this.muzzleFlash = this.positioning2.getChild("muzzle_flash");
		this.muzzlePos = this.positioning2.getChild("muzzle_pos");
		this.laserPos = this.positioning2.getChild("laser_pos");
		this.scopePos = this.positioning2.getChild("scope_pos");
		this.stockPos = this.positioning2.getChild("stock_pos");
		this.gripPos = this.positioning2.getChild("grip_pos");
		this.shell = this.positioning2.getChild("shell");
		this.fishing2 = root.getChild("fishingII");
		this.bone5 = this.fishing2.getChild("boneV");
		this.fishing = this.bone5.getChild("fishing");
		this.bone7 = this.fishing.getChild("boneVII");
		this.bone8 = this.bone7.getChild("boneVIII");
		this.bone9 = this.bone8.getChild("boneVIIII");
		this.bone10 = this.bone9.getChild("boneX");
		this.bone11 = this.bone10.getChild("boneXI");
		this.bone6 = this.bone5.getChild("boneVI");
		this.fishingReel2 = this.bone5.getChild("Fishing_reel_II");
		this.bone3 = this.fishingReel2.getChild("boneIII");
		this.fishingReelHandle = this.fishingReel2.getChild("Fishing reel handel");
		this.bone4 = this.fishingReel2.getChild("boneIV");
		this.bone2 = this.bone4.getChild("boneII");
		this.bone = this.bone2.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		PartDefinition root = partDefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.1F, 5.8F));

		PartDefinition magAndLefthand = root.addOrReplaceChild("mag_and_lefthand", CubeListBuilder.create(), PartPose.offset(0.0F, 2.1F, -5.8F));

		PartDefinition lefthand = magAndLefthand.addOrReplaceChild("lefthand", CubeListBuilder.create(), PartPose.offset(-6.0F, -13.2F, 8.0F));

		PartDefinition lefthandPos = lefthand.addOrReplaceChild("lefthand_pos", CubeListBuilder.create().texOffs(55, 25).addBox(-7.0F, -18.0F, -2.0F, 3.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 11.0F, 0.0F));

		PartDefinition gunAndRighthand = root.addOrReplaceChild("gun_and_righthand", CubeListBuilder.create(), PartPose.offset(0.0F, 7.9F, -5.8F));

		PartDefinition righthand = gunAndRighthand.addOrReplaceChild("righthand", CubeListBuilder.create(), PartPose.offset(6.0F, -19.0F, 8.0F));

		PartDefinition righthandPos = righthand.addOrReplaceChild("righthand_pos", CubeListBuilder.create().texOffs(42, 20).addBox(4.0F, -18.0F, -2.0F, 3.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 11.0F, 0.0F));

		PartDefinition camera = partDefinition.addOrReplaceChild("camera", CubeListBuilder.create(), PartPose.offset(2.75F, 9.7125F, 14.0F));

		PartDefinition positioning = partDefinition.addOrReplaceChild("positioning", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -8.0F));

		PartDefinition thirdpersonHand = positioning.addOrReplaceChild("thirdperson_hand", CubeListBuilder.create(), PartPose.offset(0.0F, -7.925F, 15.65F));

		PartDefinition ground = positioning.addOrReplaceChild("ground", CubeListBuilder.create(), PartPose.offset(0.0F, -8.1F, 0.65F));

		PartDefinition fixed = positioning.addOrReplaceChild("fixed", CubeListBuilder.create(), PartPose.offset(0.05F, -7.675F, 0.95F));

		PartDefinition view = partDefinition.addOrReplaceChild("view", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition idleView = view.addOrReplaceChild("idle_view", CubeListBuilder.create(), PartPose.offset(2.75F, -14.2875F, 14.0F));

		PartDefinition ironView = view.addOrReplaceChild("iron_view", CubeListBuilder.create(), PartPose.offset(0.0F, -13.55F, 14.25F));

		PartDefinition refitView = view.addOrReplaceChild("refit_view", CubeListBuilder.create(), PartPose.offset(23.0F, -10.2F, 3.15F));

		PartDefinition refitMuzzleView = view.addOrReplaceChild("refit_muzzle_view", CubeListBuilder.create(), PartPose.offset(8.0F, -9.0F, -16.0F));

		PartDefinition refitStockView = view.addOrReplaceChild("refit_stock_view", CubeListBuilder.create(), PartPose.offset(10.0F, -9.0F, 11.0F));

		PartDefinition refitScopeView = view.addOrReplaceChild("refit_scope_view", CubeListBuilder.create(), PartPose.offset(8.0F, -14.125F, 10.3F));

		PartDefinition refitExtendedMagView = view.addOrReplaceChild("refit_extended_mag_view", CubeListBuilder.create(), PartPose.offset(10.0F, 2.0F, 0.0F));

		PartDefinition refitLaserView = view.addOrReplaceChild("refit_laser_view", CubeListBuilder.create(), PartPose.offset(7.0F, -10.0F, 0.0F));

		PartDefinition refitGripView = view.addOrReplaceChild("refit_grip_view", CubeListBuilder.create(), PartPose.offset(6.8F, -6.4F, -4.0F));

		PartDefinition constraint = partDefinition.addOrReplaceChild("constraint", CubeListBuilder.create(), PartPose.offset(0.0F, 11.475F, -18.625F));

		PartDefinition positioning2 = partDefinition.addOrReplaceChild("positioningII", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, -1.425F));

		PartDefinition muzzleFlash = positioning2.addOrReplaceChild("muzzle_flash", CubeListBuilder.create(), PartPose.offset(0.0F, -2.55F, -24.525F));

		PartDefinition muzzlePos = positioning2.addOrReplaceChild("muzzle_pos", CubeListBuilder.create(), PartPose.offset(0.0F, -2.55F, -22.925F));

		PartDefinition laserPos = positioning2.addOrReplaceChild("laser_pos", CubeListBuilder.create(), PartPose.offset(1.462F, -2.55F, -11.6F));

		PartDefinition scopePos = positioning2.addOrReplaceChild("scope_pos", CubeListBuilder.create(), PartPose.offset(0.0F, -4.01F, -2.3F));

		PartDefinition stockPos = positioning2.addOrReplaceChild("stock_pos", CubeListBuilder.create(), PartPose.offset(0.0F, -2.525F, 5.55F));

		PartDefinition gripPos = positioning2.addOrReplaceChild("grip_pos", CubeListBuilder.create(), PartPose.offset(0.0F, -1.075F, -11.6F));

		PartDefinition shell = positioning2.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(-0.2F, -2.75F, -4.6F));

		PartDefinition fishing2 = partDefinition.addOrReplaceChild("fishingII", CubeListBuilder.create(), PartPose.offset(-1.5F, 22.5F, -3.5F));

		PartDefinition bone5 = fishing2.addOrReplaceChild("boneV", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-1.0F, -2.0F, -8.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(-0.5F, -1.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -5.5F, 3.5F));

		PartDefinition fishing = bone5.addOrReplaceChild("fishing", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -10.0F));

		PartDefinition bone7 = fishing.addOrReplaceChild("boneVII", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(0.0F, -1.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.5F, -2.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(0.0F, -2.5F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -1.0F, -7.0F));

		PartDefinition cubeR1 = bone7.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(55, 40).addBox(1.0F, -0.5F, -5.5F, 0.0F, 0.5F, 6.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 9.0F, -0.131F, 0.0433F, -0.0057F));

		PartDefinition bone8 = bone7.addOrReplaceChild("boneVIII", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(0.0F, -1.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.5F, -2.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(0.0F, -2.5F, 3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(15, 55).mirror().addBox(0.5F, -0.75F, 4.0F, 0.0F, 0.5F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition bone9 = bone8.addOrReplaceChild("boneVIIII", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 5.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(0.0F, -1.0F, 5.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.5F, -2.0F, 5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 5.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(0.0F, -2.5F, 5.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(21, 55).mirror().addBox(0.5F, -0.75F, 5.0F, 0.0F, 0.5F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition bone10 = bone9.addOrReplaceChild("boneX", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 11.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(0.0F, -1.0F, 11.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 11.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.5F, -2.0F, 11.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 11.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(0.0F, -2.5F, 11.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(28, 55).addBox(0.5F, -0.75F, 11.0F, 0.0F, 0.5F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition bone11 = bone10.addOrReplaceChild("boneXI", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 17.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 17.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 17.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 25).addBox(0.0F, -2.0F, 17.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, -6.0F));

		PartDefinition cubeR2 = bone11.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(76, 74).addBox(1.0F, -0.5F, 10.0F, 0.0F, 0.5F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 7.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bone6 = bone5.addOrReplaceChild("boneVI", CubeListBuilder.create().texOffs(2, 1).addBox(0.0F, 0.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 1).addBox(0.0F, -1.0F, 3.0F, 1.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(1.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.5F, -2.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(3, 1).addBox(0.0F, -1.0F, 3.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -10.0F));

		PartDefinition fishingReel2 = bone5.addOrReplaceChild("Fishing_reel_II", CubeListBuilder.create(), PartPose.offset(-1.5F, 5.5F, -3.5F));

		PartDefinition bone3 = fishingReel2.addOrReplaceChild("boneIII", CubeListBuilder.create().texOffs(24, 14).addBox(0.0F, -2.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 24).addBox(3.0F, -3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 24).addBox(0.0F, -3.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.5F, 3.5F));

		PartDefinition fishingReelHandle = fishingReel2.addOrReplaceChild("Fishing reel handel", CubeListBuilder.create().texOffs(14, 14).addBox(1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(8, 21).addBox(2.0F, -0.5F, 2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 15).addBox(0.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -3.0F, 4.0F));

		PartDefinition bone4 = fishingReel2.addOrReplaceChild("boneIV", CubeListBuilder.create().texOffs(1, 1).addBox(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -1.5F, 0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.0F, 2.75F));

		PartDefinition cubeR3 = bone4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 52).addBox(1.0F, -0.5F, -3.0F, 0.0F, 0.5F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.25F, -3.25F, -0.2618F, 0.0F, 0.0F));

		PartDefinition bone2 = bone4.addOrReplaceChild("boneII", CubeListBuilder.create().texOffs(2, 8).addBox(-1.0F, -0.5F, -3.75F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 19).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -0.5F, 0.75F));

		PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(7, 27).addBox(0.0F, -2.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 24).addBox(0.0F, -4.0F, 0.0F, 3.0F, 0.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 24).addBox(3.0F, -4.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 17).addBox(0.0F, -4.0F, 0.0F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 3.5F, -3.5F));

		return LayerDefinition.create(meshDefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		camera.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		positioning.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		view.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		constraint.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		positioning2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		fishing2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
