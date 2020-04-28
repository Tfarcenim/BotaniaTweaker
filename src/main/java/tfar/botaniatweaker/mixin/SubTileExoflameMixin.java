package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileExoflame;

@Mixin(SubTileExoflame.class)
public class SubTileExoflameMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.exoflame_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -300),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/api/item/IExoflameHeatable.boostBurnTime()V"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileExoflame.addMana(I)V")),
					remap = false)
	private int configureCost(int original) {
		return BotaniaTweakerConfig.exoflame_mana_cost.get();
	}
}
