package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileHydroangeas;

@Mixin(SubTileHydroangeas.class)
public class SubTileHydroangeasMixin {

	@Overwrite(remap = false)
	public int getBurnTime(){
		return BotaniaTweakerConfig.hydroangeas_burn_time.get();
	}

	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.hydroangeas_max_mana.get();
	}
}
