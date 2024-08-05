package net.swift984.poopiummod.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swift984.poopiummod.PoopiumMod;

import java.rmi.registry.Registry;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, PoopiumMod.MOD_ID);

    public static final RegistryObject<SoundEvent> FOUND_POOPIUM = registerSoundEvents("found_poopium");

    public static final RegistryObject<SoundEvent> POOPTUNES = registerSoundEvents("pooptunes");
    public static final RegistryObject<SoundEvent> OMBLY = registerSoundEvents("ombly");
    public static final RegistryObject<SoundEvent> WADE = registerSoundEvents("wade");

    public static final RegistryObject<SoundEvent> SOUND_POOPIUM_BREAK = registerSoundEvents("sound_poopium_break");
    public static final RegistryObject<SoundEvent> SOUND_POOPIUM_STEP = registerSoundEvents("sound_poopium_step");
    public static final RegistryObject<SoundEvent> SOUND_POOPIUM_FALL = registerSoundEvents("sound_poopium_fall");
    public static final RegistryObject<SoundEvent> SOUND_POOPIUM_PLACE = registerSoundEvents("sound_poopium_place");
    public static final RegistryObject<SoundEvent> SOUND_POOPIUM_HIT = registerSoundEvents("sound_poopium_hit");


    public static final ForgeSoundType POOPIUM_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.SOUND_POOPIUM_BREAK,ModSounds.SOUND_POOPIUM_STEP,ModSounds.SOUND_POOPIUM_FALL,
            ModSounds.SOUND_POOPIUM_PLACE, ModSounds.SOUND_POOPIUM_HIT);



    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(PoopiumMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
