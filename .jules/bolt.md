## 2025-05-18 - Pre-compile Regex Patterns in Java
**Learning:** Compiling regex patterns on every method invocation introduces significant CPU overhead in Java. Pre-compiling static final `Pattern` constants avoids redundant parsing while maintaining thread safety (`Pattern` is thread-safe, whereas `Matcher` is per-thread/invocation). Additionally, removing extraneous `System.out.println` calls eliminates unnecessary synchronous I/O overhead.
**Action:** Always extract static regex patterns to `private static final Pattern` fields in Java utility classes.
