package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileThermalily;

@Mixin(SubTileThermalily.class)
public class SubTileThermalilyMixin {
	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.thermalily_max_mana.get();
	}

	@Overwrite(remap = false)
	public int getCooldown(){
		return BotaniaTweakerConfig.thermalily_cooldown.get();
	}

	@Overwrite(remap = false)
	public int getBurnTime(){
		return BotaniaTweakerConfig.thermalily_burn_time.get();
	}

}
