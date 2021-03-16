package com.simibubi.create;

import static com.simibubi.create.AllTags.forgeItemTag;
import static com.simibubi.create.AllTags.AllItemTags.CREATE_INGOTS;
import static com.simibubi.create.AllTags.AllItemTags.CRUSHED_ORES;
import static com.simibubi.create.AllTags.AllItemTags.NUGGETS;
import static com.simibubi.create.AllTags.AllItemTags.PLATES;
import static com.simibubi.create.content.AllSections.CURIOSITIES;
import static com.simibubi.create.content.AllSections.KINETICS;
import static com.simibubi.create.content.AllSections.LOGISTICS;
import static com.simibubi.create.content.AllSections.MATERIALS;
import static com.simibubi.create.content.AllSections.SCHEMATICS;

import com.simibubi.create.AllTags.AllItemTags;
import com.simibubi.create.content.contraptions.components.structureMovement.glue.SuperGlueItem;
import com.simibubi.create.content.contraptions.components.structureMovement.mounted.MinecartContraptionItem;
import com.simibubi.create.content.contraptions.components.structureMovement.train.MinecartCouplingItem;
import com.simibubi.create.content.contraptions.goggles.GogglesItem;
import com.simibubi.create.content.contraptions.processing.burner.BlazeBurnerBlockItem;
import com.simibubi.create.content.contraptions.relays.belt.item.BeltConnectorItem;
import com.simibubi.create.content.contraptions.relays.gearbox.VerticalGearboxItem;
import com.simibubi.create.content.contraptions.wrench.WrenchItem;
import com.simibubi.create.content.contraptions.wrench.WrenchModel;
import com.simibubi.create.content.curiosities.BuildersTeaItem;
import com.simibubi.create.content.curiosities.ChromaticCompoundColor;
import com.simibubi.create.content.curiosities.ChromaticCompoundItem;
import com.simibubi.create.content.curiosities.CombustibleItem;
import com.simibubi.create.content.curiosities.RefinedRadianceItem;
import com.simibubi.create.content.curiosities.ShadowSteelItem;
import com.simibubi.create.content.curiosities.TreeFertilizerItem;
import com.simibubi.create.content.curiosities.symmetry.SymmetryWandItem;
import com.simibubi.create.content.curiosities.symmetry.client.SymmetryWandModel;
import com.simibubi.create.content.curiosities.tools.DeforesterItem;
import com.simibubi.create.content.curiosities.tools.DeforesterModel;
import com.simibubi.create.content.curiosities.tools.ExtendoGripItem;
import com.simibubi.create.content.curiosities.tools.ExtendoGripModel;
import com.simibubi.create.content.curiosities.tools.SandPaperItem;
import com.simibubi.create.content.curiosities.tools.SandPaperItemRenderer.SandPaperModel;
import com.simibubi.create.content.curiosities.zapper.blockzapper.BlockzapperItem;
import com.simibubi.create.content.curiosities.zapper.blockzapper.BlockzapperModel;
import com.simibubi.create.content.curiosities.zapper.terrainzapper.WorldshaperItem;
import com.simibubi.create.content.curiosities.zapper.terrainzapper.WorldshaperModel;
import com.simibubi.create.content.logistics.item.filter.FilterItem;
import com.simibubi.create.content.schematics.item.SchematicAndQuillItem;
import com.simibubi.create.content.schematics.item.SchematicItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.HiddenIngredientItem;
import com.simibubi.create.foundation.item.TagDependentIngredientItem;
import com.simibubi.create.foundation.item.TooltipHelper;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class AllItems {

	private static final CreateRegistrate REGISTRATE = Create.registrate()
		.itemGroup(() -> Create.baseCreativeTab);

	// Schematics

	static {
		REGISTRATE.startSection(MATERIALS);
	}

	public static final ItemEntry<Item> COPPER_NUGGET =
		taggedIngredient("copper_nugget", forgeItemTag("nuggets/copper"), NUGGETS.tag),
		ZINC_NUGGET = taggedIngredient("zinc_nugget", forgeItemTag("nuggets/zinc"), NUGGETS.tag),
		BRASS_NUGGET = taggedIngredient("brass_nugget", forgeItemTag("nuggets/brass"), NUGGETS.tag),

		COPPER_SHEET = taggedIngredient("copper_sheet", forgeItemTag("plates/copper"), PLATES.tag),
		BRASS_SHEET = taggedIngredient("brass_sheet", forgeItemTag("plates/brass"), PLATES.tag),
		IRON_SHEET = taggedIngredient("iron_sheet", forgeItemTag("plates/iron"), PLATES.tag),
		GOLDEN_SHEET = taggedIngredient("golden_sheet", forgeItemTag("plates/gold"), PLATES.tag),
		LAPIS_SHEET = taggedIngredient("lapis_sheet", forgeItemTag("plates/lapis_lazuli"), PLATES.tag),

		CRUSHED_IRON = taggedIngredient("crushed_iron_ore", CRUSHED_ORES.tag),
		CRUSHED_GOLD = taggedIngredient("crushed_gold_ore", CRUSHED_ORES.tag),
		CRUSHED_COPPER = taggedIngredient("crushed_copper_ore", CRUSHED_ORES.tag),
		CRUSHED_ZINC = taggedIngredient("crushed_zinc_ore", CRUSHED_ORES.tag),
		CRUSHED_BRASS = taggedIngredient("crushed_brass", CRUSHED_ORES.tag);

	public static final ItemEntry<TagDependentIngredientItem> CRUSHED_OSMIUM = compatCrushedOre("osmium"),
		CRUSHED_PLATINUM = compatCrushedOre("platinum"), CRUSHED_SILVER = compatCrushedOre("silver"),
		CRUSHED_TIN = compatCrushedOre("tin"), CRUSHED_LEAD = compatCrushedOre("lead"),
		CRUSHED_QUICKSILVER = compatCrushedOre("quicksilver"), CRUSHED_BAUXITE = compatCrushedOre("aluminum"),
		CRUSHED_URANIUM = compatCrushedOre("uranium"), CRUSHED_NICKEL = compatCrushedOre("nickel");

	public static final ItemEntry<Item> ANDESITE_ALLOY = ingredient("andesite_alloy"),
		COPPER_INGOT = taggedIngredient("copper_ingot", forgeItemTag("ingots/copper"), CREATE_INGOTS.tag),
		ZINC_INGOT = taggedIngredient("zinc_ingot", forgeItemTag("ingots/zinc"), CREATE_INGOTS.tag),
		BRASS_INGOT = taggedIngredient("brass_ingot", forgeItemTag("ingots/brass"), CREATE_INGOTS.tag),

		WHEAT_FLOUR = ingredient("wheat_flour"), DOUGH = ingredient("dough"), CINDER_FLOUR = ingredient("cinder_flour"),
		POWDERED_OBSIDIAN = ingredient("powdered_obsidian"), ROSE_QUARTZ = ingredient("rose_quartz"),
		POLISHED_ROSE_QUARTZ = ingredient("polished_rose_quartz"), PROPELLER = ingredient("propeller"),
		WHISK = ingredient("whisk"), BRASS_HAND = ingredient("brass_hand"),
		CRAFTER_SLOT_COVER = ingredient("crafter_slot_cover");

	public static final ItemEntry<HiddenIngredientItem> BLAZE_CAKE_BASE =
		REGISTRATE.item("blaze_cake_base", HiddenIngredientItem::new)
			.tag(AllItemTags.UPRIGHT_ON_BELT.tag)
			.register();

	public static final ItemEntry<CombustibleItem> BLAZE_CAKE = REGISTRATE.item("blaze_cake", CombustibleItem::new)
		.tag(AllItemTags.UPRIGHT_ON_BELT.tag)
		.register();

	public static final ItemEntry<Item> BAR_OF_CHOCOLATE = REGISTRATE.item("bar_of_chocolate", Item::new)
		.properties(p -> p.food(new FoodComponent.Builder().hunger(5)
			.saturationModifier(0.6F)
			.build()))
		.lang("Bar of Chocolate")
		.register();

	public static final ItemEntry<BuildersTeaItem> BUILDERS_TEA = REGISTRATE.item("builders_tea", BuildersTeaItem::new)
		.tag(AllItemTags.UPRIGHT_ON_BELT.tag)
		.properties(p -> p.maxCount(16))
		.lang("Builder's Tea")
		.register();

	public static final ItemEntry<ChromaticCompoundItem> CHROMATIC_COMPOUND =
		REGISTRATE.item("chromatic_compound", ChromaticCompoundItem::new)
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.model(AssetLookup.existingItemModel())
			.onRegister(CreateRegistrate.itemColors(() -> ChromaticCompoundColor::new))
			.register();

	public static final ItemEntry<ShadowSteelItem> SHADOW_STEEL = REGISTRATE.item("shadow_steel", ShadowSteelItem::new)
		.properties(p -> p.rarity(Rarity.UNCOMMON))
		.register();

	public static final ItemEntry<RefinedRadianceItem> REFINED_RADIANCE =
		REGISTRATE.item("refined_radiance", RefinedRadianceItem::new)
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.register();

	public static final ItemEntry<Item>

	ELECTRON_TUBE = ingredient("electron_tube"), INTEGRATED_CIRCUIT = ingredient("integrated_circuit");

	// Kinetics

	static {
		REGISTRATE.startSection(KINETICS);
	}

	public static final ItemEntry<BeltConnectorItem> BELT_CONNECTOR =
		REGISTRATE.item("belt_connector", BeltConnectorItem::new)
			.lang("Mechanical Belt")
			.register();

	public static final ItemEntry<VerticalGearboxItem> VERTICAL_GEARBOX =
		REGISTRATE.item("vertical_gearbox", VerticalGearboxItem::new)
			.model(AssetLookup.<VerticalGearboxItem>customItemModel("gearbox", "item_vertical"))
			.onRegister(v -> TooltipHelper.referTo(v, AllBlocks.GEARBOX))
			.register();

	public static final ItemEntry<BlazeBurnerBlockItem> EMPTY_BLAZE_BURNER =
		REGISTRATE.item("empty_blaze_burner", BlazeBurnerBlockItem::empty)
			.model(AssetLookup.<BlazeBurnerBlockItem>customItemModel("blaze_burner", "block"))
			.register();

	public static final ItemEntry<SuperGlueItem> SUPER_GLUE = REGISTRATE.item("super_glue", SuperGlueItem::new)
		.register();

	public static final ItemEntry<MinecartCouplingItem> MINECART_COUPLING =
		REGISTRATE.item("minecart_coupling", MinecartCouplingItem::new)
			.register();

	public static final ItemEntry<SandPaperItem> SAND_PAPER = REGISTRATE.item("sand_paper", SandPaperItem::new)
		.transform(CreateRegistrate.customRenderedItem(() -> SandPaperModel::new))
		.register();

	public static final ItemEntry<SandPaperItem> RED_SAND_PAPER = REGISTRATE.item("red_sand_paper", SandPaperItem::new)
		.transform(CreateRegistrate.customRenderedItem(() -> SandPaperModel::new))
		.onRegister(s -> TooltipHelper.referTo(s, SAND_PAPER))
		.register();

	public static final ItemEntry<WrenchItem> WRENCH = REGISTRATE.item("wrench", WrenchItem::new)
		.properties(p -> p.maxCount(1))
		.transform(CreateRegistrate.customRenderedItem(() -> WrenchModel::new))
		.model(AssetLookup.itemModelWithPartials())
		.register();

	public static final ItemEntry<GogglesItem> GOGGLES = REGISTRATE.item("goggles", GogglesItem::new)
		.properties(p -> p.maxCount(1))
		.model(AssetLookup.existingItemModel())
		.lang("Engineer's Goggles")
		.register();

	public static final ItemEntry<MinecartContraptionItem> MINECART_CONTRAPTION =
		REGISTRATE.item("minecart_contraption", MinecartContraptionItem::rideable)
			.register();

	public static final ItemEntry<MinecartContraptionItem> FURNACE_MINECART_CONTRAPTION =
		REGISTRATE.item("furnace_minecart_contraption", MinecartContraptionItem::furnace)
			.register();

	public static final ItemEntry<MinecartContraptionItem> CHEST_MINECART_CONTRAPTION =
		REGISTRATE.item("chest_minecart_contraption", MinecartContraptionItem::chest)
			.register();

	// Logistics

	static {
		REGISTRATE.startSection(LOGISTICS);
	}

	public static final ItemEntry<FilterItem> FILTER = REGISTRATE.item("filter", FilterItem::regular)
		.model(AssetLookup.existingItemModel())
		.register();

	public static final ItemEntry<FilterItem> ATTRIBUTE_FILTER =
		REGISTRATE.item("attribute_filter", FilterItem::attribute)
			.model(AssetLookup.existingItemModel())
			.register();

	// Curiosities

	static {
		REGISTRATE.startSection(CURIOSITIES);
	}

	public static final ItemEntry<TreeFertilizerItem> TREE_FERTILIZER =
		REGISTRATE.item("tree_fertilizer", TreeFertilizerItem::new)
			.register();

	public static final ItemEntry<BlockzapperItem> BLOCKZAPPER =
		REGISTRATE.item("handheld_blockzapper", BlockzapperItem::new)
			.transform(CreateRegistrate.customRenderedItem(() -> BlockzapperModel::new))
			.model(AssetLookup.itemModelWithPartials())
			.register();

	public static final ItemEntry<WorldshaperItem> WORLDSHAPER =
		REGISTRATE.item("handheld_worldshaper", WorldshaperItem::new)
			.transform(CreateRegistrate.customRenderedItem(() -> WorldshaperModel::new))
			.model(AssetLookup.itemModelWithPartials())
			.register();

	public static final ItemEntry<DeforesterItem> DEFORESTER = REGISTRATE.item("deforester", DeforesterItem::new)
		.transform(CreateRegistrate.customRenderedItem(() -> DeforesterModel::new))
		.model(AssetLookup.itemModelWithPartials())
		.register();

	public static final ItemEntry<SymmetryWandItem> WAND_OF_SYMMETRY =
		REGISTRATE.item("wand_of_symmetry", SymmetryWandItem::new)
			.transform(CreateRegistrate.customRenderedItem(() -> SymmetryWandModel::new))
			.model(AssetLookup.itemModelWithPartials())
			.register();

	public static final ItemEntry<ExtendoGripItem> EXTENDO_GRIP = REGISTRATE.item("extendo_grip", ExtendoGripItem::new)
		.transform(CreateRegistrate.customRenderedItem(() -> ExtendoGripModel::new))
		.model(AssetLookup.itemModelWithPartials())
		.register();

	// Schematics

	static {
		REGISTRATE.startSection(SCHEMATICS);
	}

	public static final ItemEntry<Item> EMPTY_SCHEMATIC = REGISTRATE.item("empty_schematic", Item::new)
		.properties(p -> p.maxCount(1))
		.register();

	public static final ItemEntry<SchematicAndQuillItem> SCHEMATIC_AND_QUILL =
		REGISTRATE.item("schematic_and_quill", SchematicAndQuillItem::new)
			.properties(p -> p.maxCount(1))
			.register();

	public static final ItemEntry<SchematicItem> SCHEMATIC = REGISTRATE.item("schematic", SchematicItem::new)
		.properties(p -> p.maxCount(1))
		.register();

	// Shortcuts

	private static ItemEntry<Item> ingredient(String name) {
		return REGISTRATE.item(name, Item::new)
			.register();
	}

	@SuppressWarnings("unused")
	private static ItemEntry<HiddenIngredientItem> hiddenIngredient(String name) {
		return REGISTRATE.item(name, HiddenIngredientItem::new)
			.register();
	}

	@SafeVarargs
	private static ItemEntry<Item> taggedIngredient(String name, Tag.Identified<Item>... tags) {
		return REGISTRATE.item(name, Item::new)
			.tag(tags)
			.register();
	}

	private static ItemEntry<TagDependentIngredientItem> compatCrushedOre(String metalName) {
		return REGISTRATE
			.item("crushed_" + metalName + "_ore",
				props -> new TagDependentIngredientItem(props, new Identifier("forge", "ores/" + metalName)))
			.tag(AllItemTags.CRUSHED_ORES.tag)
			.register();
	}

	// Load this class

	public static void register() {}

}