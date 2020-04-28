package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileFallenKanade;
import vazkii.botania.common.block.subtile.generating.SubTileArcaneRose;

@Mixin(SubTileFallenKanade.class)
public class SubTileFallenKanadeMixin {
	
	@Inject(method = "getMaxMana",at = @At("RETURN"),remap = false,cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.fallen_kanade_max_mana.get());
	}

	@ModifyConstant(method = "tickFlower",constant = @Constant(intValue = 120),
					slice = @Slice(
					from = @At(value = "INVOKE",target = "vazkii/botania/common/block/subtile/functional/SubTileFallenKanade.getMana()I"),
									to = @At(value = "INVOKE",target = "net/minecraft/potion/EffectInstance.<init>(Lnet/minecraft/potion/Effect;IIZZ)V")),
					remap = false)
	private int configureCost1(int original){
		return BotaniaTweakerConfig.fallen_kanade_mana_cost.get();
	}

	@ModifyConstant(method = "tickFlower",constant = @Constant(intValue = -120),
					slice = @Slice(
									from = @At(value = "INVOKE",target = "net/minecraft/entity/player/PlayerEntity.addPotionEffect(Lnet/minecraft/potion/EffectInstance;)Z"),
									to = @At(value = "INVOKE",target = "vazkii/botania/common/block/subtile/functional/SubTileFallenKanade.addMana(I)V")),
					remap = false)
	private int configureCost2(int original){
		return -BotaniaTweakerConfig.fallen_kanade_mana_cost.get();
	}
}
