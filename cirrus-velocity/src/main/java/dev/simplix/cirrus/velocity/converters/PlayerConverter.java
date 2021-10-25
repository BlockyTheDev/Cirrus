package dev.simplix.cirrus.velocity.converters;

import com.velocitypowered.api.proxy.Player;
import dev.simplix.cirrus.api.business.PlayerWrapper;
import dev.simplix.cirrus.api.converter.Converter;
import dev.simplix.cirrus.velocity.VelocityPlayerWrapper;
import lombok.NonNull;

public final class PlayerConverter implements Converter<Player, PlayerWrapper> {

    @Override
    public PlayerWrapper convert(@NonNull Player proxiedPlayer) {
        return new VelocityPlayerWrapper(proxiedPlayer);
    }

}
