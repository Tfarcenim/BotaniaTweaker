package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.api.internal.DummyMethodHandler;
import vazkii.botania.common.core.handler.InternalMethodHandler;

@Mixin(InternalMethodHandler.class)
public class InternalMethodHandlerMixin extends DummyMethodHandler {

	@Inject(method = "getPassiveFlowerDecay",at = @At("RETURN"),cancellable = true,remap = false)
	private void configureDecay(CallbackInfoReturnable<Integer> cir){
		cir.setReturnValue(BotaniaTweakerConfig.passive_flower_decay.get());
	}
}
