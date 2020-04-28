package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileLoonuim;

@Mixin(SubTileLoonuim.class)
public class SubTileLooniumMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.loonium_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 35000),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileLoonuim.getMana()I"),
									to = @At(value = "INVOKE", target = "net/minecraft/world/World.getDifficulty()Lnet/minecraft/world/Difficulty;")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.loonium_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -35000),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "net/minecraft/entity/monster/MonsterEntity.spawnExplosionParticle()V"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileLoonuim.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.loonium_mana_cost.get();
	}

}
