package com.github.l_ender.cataclysm.client.render.entity;

import com.github.l_ender.cataclysm.Cataclysm;
import com.github.l_ender.cataclysm.client.model.CMModelLayers;
import com.github.l_ender.cataclysm.client.model.entity.The_Prowler_Model;
import com.github.l_ender.cataclysm.client.render.layer.The_Prowler_Layer;
import com.github.l_ender.cataclysm.entity.InternalAnimationMonster.The_Prowler_Entity;
import net.minecraft.client.render.entity.EntityRendererFactory.Context;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LimbAnimator;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class The_Prowler_Renderer extends MobEntityRenderer<The_Prowler_Entity, The_Prowler_Model> {
    private final Random rnd = Random.create();
    private static final Identifier PROWLER_TEXTURES = Cataclysm.modIdentifier("textures/entity/factory/the_prowler.png");

    private static final Identifier[] TEXTURE_PROGRESS  = new Identifier[4];

    public The_Prowler_Renderer(Context renderManagerIn) {
        super(renderManagerIn, new The_Prowler_Model(renderManagerIn.getPart(CMModelLayers.PROWLER_MODEL)), 0.7F);
       // this.addLayer(new LayerGenericGlowing(this, PROWLER_LAYER_TEXTURES));
        this.addFeature(new The_Prowler_Layer(this));
        for(int i = 0; i < 4; i++){
            TEXTURE_PROGRESS[i] = Cataclysm.modIdentifier("textures/entity/factory/the_prowler_" + i + ".png");
        }

    }

    @Override
    protected float getLyingAngle(The_Prowler_Entity entity) {
        return 0;
    }

    @Override
    public Identifier getTexture(The_Prowler_Entity entity) {
        LimbAnimator walkanimationstate = entity.limbAnimator;
        int f3 = (int) walkanimationstate.getPos(entity.age);
        return getGrowingTexture(entity, (int) ((f3 * 0.5F) % 4));
    }

    public Identifier getGrowingTexture(The_Prowler_Entity entity, int age) {
        return TEXTURE_PROGRESS[MathHelper.clamp(age, 0, 4)];
    }

    public Vec3d getRenderOffset(The_Prowler_Entity entityIn, float partialTicks) {
        if (entityIn.getAttackState() == 1) {
            double d0 = 0.05D;
            return new Vec3d(this.rnd.nextGaussian() * d0, 0.0D, this.rnd.nextGaussian() * d0);
        } else {
            return super.getPositionOffset(entityIn, partialTicks);
        }
    }

    @Override
    protected void scale(The_Prowler_Entity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(1.0F, 1.0F, 1.0F);
    }
}