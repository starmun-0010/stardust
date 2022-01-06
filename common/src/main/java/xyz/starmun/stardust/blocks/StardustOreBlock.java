package xyz.starmun.stardust.blocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import xyz.starmun.stardust.registry.StrataRegistry;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StardustOreBlock extends OreBlock {
    public static class StringProperty extends Property<String>{
        protected final ImmutableMap<String,String> values;
        public StringProperty(String name) {
            super(name, String.class);
            this.values = ImmutableMap.copyOf(StrataRegistry.STRATA.stream().map(stratum -> stratum.id).collect(Collectors.toMap(Function.identity(), Function.identity())));
        }

        @Override
        public Collection<String> getPossibleValues() {
            return this.values.values();
        }
        public boolean equals(Object object) {
            if (this == object) {// 38
                return true;// 39
            } else if (object instanceof StringProperty && super.equals(object)) {// 42
                StringProperty stringProperty = (StringProperty) object;// 43
                return this.values.equals(stringProperty.values);// 45
            } else {
                return false;// 48
            }
        }

        public int generateHashCode() {
            return 31 * super.generateHashCode() + this.values.hashCode();// 56
        }

        public static StringProperty create(String name) {
            return new StringProperty(name);// 22
        }
        @Override
        public Optional<String> getValue(String value) {
            return !this.values.containsKey(value)? Optional.empty(): Optional.of(this.values.get(value));
        }
        @Override
        public String getName(String comparable) {
            return comparable;
        }



    }
    public static StringProperty STRATUM = StringProperty.create("stratum");
    public StardustOreBlock(Properties properties) {
        super(properties);

        registerDefaultState(
                this.getStateDefinition()
                        .any()
                        .setValue(STRATUM, "minecraft_stone")
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STRATUM);
    }
}
