package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileAgricarnation;

@Mixin(SubTileAgricarnation.class)
public class SubTileAgricarnationMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.agricarnation_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 5),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileAgricarnation.getMana()I")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.agricarnation_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -5),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.getBlock()Lnet/minecraft/block/Block;"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileAgricarnation.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.agricarnation_mana_cost.get();
	}
}
