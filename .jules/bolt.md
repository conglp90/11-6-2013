## 2025-05-18 - Eliminating stdout I/O and precompiling regex in string parsing
**Learning:** Stray `System.out.println` calls inside loop matching logic in `processDelimitter` cause severe synchronous I/O bottlenecks in hot calculation paths. In addition, compiling regex `Pattern` instances per execution allocates syntax trees and match state redundantly.
**Action:** Always pre-compile `Pattern` instances to `static final` constants and ensure no debugging print statements remain in production computation paths.
