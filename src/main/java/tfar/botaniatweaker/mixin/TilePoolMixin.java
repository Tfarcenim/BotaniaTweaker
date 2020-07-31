package tfar.botaniatweaker.mixin;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import tfar.botaniatweaker.BotaniaTweakerConfig;
import vazkii.botania.common.block.mana.BlockPool;
import vazkii.botania.common.block.tile.mana.TilePool;

@Mixin(TilePool.class)
abstract class TilePoolMixin extends TileEntity {

	public TilePoolMixin(TileEntityType<?> p_i48289_1_) {
		super(p_i48289_1_);
	}

	//pools except diluted
	@ModifyConstant(method = "tick", constant = @Constant(intValue = 1000000))
	private int config(int original) {
		BlockPool blockpool = ((BlockPool)this.getBlockState().getBlock());
		switch (blockpool.variant){
			case DEFAULT: return BotaniaTweakerConfig.mana_pool_size.get();
			case FABULOUS: return BotaniaTweakerConfig.fabulous_mana_pool_size.get();
			case CREATIVE: return BotaniaTweakerConfig.creative_mana_pool_size.get();
		}
		return original;
	}

	//diluted pool only
	@ModifyConstant(method = "tick", constant = @Constant(intValue = 10000))
	private int configDiluted(int original) {
		BlockPool blockpool = ((BlockPool)this.getBlockState().getBlock());
		if (blockpool.variant == BlockPool.Variant.DILUTED) {
			return BotaniaTweakerConfig.diluted_mana_pool_size.get();
		}
		return original;
	}
}
