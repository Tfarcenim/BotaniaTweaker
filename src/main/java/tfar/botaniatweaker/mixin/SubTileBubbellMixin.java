package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileBubbell;

@Mixin(SubTileBubbell.class)
public class SubTileBubbellMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.bubbell_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 4),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileBubbell.getMana()I"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileBubbell.addMana(I)V")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.bubbell_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -4),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileBubbell.getMana()I"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileBubbell.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.bubbell_mana_cost.get();
	}

	@ModifyConstant(method = "isValidBubbell",constant = @Constant(intValue = 4),remap = false)
	private static int configureCost3(int original) {
		return -BotaniaTweakerConfig.bubbell_mana_cost.get();
	}
}
