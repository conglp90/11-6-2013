## 2025-05-16 - Pre-compiling Regex Patterns in String Calculator

**Learning:** Repeatedly compiling regex patterns in hot execution paths (`add`, `processDelimitter`, `toArrayListNumbers`) creates unnecessary object allocation and CPU parsing overhead. `Pattern` objects in Java are thread-safe and immutable.
**Action:** Always pre-compile `Pattern` objects as `private static final` constants when used in utility functions called frequently.
