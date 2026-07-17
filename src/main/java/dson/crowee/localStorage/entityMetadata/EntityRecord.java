package dson.crowee.localStorage.entityMetadata;

public record EntityRecord(
        String formalName,
        String spriteSheetRelatievPath,
        int spriteInitX,
        int spriteInitY,
        int spriteEndX,
        int spriteEndY,
        int x,
        int y,
        int triggerHeight,
        int triggerWidth
) {}
