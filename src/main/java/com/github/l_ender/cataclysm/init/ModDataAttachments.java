package com.github.l_ender.cataclysm.init;

import com.github.l_ender.cataclysm.Attachment.ChargeAttachment;
import com.github.l_ender.cataclysm.Attachment.ParryAttachment;
import com.github.l_ender.cataclysm.Attachment.RenderRushAttachment;
import com.github.l_ender.cataclysm.Attachment.TidalTentacleAttachment;
import com.github.l_ender.cataclysm.Cataclysm;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;

public class ModDataAttachments {

	public static final AttachmentType<Boolean> HOOK_FALLING = registerAttachment("hook_falling", AttachmentRegistry.<Boolean>builder().initializer(() -> false).persistent(Codec.BOOL));

	public static final AttachmentType<ChargeAttachment> CHARGE_ATTACHMENT = registerAttachment("charge_attachment", AttachmentRegistry.<ChargeAttachment>builder().initializer(ChargeAttachment::new));

	public static final AttachmentType<RenderRushAttachment> RENDER_RUSH_ATTACHMENT = registerAttachment("render_rush_attachment", AttachmentRegistry.<RenderRushAttachment>builder().initializer(RenderRushAttachment::new));

	public static final AttachmentType<TidalTentacleAttachment> TIDAL_TENTACLE_ATTACHMENT = registerAttachment("tidal_tentacle_attachment", AttachmentRegistry.<TidalTentacleAttachment>builder().initializer(TidalTentacleAttachment::new));

	public static final AttachmentType<ParryAttachment> PARRY_ATTACHMENT = registerAttachment("parry_attachment", AttachmentRegistry.<ParryAttachment>builder().initializer(ParryAttachment::new));

	private static <A> AttachmentType<A> registerAttachment(String name, AttachmentRegistry.Builder<A> builder) {
		return builder.buildAndRegister(Cataclysm.modIdentifier(name));
	}
}
