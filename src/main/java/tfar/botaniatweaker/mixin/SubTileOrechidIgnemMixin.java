package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.subtile.functional.SubTileOrechidIgnem;

@Mixin(SubTileOrechidIgnem.class)
public class SubTileOrechidIgnemMixin {

	@Inject(method = "getCost",
					at = @At("HEAD"),remap = false,cancellable = true)
	private void configureCost(CallbackInfoReturnable<Integer> cir) {
		cir.setReturnValue(BotaniaTweakerConfig.orechid_ignem_mana_cost.get());
	}
}
