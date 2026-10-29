## 2025-05-18 - Pre-compiled Regex Patterns and I/O Overhead in Calculator

**Learning:** Compiling Java `Pattern` objects repeatedly on every `Calculator.add` invocation creates significant CPU and object allocation overhead. Combining static pre-compilation with the removal of `System.out.println` debug logging inside loops reduced benchmark execution time for 100,000 iterations from ~1150ms to ~388ms (~66% speedup).

**Action:** Always pre-compile regex patterns as `private static final` constants in utility methods called repeatedly and remove unnecessary standard output operations.
