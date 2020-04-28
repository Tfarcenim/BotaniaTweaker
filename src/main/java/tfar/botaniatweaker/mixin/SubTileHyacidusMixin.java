package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileHyacidus;
import vazkii.botania.common.block.subtile.generating.SubTileArcaneRose;

@Mixin(SubTileHyacidus.class)
public class SubTileHyacidusMixin {
	
	@Inject(method = "getMaxMana",at = @At("HEAD"),remap = false,cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.hyacidus_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = 20),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileHyacidus.getMana()I"),
									to = @At(value = "INVOKE", target = "net/minecraft/entity/LivingEntity.getCreatureAttribute()Lnet/minecraft/entity/CreatureAttribute;")),
					remap = false)
	private int configureCost1(int original) {
		return BotaniaTweakerConfig.hyacidus_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower", constant = @Constant(intValue = -20),
					slice = @Slice(
									from = @At(value = "INVOKE", target = "net/minecraft/entity/LivingEntity.addPotionEffect(Lnet/minecraft/potion/EffectInstance;)Z"),
									to = @At(value = "INVOKE", target = "vazkii/botania/common/block/subtile/functional/SubTileHyacidus.addMana(I)V")),
					remap = false)
	private int configureCost2(int original) {
		return -BotaniaTweakerConfig.hyacidus_mana_cost.get();
	}
}
