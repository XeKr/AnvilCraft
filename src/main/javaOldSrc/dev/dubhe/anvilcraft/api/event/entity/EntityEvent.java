package dev.dubhe.anvilcraft.api.event.entity;

import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;

@Getter
public class EntityEvent<T extends Entity> extends Event {
    private final T entity;
    private final BlockPos pos;
    private final Level level;

    /**
     * 实体事件
     *
     * @param entity 实体
     * @param pos    位置
     * @param level  世界
     */
    public EntityEvent(T entity, BlockPos pos, Level level) {
        this.entity = entity;
        this.pos = pos;
        this.level = level;
    }
}