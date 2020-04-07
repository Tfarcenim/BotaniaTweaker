package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.generating.SubTileGourmaryllis;

@Mixin(SubTileGourmaryllis.class)
public class SubTileGourmaryllisMixin {
	
	@Inject(method = "getMaxMana",at = @At("RETURN"),remap = false,cancellable = true)
	private void configMaxMana(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.gourmaryllis_max_mana.get());
	}
}
