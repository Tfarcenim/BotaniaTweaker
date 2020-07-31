package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileShulkMeNot;

@Mixin(SubTileShulkMeNot.class)
public class SubTileShulkMeNotMixin {

	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.shulk_me_not_max_mana.get();
	}
}
