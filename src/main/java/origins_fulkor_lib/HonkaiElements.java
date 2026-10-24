package origins_fulkor_lib;

//Honkai Starrail elements

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.List;

public enum HonkaiElements {
    PHYSICAL("physical", 0xFFB8B8B8),
    FIRE("fire", 0xFFFF5A2A),
    ICE("ice", 0xFF6FD8FF),
    LIGHTNING("lightning", 0xFFC77BFF),
    WIND("wind", 0xFF5FE0A8),
    QUANTUM("quantum", 0xFF6A5CFF),
    IMAGINARY("imaginary", 0xFFFFE066);

    public final String id;
    public final int color;
    public final RegistryKey<DamageType> damageType;
    public final TagKey<DamageType> tag;

    HonkaiElements(String id, int color) {
        this.id = id;
        this.color = color;
        this.damageType = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(OriginsBrilliance.MOD_ID, "honkai/" + id));
        this.tag = TagKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(OriginsBrilliance.MOD_ID, "honkai_element/" + id));
    }

    public static HonkaiElements getElement(String name) {
        for (HonkaiElements element : values()) if (element.id.equals(name)) return element;
        return null;
    }

    public static List<String> getAllElements() {
        return Arrays.stream(values()).map(element -> element.id).toList();
    }

    public static HonkaiElements of(DamageSource source) {
        for (HonkaiElements element : values()) if(source.isIn(element.tag)) return element;
        return null;
    }
}
