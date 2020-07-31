package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileHyacidus;

@Mixin(SubTileHyacidus.class)
public class SubTileHyacidusMixin {

	@Overwrite(remap = false)
	public int getMaxMana(){
		return BotaniaTweakerConfig.hyacidus_max_mana.get();
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
