package net.earthcomputer.multiconnect.transformer;

import net.minecraft.util.Identifier;

public final class CustomPayload {
    private final Identifier value;

    public CustomPayload(Identifier value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != CustomPayload.class) return false;
        CustomPayload that = (CustomPayload) obj;
        return value.equals(that.value);
    }

    @Override
    public String toString() {
        return "CustomPayload{" + value + "}";
    }
}
