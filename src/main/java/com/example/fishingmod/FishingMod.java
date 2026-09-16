package com.example.fishingmod;

import com.example.fishingmod.client.ClientSetup;
import com.example.fishingmod.entity.FishEntity;
import com.example.fishingmod.entity.LureEntity;
import com.example.fishingmod.item.FishingRodItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(FishingMod.MODID)
public class FishingMod {
    public static final String MODID = "fishingmod";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<FishingRodItem> FISHING_ROD =
            ITEMS.register("fishing_rod", () -> new FishingRodItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> BASS =
            ITEMS.register("bass", () -> new Item(new Item.Properties().food(
                    new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).build())));

    public static final RegistryObject<EntityType<LureEntity>> LURE =
            ENTITIES.register("lure", () -> EntityType.Builder.<LureEntity>of(LureEntity::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F).clientTrackingRange(8).updateInterval(10).build("lure"));

    public static final RegistryObject<EntityType<FishEntity>> FISH =
            ENTITIES.register("bass", () -> EntityType.Builder.of(FishEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.4F, 0.3F).clientTrackingRange(8).updateInterval(10).build("bass"));

        public static final RegistryObject<SpawnEggItem> BASS_SPAWN_EGG =
            ITEMS.register("bass_spawn_egg", () -> new SpawnEggItem(FISH.get(), 0x6B8E6B, 0x2F4F2F,
                    new Item.Properties()));

    public FishingMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        ENTITIES.register(bus);
        bus.addListener(this::addCreative);
        bus.addListener(this::registerAttributes);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            bus.addListener(ClientSetup::registerRenderers);
            bus.addListener(ClientSetup::registerLayerDefinitions);
        }
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(FISHING_ROD);
            event.accept(BASS_SPAWN_EGG);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(BASS);
        }
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(FISH.get(), FishEntity.createAttributes().build());
    }
}
