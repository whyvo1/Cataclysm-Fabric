package com.github.l_ender.cataclysm.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import java.util.List;

public class ModTemplate extends Item {
    private static final Formatting TITLE_FORMAT = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMAT = Formatting.BLUE;
    private static final String DESCRIPTION_ID = Util.createTranslationKey("item", Identifier.ofVanilla("smithing_template"));
    private static final Text INGREDIENTS_TITLE = Text.translatable(Util.createTranslationKey("item", Identifier.ofVanilla("smithing_template.ingredients"))).formatted(TITLE_FORMAT);
    private static final Text APPLIES_TO_TITLE = Text.translatable(Util.createTranslationKey("item", Identifier.ofVanilla("smithing_template.applies_to"))).formatted(TITLE_FORMAT);
    private static final Text IGNITIUM_UPGRADE = Text.translatable("item.cataclysm.ignitium_upgrade.desc").formatted(TITLE_FORMAT);
    private static final Text IGNITIUM_UPGRADE_APPLIES_TO = Text.translatable("item.cataclysm.ignitium_upgrade.applies_to.desc").formatted(DESCRIPTION_FORMAT);
    private static final Text IGNITIUM_UPGRADE_INGREDIENTS = Text.translatable("item.cataclysm.ignitium_upgrade.ingredients.desc").formatted(DESCRIPTION_FORMAT);

    private static final Text CURSIUM_UPGRADE = Text.translatable("item.cataclysm.cursium_upgrade.desc").formatted(TITLE_FORMAT);
    private static final Text CURSIUM_UPGRADE_APPLIES_TO = Text.translatable("item.cataclysm.cursium_upgrade.applies_to.desc").formatted(DESCRIPTION_FORMAT);
    private static final Text CURSIUM_UPGRADE_INGREDIENTS = Text.translatable("item.cataclysm.cursium_upgrade.ingredients.desc").formatted(DESCRIPTION_FORMAT);
    private static final Text IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION = Text.translatable("item.cataclysm.ignitium_upgrade.base_slot.desc");
    private static final Text IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Text.translatable("item.cataclysm.ignitium_upgrade.additions_slot.desc");
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.ofVanilla("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.ofVanilla("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.ofVanilla("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.ofVanilla("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.ofVanilla("item/empty_slot_ingot");
    private final Text appliesTo;
    private final Text ingredients;
    private final Text upgradeDescription;
    private final Text baseSlotDescription;
    private final Text additionsSlotDescription;
    private final List<Identifier> baseSlotEmptyIcons;
    private final List<Identifier> additionalSlotEmptyIcons;




    public ModTemplate(Text p_266834_, Text p_267043_, Text p_267048_, Text p_267278_, Text p_267090_, List<Identifier> p_266755_, List<Identifier> p_267060_) {
        super(new net.minecraft.item.Item.Settings().fireproof());
        this.appliesTo = p_266834_;
        this.ingredients = p_267043_;
        this.upgradeDescription = p_267048_;
        this.baseSlotDescription = p_267278_;
        this.additionsSlotDescription = p_267090_;
        this.baseSlotEmptyIcons = p_266755_;
        this.additionalSlotEmptyIcons = p_267060_;
    }


    public static ModTemplate createignitiumUpgradeTemplate() {
        return new ModTemplate(IGNITIUM_UPGRADE_APPLIES_TO, IGNITIUM_UPGRADE_INGREDIENTS, IGNITIUM_UPGRADE, IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION, IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createignitiumUpgradeIconList(), createignitiumUpgradeMaterialList());
    }

    public static ModTemplate createcursiumUpgradeTemplate() {
        return new ModTemplate(CURSIUM_UPGRADE_APPLIES_TO, CURSIUM_UPGRADE_INGREDIENTS, CURSIUM_UPGRADE, IGNITIUM_UPGRADE_BASE_SLOT_DESCRIPTION, IGNITIUM_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createignitiumUpgradeIconList(), createignitiumUpgradeMaterialList());
    }

    private static List<Identifier> createignitiumUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> createignitiumUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }

    public void appendTooltip(ItemStack p_267313_, Item.TooltipContext p_339591_, List<Text> p_266820_, TooltipType p_266857_) {
        super.appendTooltip(p_267313_, p_339591_, p_266820_, p_266857_);
        p_266820_.add(this.upgradeDescription);
        p_266820_.add(ScreenTexts.EMPTY);
        p_266820_.add(APPLIES_TO_TITLE);
        p_266820_.add(ScreenTexts.space().append(this.appliesTo));
        p_266820_.add(INGREDIENTS_TITLE);
        p_266820_.add(ScreenTexts.space().append(this.ingredients));
    }

    public Text getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Text getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<Identifier> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<Identifier> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }

    public String getTranslationKey() {
        return DESCRIPTION_ID;
    }
}
