package com.tmax.flowengine.adapter.protocol;

import java.nio.ByteBuffer;

/**
 * Adapter 에서 데이터 송,수신시 항시 따라붙는 헤더를 정의한다.<br>
 * Magic Number 와 Body Length 의 정보를 정의하도록 하며, 필요한 경우 확장하여 사용할 수 있도록 한다.<br>
 * -------------------------------------------------------------------------------------------------------------------------<br>
 * |　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|<br>
 * 0　　　　　　　4　　　　　　　8　　　　　　 12　　　　　　 16　　　　　　 20　　　　　　 24　　　　　　 28　　　　　　 32<br>
 * |　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|　　　　　　　|<br>
 * -------------------------------------------------------------------------------------------------------------------------<br>
 * | Magic | Type | Body  Length | 　　　　　　　　　　　　　　　　　　RESERVED　　　　　　　　　　　　　　　　　　 　     |<br>
 * -------------------------------------------------------------------------------------------------------------------------<br>
 * 
 * @author Junsoo Jeong
 * @since  7.0.0.0.0
 */
public class AdapterHeader {
    public enum Type {
        HANDSHAKE((short)0x01),
        REQUEST((short)0x10),
        RESPONSE((short)0x20);
        
        
        
        
        public static Type fromShort(short typeAsShort) {
            for(Type type : Type.values()) {
                if(type.toShort() == typeAsShort) {
                    return type;
                }
            }
            return null;
        }
        
        
        private short type;
        
        
        private Type(short type) {
            this.type = type;
        }
        
        public short toShort() {
            return type;
        }
    }
    
    public static final int     LENGTH          = 32;
    public static final short   MAGIC_NUMBER    = (short)0xC0DE;
    
    
    private static byte[]           PADDING         = null;
    
    
    
    
    
    /**
     * 정상적인 패킷 여부를 검사할 수 있는 상수를 저장한다. (상수는 0xC0DE). 
     */
    private short   magicNumber;
    /**
     * 메시지 타입을 지정한다.
     */
    private short   type;
    /**
     * Body 의 총 크기를 지정한다.
     */
    private int     bodyLength;
    
    
    public AdapterHeader() {
        magicNumber = MAGIC_NUMBER;
    }
    
    public ByteBuffer pack() {
        return pack(ByteBuffer.allocateDirect(LENGTH));
    }
    
    public ByteBuffer pack(ByteBuffer buffer) {
        buffer.putShort(getMagicNumber());
        buffer.putShort(getType());
        buffer.putInt(getBodyLength());
        
        if(PADDING == null) {
            PADDING = new byte[LENGTH - buffer.position()];
        }
        buffer.put(PADDING);
        return buffer;
    }
    
    public void unpack(ByteBuffer buffer) {
        setMagicNumber(buffer.getShort());
        setType(buffer.getShort());
        setBodyLength(buffer.getInt());
        
        if(PADDING == null) {
            PADDING = new byte[LENGTH - buffer.position()];
        }
        buffer.get(PADDING);
    }
    
    public short getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(short magicNumber) {
        this.magicNumber = magicNumber;
    }
    
    public short getType() {
        return type;
    }

    public void setType(short type) {
        this.type = type;
    }
    
    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }
}
