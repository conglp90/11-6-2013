## 2025-05-18 - Avoid Regex Recompilation and Synchronous I/O in Hot Paths

**Learning:** Recompiling `Pattern` objects inside frequently called methods (like `Pattern.compile(...)`) and leaving debug statements (`System.out.println`) in core processing logic drastically increases execution time and CPU overhead. Pre-compiling `Pattern` as `private static final Pattern` and removing synchronous stdout calls reduced execution time by ~75%.

**Action:** Always extract regex patterns into `static final` constants when called in hot loops or frequent methods, and verify no `System.out.println` debug calls remain in production logic.
