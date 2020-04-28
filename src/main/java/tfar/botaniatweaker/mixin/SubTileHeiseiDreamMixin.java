package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileHeiseiDream;

@Mixin(SubTileHeiseiDream.class)
public class SubTileHeiseiDreamMixin {

	@Inject(method = "getMaxMana", at = @At("RETURN"), remap = false, cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.heisei_dream_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 100),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileHeiseiDream.getMana()I"),
									to = @At(value = "INVOKE", target = "java/util/List.iterator()Ljava/util/Iterator;")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.heisei_dream_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -100),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileHeiseiDream.brainwashEntity(Lnet/minecraft/entity/MobEntity;Ljava/util/List;)Z"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileHeiseiDream.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.heisei_dream_mana_cost.get();
	}
}
