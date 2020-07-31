package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileKekimurus;

@Mixin(SubTileKekimurus.class)
public class SubTileKekimurusMixin {

	@Overwrite(remap = false)
	public int getMaxMana() {
		return BotaniaTweakerConfig.kekimurus_max_mana.get();
	}
}
