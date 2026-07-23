package dson.crowee.localStorage.entityMetadata;

public record EntityRecord(
        String formalName,
        String spriteSheetRelativePath,
        int spriteInitX,
        int spriteInitY,
        int spriteEndX,
        int spriteEndY,
        int spriteHeight,
        int spriteWidth,
        int x,
        int y,
        int triggerHeight,
        int triggerWidth
) {}
