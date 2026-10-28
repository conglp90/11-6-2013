## 2025-05-18 - Pre-compiled Regex Patterns and I/O Overhead in String Parsing
**Learning:** Re-compiling `Pattern.compile(...)` inside frequently called methods and leftover `System.out.println()` debug statements in hot code paths create significant execution overhead in Java applications. Pre-compiling patterns to `private static final Pattern` instances and removing stdout I/O reduced benchmark execution time by ~50%.
**Action:** Always check string/delimiter parsing methods in Java codebases for un-cached regex pattern compilation and stray `System.out.println` statements.
