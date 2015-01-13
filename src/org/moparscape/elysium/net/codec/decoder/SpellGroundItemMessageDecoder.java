package org.moparscape.elysium.net.codec.decoder;

import io.netty.buffer.ByteBuf;
import org.moparscape.elysium.net.codec.decoder.message.SpellGroundItemMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lothy
 */
public final class SpellGroundItemMessageDecoder extends AbstractMessageDecoder<SpellGroundItemMessage> {

    public SpellGroundItemMessageDecoder() {
        super(SpellGroundItemMessage.class, 104);
    }

    public SpellGroundItemMessage decode(ByteBuf buffer, int length) {
        throw new UnsupportedOperationException();
    }
}
