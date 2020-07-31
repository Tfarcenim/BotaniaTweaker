package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileLoonuim;

@Mixin(SubTileLoonuim.class)
public class SubTileLooniumMixin {

	@Overwrite(remap = false)
	public int getMaxMana() {
		return BotaniaTweakerConfig.loonium_max_mana.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 35000),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.loonium_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -35000),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.loonium_mana_cost.get();
	}

}
