package com.teamaurora.frostburn_expansion.common.world.gen.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.gen.feature.IFeatureConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotShitOreFeatureConfig implements IFeatureConfig {
    public static final Codec<com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig> field_236566_a_ = RecordCodecBuilder.create((p_236568_0_) -> {
        return p_236568_0_.group(com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType.field_236571_d_.fieldOf("target").forGetter((p_236570_0_) -> {
            return p_236570_0_.target;
        }), BlockState.BLOCKSTATE_CODEC.fieldOf("state").forGetter((p_236569_0_) -> {
            return p_236569_0_.state;
        }), Codec.INT.fieldOf("size").withDefault(0).forGetter((p_236567_0_) -> {
            return p_236567_0_.size;
        })).apply(p_236568_0_, com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig::new);
    });
    public final com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType target;
    public final int size;
    public final BlockState state;

    public NotShitOreFeatureConfig(com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }

    public static enum FillerBlockType implements IStringSerializable, net.minecraftforge.common.IExtensibleEnum {
        ALL_ICE("all_ice", (p_214739_0_) -> {
            if (p_214739_0_ == null) {
                return false;
            } else {
                return p_214739_0_.isIn(Blocks.PACKED_ICE) || p_214739_0_.isIn(Blocks.ICE);
            }
        }),
        PACKED_ICE("packed_ice", new BlockMatcher(Blocks.PACKED_ICE));

        public static final Codec<com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType> field_236571_d_ = IStringSerializable.createEnumCodec(com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType::values, com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType::byName);
        /** maps the filler block type name to the corresponding enum value. */
        private static final Map<String, com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType> VALUES_MAP = Arrays.stream(values()).collect(Collectors.toMap(com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType::getName, (p_236573_0_) -> {
            return p_236573_0_;
        }));
        /** the filler block type name. */
        private final String name;
        /** the predicate to match the target block to fill */
        private final Predicate<BlockState> targetBlockPredicate;

        private FillerBlockType(String nameIn, Predicate<BlockState> predicateIn) {
            this.name = nameIn;
            this.targetBlockPredicate = predicateIn;
        }

        /**
         * returns the name of the filler block type.
         */
        public String getName() {
            return this.name;
        }

        /**
         * returns the filler block type with the given name.
         *
         * @param nameIn the filler block type name
         */
        public static com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType byName(String nameIn) {
            return VALUES_MAP.get(nameIn);
        }

        public static com.teamaurora.frostburn_expansion.common.world.gen.feature.NotShitOreFeatureConfig.FillerBlockType create(String enumName, String nameIn, Predicate<BlockState> predicateIn) {
            throw new IllegalStateException("Enum not extended");
        }

        @Override
        @Deprecated
        public void init() {
            VALUES_MAP.put(getName(), this);
        }

        /**
         * returns the target block state predicate
         */
        public Predicate<BlockState> getTargetBlockPredicate() {
            return this.targetBlockPredicate;
        }

        public String getString() {
            return this.name;
        }
    }
}
