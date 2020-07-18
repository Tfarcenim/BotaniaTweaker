package tfar.botaniatweaker.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.impl.BotaniaAPIImpl;

@Mixin(BotaniaAPIImpl.class)
public class BotaniaAPIImplMixin {

	//haha balanace go brrrrr
	@Overwrite(remap = false)
	public int getPassiveFlowerDecay() {
		return BotaniaTweakerConfig.passive_flower_decay.get();
	}
}
