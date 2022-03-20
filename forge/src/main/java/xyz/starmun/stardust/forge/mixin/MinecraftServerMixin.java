package xyz.starmun.stardust.forge.mixin;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.world.level.DataPackConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import xyz.starmun.stardust.data.inmemory.InMemoryRepositorySource;

@Mixin(MinecraftServer.class)

public class MinecraftServerMixin {
    @Inject(method = "configurePackRepository", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/server/packs/repository/PackRepository;reload()V",
            shift = At.Shift.BEFORE))
    private static void onReloadDatapacks(PackRepository packRepository, DataPackConfig dataPackConfig, boolean bl, CallbackInfoReturnable<DataPackConfig> cir) {
        packRepository.addPackFinder(InMemoryRepositorySource.INSTANCE);
    }}
