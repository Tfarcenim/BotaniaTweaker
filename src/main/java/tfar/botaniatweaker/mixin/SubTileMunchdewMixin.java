package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileMunchdew;

@Mixin(SubTileMunchdew.class)
public class SubTileMunchdewMixin {

	@Overwrite(remap = false)
	public int getMaxMana() {
		return BotaniaTweakerConfig.munchdew_max_mana.get();
	}
}
