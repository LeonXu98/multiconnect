package net.earthcomputer.multiconnect.protocols.v1_12_2.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandSource;

import static net.earthcomputer.multiconnect.protocols.v1_12_2.command.Commands_1_12_2.*;
import static net.minecraft.command.arguments.BlockPosArgumentType.*;
import static net.minecraft.command.arguments.NbtCompoundTagArgumentType.*;

public class BlockDataCommand {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(literal("blockdata")
            .then(argument("pos", blockPos())
                .then(argument("nbt", nbtCompound())
                    .executes(ctx -> 0))));
    }

}
