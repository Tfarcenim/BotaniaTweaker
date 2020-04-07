package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileThermalily;

@Mixin(SubTileThermalily.class)
public class SubTileThermalilyMixin {
	@Inject(method = "getBurnTime",at = @At("RETURN"),remap = false,cancellable = true)
	private void configBurnTime(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.thermalily_burn_time.get());
	}

	@Inject(method = "getMaxMana",at = @At("RETURN"),remap = false,cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.thermalily_max_mana.get());
	}

	@Inject(method = "getCooldown",at = @At("RETURN"),remap = false,cancellable = true)
	private void configCooldown(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.thermalily_cooldown.get());
	}

}
