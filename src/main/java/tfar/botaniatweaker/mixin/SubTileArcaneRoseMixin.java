package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileArcaneRose;

@Mixin(SubTileArcaneRose.class)
public class SubTileArcaneRoseMixin {
	
	@Inject(method = "getMaxMana",at = @At("RETURN"),remap = false,cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.rosa_arcana_max_mana.get());
	}
}
