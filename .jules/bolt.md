## 2025-05-10 - Pre-compiling Java Regex Patterns
**Learning:** Instantiating `Pattern.compile(...)` inside frequently executed methods causes repeated regex parsing overhead. Java `Pattern` instances are immutable and thread-safe.
**Action:** Always pre-compile regular expressions into `private static final Pattern` constants when used repeatedly.
