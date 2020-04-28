package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileClayconia;
import vazkii.botania.common.block.subtile.functional.SubTileJadedAmaranthus;

@Mixin(SubTileJadedAmaranthus.class)
public class SubTileJadedAmaranthusMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.jaded_amaranthus_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 100),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileJadedAmaranthus.getMana()I"),
									to = @At(value = "NEW", target = "net/minecraft/util/math/BlockPos")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.jaded_amaranthus_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -100),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "net/minecraft/world/World.addEntity(Lnet/minecraft/entity/Entity;)Z"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileClayconia.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.jaded_amaranthus_mana_cost.get();
	}
}
