package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileAgricarnation;
import vazkii.botania.common.block.subtile.functional.SubTileMarimorphosis;

@Mixin(SubTileMarimorphosis.class)
public class SubTileMarimorphosisMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.marimorphosis_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 12),
					slice = @Slice(from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileMarimorphosis.getMana()I"))
					,
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.marimorphosis_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -12),
					slice = @Slice(
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileMarimorphosis.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.marimorphosis_mana_cost.get();
	}
}
