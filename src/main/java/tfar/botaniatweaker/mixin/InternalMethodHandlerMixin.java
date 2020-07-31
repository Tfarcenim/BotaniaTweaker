package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.api.internal.DummyMethodHandler;
import vazkii.botania.common.core.handler.InternalMethodHandler;

@Mixin(InternalMethodHandler.class)
public class InternalMethodHandlerMixin extends DummyMethodHandler {

	@Overwrite(remap = false)
	public int getPassiveFlowerDecay() {
	return BotaniaTweakerConfig.passive_flower_decay.get();
	}
}
