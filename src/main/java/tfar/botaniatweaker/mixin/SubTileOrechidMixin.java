package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileOrechid;

@Mixin(SubTileOrechid.class)
public class SubTileOrechidMixin {

	@Inject(method = "getCost",
					at = @At("HEAD"),remap = false)
	private void configureCost(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.orechid_mana_cost.get());
	}

	@Inject(method = "getDelay",
					at = @At("HEAD"),remap = false)
	private void configureDelay(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.orechid_delay.get());
	}
}
