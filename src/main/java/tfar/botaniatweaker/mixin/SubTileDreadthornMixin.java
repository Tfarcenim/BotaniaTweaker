package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileDreadthorn;

@Mixin(SubTileDreadthorn.class)
public class SubTileDreadthornMixin {

	@Inject(method = "getManaCost",at = @At("RETURN"),remap = false,cancellable = true)
	private void configManaCost(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.bellethorn_mana_cost.get());
	}
}
