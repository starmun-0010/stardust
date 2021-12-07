package xyz.starmun.stardust.data;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Collection;
import java.util.Optional;

public class OreBase extends OreBlock {
    public static class StringProperty extends Property<String>{
        protected final ImmutableList<String> values;

        public StringProperty(String name) {
            super(name, String.class);
            this.values = ImmutableList.copyOf(Stones.Stones);
        }

        @Override
        public Collection<String> getPossibleValues() {
            return this.values;
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
            return !this.values.contains(value)? Optional.empty(): Optional.of(value);
        }
        @Override
        public String getName(String comparable) {
            return comparable;
        }



    }
    public static StringProperty STRATUM = StringProperty.create("stratum");
    public OreBase(Properties properties) {
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

    @Override
    public void stepOn(Level level, BlockPos blockPos, Entity entity) {
        level.setBlockAndUpdate(blockPos, getStateDefinition().any().setValue(STRATUM, "minecraft_sand"));
        super.stepOn(level, blockPos, entity);
    }
}
