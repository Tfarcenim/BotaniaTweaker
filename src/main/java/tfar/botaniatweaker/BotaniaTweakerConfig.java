package tfar.botaniatweaker;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BotaniaTweakerConfig.MODID)
public class BotaniaTweakerConfig {

	public static final String MODID = "botaniatweaker";

	private static final Logger LOGGER = LogManager.getLogger();

	public static IntValue passive_flower_decay;

	public static IntValue dandelifeon_max_mana;

	public static IntValue endoflame_max_mana;

	public static IntValue entropinnyum_max_mana;

	public static IntValue gourmaryllis_max_mana;

	public static IntValue hydroangeas_burn_time;
	public static IntValue hydroangeas_max_mana;

	public static IntValue kekimurus_max_mana;

	public static IntValue munchdew_max_mana;

	public static IntValue narslimmus_max_mana;

	public static IntValue rafflowsia_max_mana;

	public static IntValue rosa_arcana_max_mana;

	public static IntValue shulk_me_not_max_mana;

	public static IntValue spectrolus_max_mana;

	public static IntValue thermalily_burn_time;
	public static IntValue thermalily_cooldown;
	public static IntValue thermalily_max_mana;

	public BotaniaTweakerConfig() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_SPEC);
	}

	public static final BotaniaTweakerConfig SERVER;
	public static final ForgeConfigSpec SERVER_SPEC;

	static {
		final Pair<BotaniaTweakerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(BotaniaTweakerConfig::new);
		SERVER_SPEC = specPair.getRight();
		SERVER = specPair.getLeft();
	}

	public BotaniaTweakerConfig(ForgeConfigSpec.Builder builder) {
		builder.push("general");
		passive_flower_decay = builder.defineInRange("passive_flower_decay",72000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("dandelifeon");
		dandelifeon_max_mana = builder.defineInRange("dandelifeon_max_mana",50000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("endoflame");
		endoflame_max_mana = builder.defineInRange("endoflame_max_mana",300,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("entropinnyum");
		entropinnyum_max_mana = builder.defineInRange("entropinnyum_max_mana",6500,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("gourmaryllis");
		gourmaryllis_max_mana = builder.defineInRange("gourmaryllis_max_mana",9000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("hydroangeas");
		hydroangeas_burn_time = builder.defineInRange("hydroangeas_burn_time",900,1,Integer.MAX_VALUE);
		hydroangeas_max_mana = builder.defineInRange("hydroangeas_max_mana",500,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("kekimurus");
		kekimurus_max_mana = builder.defineInRange("kekimurus_max_mana",9001,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("munchdew");
		munchdew_max_mana = builder.defineInRange("munchdew_max_mana",10000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("narslimmus");
		narslimmus_max_mana = builder.defineInRange("narslimmus_max_mana",12000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("rafflowsia");
		rafflowsia_max_mana = builder.defineInRange("rafflowsia_max_mana",9000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("rosa_arcana");
		rosa_arcana_max_mana = builder.defineInRange("rosa_arcana_max_mana",6000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("shulk_me_not");
		shulk_me_not_max_mana = builder.defineInRange("shulk_me_not_max_mana",75000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("spectrolus");
		spectrolus_max_mana = builder.defineInRange("spectrolus_max_mana",16000,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("thermalily");
		thermalily_burn_time = builder.defineInRange("thermalily_burn_time",40,1,Integer.MAX_VALUE);
		thermalily_cooldown = builder.defineInRange("thermalily_cooldown",6000,0, Integer.MAX_VALUE);
		thermalily_max_mana = builder.defineInRange("thermalily_max_mana",150,1,Integer.MAX_VALUE);
		builder.pop();
	}
}
