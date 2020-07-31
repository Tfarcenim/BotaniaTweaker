package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileDandelifeon;

@Mixin(SubTileDandelifeon.class)
public class SubTileDandelifeonMixin {

	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.dandelifeon_max_mana.get();
	}
}
