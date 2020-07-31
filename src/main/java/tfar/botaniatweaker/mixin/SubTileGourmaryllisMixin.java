package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileGourmaryllis;

@Mixin(SubTileGourmaryllis.class)
public class SubTileGourmaryllisMixin {

	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.gourmaryllis_max_mana.get();
	}
}
