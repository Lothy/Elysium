package org.moparscape.elysium.net.codec.decoder;

import io.netty.buffer.ByteBuf;
import org.moparscape.elysium.net.codec.decoder.message.WallObjectPrimaryActionMessage;

/**
 * Created by IntelliJ IDEA.
 *
 * @author lothy
 */
public final class WallObjectPrimaryActionMessageDecoder extends AbstractMessageDecoder<WallObjectPrimaryActionMessage> {

    public WallObjectPrimaryActionMessageDecoder() {
        super(WallObjectPrimaryActionMessage.class, 126);
    }

    public WallObjectPrimaryActionMessage decode(ByteBuf buffer, int length) {
        throw new UnsupportedOperationException();
    }
}
