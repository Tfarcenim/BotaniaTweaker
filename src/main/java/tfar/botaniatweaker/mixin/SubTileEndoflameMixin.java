package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileEndoflame;

@Mixin(SubTileEndoflame.class)
public class SubTileEndoflameMixin {

	@Overwrite(remap = false)
	public int getMaxMana() {
		return BotaniaTweakerConfig.endoflame_max_mana.get();
	}
}
