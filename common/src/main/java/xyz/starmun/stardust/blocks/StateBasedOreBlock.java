package xyz.starmun.stardust.blocks;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.storage.loot.LootContext;
import xyz.starmun.stardust.registry.StrataRegistry;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StateBasedOreBlock extends OreBlock {
    public boolean dropSelf = false;
    public static class StringProperty extends Property<String>{
        protected final ImmutableMap<String,String> values;
        public StringProperty(String name) {
            super(name, String.class);
            this.values = ImmutableMap.copyOf(StrataRegistry.STRATA.stream().map(stratum -> stratum.getId()).collect(Collectors.toMap(Function.identity(), Function.identity())));
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
    public StateBasedOreBlock(Properties properties) {
        super(properties);
        if(StrataRegistry.STRATA.size()>1){
            registerDefaultState(
                this.getStateDefinition()
                        .any()
                        .setValue(STRATUM, "minecraft_stone")
            );
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(blockState, builder);
        if(!dropSelf)return drops;
        drops.add(this.asItem().getDefaultInstance());
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {

        if(StrataRegistry.STRATA.size() > 1){
            builder.add(STRATUM);
        }
    }
}
