package com.github.l_ender.cataclysm.client.render.entity;


import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.entity.Ignis_Model;
import com.github.l_ender.cataclysm.client.render.RenderUtils;
import com.github.l_ender.cataclysm.client.render.layer.Ignis_Armor_Crack_Layer;
import com.github.l_ender.cataclysm.client.render.layer.Ignis_Shield_Layer;
import com.github.l_ender.cataclysm.entity.AnimationMonster.BossMonsters.Ignis_Entity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Ignis_Renderer extends MobEntityRenderer<Ignis_Entity, Ignis_Model> {

    private static final Identifier[] TEXTURE_PROGRESS = new Identifier[8];
    private static final Identifier[] TEXTURE_SOUL_PROGRESS = new Identifier[8];

    public Ignis_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Ignis_Model(), 1.0F);
        this.addFeature(new Ignis_Armor_Crack_Layer(this));
        this.addFeature(new Ignis_Shield_Layer(this));
        for(int i = 0; i < 8; i++){
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/ignis/ignis_idle_" + i + ".png");
            TEXTURE_SOUL_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/ignis/ignis_soul_idle_" + i + ".png");
        }
    }


    @Override
    public Identifier getTexture(Ignis_Entity entity) {
        return getGrowingTexture(entity,(int) ((entity.age * 0.5F) % 7));
    }

    public Identifier getGrowingTexture(Ignis_Entity entity, int age) {
        return entity.getBossPhase() > 0 ? TEXTURE_SOUL_PROGRESS[MathHelper.clamp(age, 0, 7)] : TEXTURE_PROGRESS[MathHelper.clamp(age, 0, 7)];
    }

    @Override
    public void render(Ignis_Entity entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int packedLightIn) {
        super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
        if (entity.getAnimation() == Ignis_Entity.HORIZONTAL_SWING_ATTACK
                || entity.getAnimation() == Ignis_Entity.SWING_ATTACK
                || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SWING_ATTACK_SOUL
                || entity.getAnimation() == Ignis_Entity.SWING_ATTACK_SOUL
                || entity.getAnimation() == Ignis_Entity.SWING_ATTACK_BERSERK
                || entity.getAnimation() == Ignis_Entity.REINFORCED_SMASH_IN_AIR
                || entity.getAnimation() == Ignis_Entity.REINFORCED_SMASH_IN_AIR_SOUL
                || entity.getAnimation() == Ignis_Entity.PHASE_3
                || entity.getAnimation() == Ignis_Entity.SPIN_ATTACK
                || entity.getAnimation() == Ignis_Entity.ULTIMATE_ATTACK
                || entity.getAnimation() == Ignis_Entity.STRIKE
                || entity.getAnimation() == Ignis_Entity.COMBO1
                || entity.getAnimation() == Ignis_Entity.COMBO2
                || entity.getAnimation() == Ignis_Entity.SHIELD_BREAK_STRIKE
                || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SMALL_SWING_ATTACK
                || entity.getAnimation() == Ignis_Entity.HORIZONTAL_SMALL_SWING_ALT_ATTACK2
                || entity.getAnimation() == Ignis_Entity.SWING_UPPERSLASH) {
            Vec3d bladePos = RenderUtils.matrixStackFromCitadelModel(entity, entityYaw, model.blade2);
            entity.setSocketPosArray(0, bladePos);
        }
    }

    protected int getBlockLight(Ignis_Entity entityIn, BlockPos pos) {
        return 15;
    }

    @Override
    protected float getLyingAngle(Ignis_Entity entity) {
        return 0;
    }

}