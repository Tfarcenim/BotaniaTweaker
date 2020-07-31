package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileArcaneRose;

@Mixin(SubTileArcaneRose.class)
public class SubTileArcaneRoseMixin {

	@Overwrite(remap = false)
	public int getMaxMana() {
		return BotaniaTweakerConfig.rosa_arcana_max_mana.get();
	}
}
