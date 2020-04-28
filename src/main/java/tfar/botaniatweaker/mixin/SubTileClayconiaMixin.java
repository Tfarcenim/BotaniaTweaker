package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileAgricarnation;
import vazkii.botania.common.block.subtile.functional.SubTileClayconia;

@Mixin(SubTileClayconia.class)
public class SubTileClayconiaMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.clayconia_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 80),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileClayconia.getMana()I"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileClayconia.getCoordsToPut()Lnet/minecraft/util/math/BlockPos;")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.clayconia_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -80),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "net/minecraft/world/World.addEntity(Lnet/minecraft/entity/Entity;)Z"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileClayconia.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.clayconia_mana_cost.get();
	}
}
