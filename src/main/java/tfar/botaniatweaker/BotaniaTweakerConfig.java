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

	public static IntValue mana_pool_size;
	public static IntValue diluted_mana_pool_size;
	public static IntValue fabulous_mana_pool_size;
	public static IntValue creative_mana_pool_size;

	public static IntValue agricarnation_max_mana;
	public static IntValue agricarnation_mana_cost;

	public static IntValue bellethorn_max_mana;
	public static IntValue bellethorn_mana_cost;

	public static IntValue bubbell_max_mana;
	public static IntValue bubbell_mana_cost;

	public static IntValue clayconia_max_mana;
	public static IntValue clayconia_mana_cost;

	public static IntValue dandelifeon_max_mana;

	public static IntValue dreadthorn_mana_cost;

	public static IntValue endoflame_max_mana;

	public static IntValue entropinnyum_max_mana;

	public static IntValue exoflame_max_mana;
	public static IntValue exoflame_mana_cost;

	public static IntValue fallen_kanade_max_mana;
	public static IntValue fallen_kanade_mana_cost;

	public static IntValue gourmaryllis_max_mana;

	public static IntValue heisei_dream_max_mana;
	public static IntValue heisei_dream_mana_cost;

	public static IntValue hyacidus_max_mana;
	public static IntValue hyacidus_mana_cost;

	public static IntValue hydroangeas_burn_time;
	public static IntValue hydroangeas_max_mana;

	public static IntValue jaded_amaranthus_max_mana;
	public static IntValue jaded_amaranthus_mana_cost;

	public static IntValue kekimurus_max_mana;

	public static IntValue munchdew_max_mana;

	public static IntValue narslimmus_max_mana;

	public static IntValue rafflowsia_max_mana;

	public static IntValue rosa_arcana_max_mana;

	public static IntValue shulk_me_not_max_mana;

	public static IntValue spectrolus_max_mana;

	public static IntValue loonium_max_mana;
	public static IntValue loonium_mana_cost;

	public static IntValue marimorphosis_max_mana;
	public static IntValue marimorphosis_mana_cost;

	public static IntValue orechid_mana_cost;
	public static IntValue orechid_delay;

	public static IntValue orechid_ignem_mana_cost;

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
		builder.push("misc");

		passive_flower_decay = builder.defineInRange("passive_flower_decay",72000,1,Integer.MAX_VALUE);

		mana_pool_size = builder.defineInRange("mana_pool_size",1000000,1,Integer.MAX_VALUE);

		diluted_mana_pool_size = builder.defineInRange("diluted_mana_pool_size",1000000,1,Integer.MAX_VALUE);

		fabulous_mana_pool_size = builder.defineInRange("fabulous_mana_pool_size",1000000,1,Integer.MAX_VALUE);

		creative_mana_pool_size = builder.defineInRange("creative_mana_pool_size",1000000,1,Integer.MAX_VALUE);


		builder.pop();

		builder.push("generating flowers");
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
		builder.pop(2);

		builder.push("functional flowers");
		builder.push("agricarnation");
		agricarnation_max_mana = builder.defineInRange("agricarnation_max_mana",200,1,Integer.MAX_VALUE);
		agricarnation_mana_cost = builder.defineInRange("agricarnation_mana_cost",5,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("bellethorn");
		bellethorn_max_mana = builder.defineInRange("bellethorn_max_mana",1000,1,Integer.MAX_VALUE);
		bellethorn_mana_cost = builder.defineInRange("bellethorn_mana_cost",24,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("bubbell");
		bubbell_max_mana = builder.defineInRange("bubbell_max_mana",2000,1,Integer.MAX_VALUE);
		bubbell_mana_cost = builder.defineInRange("bubbell_mana_cost",4,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("clayconia");
		clayconia_max_mana = builder.defineInRange("clayconia_max_mana",640,1,Integer.MAX_VALUE);
		clayconia_mana_cost = builder.defineInRange("clayconia_mana_cost",80,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("dreadthorn");
		dreadthorn_mana_cost = builder.defineInRange("dreadthorn_mana_cost",30,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("exoflame");
		exoflame_max_mana = builder.defineInRange("exoflame_max_mana",300,1,Integer.MAX_VALUE);
		exoflame_mana_cost = builder.defineInRange("exoflame_mana_cost", 300,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("fallen_kanade");
		fallen_kanade_max_mana = builder.defineInRange("fallen_kanade_max_mana",900,1,Integer.MAX_VALUE);
		fallen_kanade_mana_cost = builder.defineInRange("fallen_kanade_mana_cost",120,1,Integer.MAX_VALUE);
		builder.pop();

		builder.push("heisei_dream");
		heisei_dream_max_mana = builder.defineInRange("bellethorn_max_mana",1000,1,Integer.MAX_VALUE);
		hyacidus_max_mana = builder.defineInRange("hyacidus_max_mana",180,1,Integer.MAX_VALUE);
		builder.pop();
		builder.push("hyacidus");
		hyacidus_max_mana = builder.defineInRange("hyacidus_max_mana",180,1,Integer.MAX_VALUE);
		hyacidus_mana_cost = builder.defineInRange("hyacidus_mana_cost",20,1,Integer.MAX_VALUE);
		builder.pop();
		builder.push("loonium");
		loonium_max_mana = builder.defineInRange("loonium_max_mana",35000,1,Integer.MAX_VALUE);
		loonium_mana_cost = builder.defineInRange("loonium_mana_cost",35000,1,Integer.MAX_VALUE);
		builder.pop();
		builder.push("marimorphosis");
		marimorphosis_max_mana = builder.defineInRange("marimorphosis_max_mana",12,1,Integer.MAX_VALUE);
		marimorphosis_mana_cost = builder.defineInRange("marimorphosis_mana_cost",12,1,Integer.MAX_VALUE);
		builder.pop();
		builder.push("orechid");
		orechid_mana_cost = builder.defineInRange("orechid_mana_cost",15000,1,Integer.MAX_VALUE);
		orechid_delay = builder.defineInRange("orechid_delay",100,1,Integer.MAX_VALUE);
		builder.pop();
		builder.push("orechid_ignem");
		orechid_ignem_mana_cost = builder.defineInRange("orechid_ignem_mana_cost",20000,1,Integer.MAX_VALUE);
		builder.pop(2);
	}
}
