package net.swift984.poopiummod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.swift984.poopiummod.sound.ModSounds;

public class PoopiumItem extends Item {
    public PoopiumItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            pContext.getLevel().playSeededSound(null, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
                    ModSounds.FOUND_POOPIUM.get(), SoundSource.BLOCKS, 1f, 1f, 0);

        }

        return InteractionResult.SUCCESS;
    }
}
